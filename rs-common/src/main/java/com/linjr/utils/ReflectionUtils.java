package com.linjr.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 反射工具类.
 * <p>
 * 提供访问私有变量,获取泛型类型Class, 提取集合中元素的属性, 转换字符串到对象等Util函数.
 */
public class ReflectionUtils {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    /**
     * 调用Getter方法.
     */
    public static Object invokeGetterMethod(Object obj, String propertyName) {
        String getterMethodName = "get" + StringUtils.capitalize(propertyName);
        return invokeMethod(obj, getterMethodName, null, new Object[] {});
    }

    /**
     * 调用Setter方法.使用value的Class来查找Setter方法.
     */
    public static void invokeSetterMethod(Object obj, String propertyName, Object value) {
        invokeSetterMethod(obj, propertyName, value, null);
    }

    /**
     * 调用Setter方法.
     *
     * @param propertyType 用于查找Setter方法,为空时使用value的Class替代.
     */
    public static void invokeSetterMethod(Object obj, String propertyName, Object value, Class<?> propertyType) {
        Class<?> type = propertyType != null ? propertyType : value.getClass();
        String setterMethodName = "set" + StringUtils.capitalize(propertyName);
        invokeMethod(obj, setterMethodName, type,  value );
    }

    /**
     * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
     */
    public static Object getFieldValue(final Object obj, final String fieldName) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        Object result = null;
        try {
            result = field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常{}", e.getMessage());
        }
        return result;
    }

    /**
     * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
     */
    public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常:{}", e.getMessage());
        }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredField,     并强制设置为可访问.
     * <p>
     * 如向上转型到Object仍无法找到, 返回null.
     */
    public static Field getAccessibleField(final Object obj, final String fieldName) {
        Assert.notNull(obj, "object不能为空");
        Assert.hasText(fieldName, "fieldName");
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) {//NOSONAR
                // Field不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 直接调用对象方法, 无视private/protected修饰符.
     * 用于一次性调用的情况.
     */
    public static Object invokeMethod(final Object obj, final String methodName, final Class<?> tClass, final Object args) {
        Method method = getAccessibleMethod(obj, methodName, tClass);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        }
        try {
            return method.invoke(obj, args);
//            return method.invoke(obj, "1000");
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问.
     * 如向上转型到Object仍无法找到, 返回null.
     * <p>
     * 用于方法需要被多次调用的情况. 先使用本函数先取得Method,然后调用Method.invoke(Object obj, Object... args)
     */
    public static Method getAccessibleMethod(final Object obj, final String methodName, final Class<?> tClass) {

        Assert.notNull(obj, "object不能为空");

        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Method method = superClass.getDeclaredMethod(methodName, new Class[] { tClass });
                method.setAccessible(true);

                return method;

            } catch (NoSuchMethodException e) {//NOSONAR
                // Method不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型.
     * 如无法找到, 返回Object.class.
     * eg.
     * public UserDao extends HibernateDao<User>
     *
     * @param clazz The class to introspect
     * @return the first generic declaration, or Object.class if cannot be determined
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> Class<T> getSuperClassGenricType(final Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型.
     * 如无法找到, 返回Object.class.
     * <p>
     * 如public UserDao extends HibernateDao<User,Long>
     *
     * @param clazz clazz The class to introspect
     * @param index the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be determined
     */
    @SuppressWarnings("rawtypes")
    public static Class getSuperClassGenricType(final Class clazz, final int index) {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
                    + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class) params[index];
    }

    /**
     * 将反射时的checked exception转换为unchecked exception.
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
                || e instanceof NoSuchMethodException) {
            return new IllegalArgumentException("Reflection Exception.", e);
        } else if (e instanceof InvocationTargetException) {
            return new RuntimeException("Reflection Exception.", ((InvocationTargetException) e).getTargetException());
        } else if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }

//    public static<T> T convert(Object obj, Class<T> type) {
//        if (obj != null &&StringUtils.isEmpty(obj.toString())) {
//            if (type.equals(Integer.class)||type.equals(int.class)) {
//                return (T)new Integer(obj.toString());
//            } else if (type.equals(Long.class)||type.equals(long.class)) {
//                return (T)new Long(obj.toString());
//            } else if (type.equals(Boolean.class)||type.equals(boolean.class)) {
//                return (T) new Boolean(obj.toString());
//            } else if (type.equals(Short.class)||type.equals(short.class)) {
//                return (T) new Short(obj.toString());
//            } else if (type.equals(Float.class)||type.equals(float.class)) {
//                return (T) new Float(obj.toString());
//            } else if (type.equals(Double.class)||type.equals(double.class)) {
//                return (T) new Double(obj.toString());
//            } else if (type.equals(Byte.class)||type.equals(byte.class)) {
//                return (T) new Byte(obj.toString());
//            } else if (type.equals(Character.class)||type.equals(char.class)) {
//                return (T)new Character(obj.toString().charAt(0));
//            } else if (type.equals(String.class)) {
//                return (T) obj;
//            } else if (type.equals(BigDecimal.class)) {
//                return (T) new BigDecimal(obj.toString());
//            } else if (type.equals(LocalDateTime.class)) {
//                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                return (T) LocalDateTime.parse(obj.toString());
//            } else if (type.equals(Date.class)) {
//                try
//                {
//                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//                    return (T) formatter.parse(obj.toString());
//                }
//                catch (ParseException e)
//                {
//                    throw new RuntimeException(e.getMessage());
//                }
//
//            }else{
//                return null;
//            }
//        } else {
//            if (type.equals(int.class)) {
//                return (T)new Integer(0);
//            } else if (type.equals(long.class)) {
//                return (T)new Long(0L);
//            } else if (type.equals(boolean.class)) {
//                return (T)new Boolean(false);
//            } else if (type.equals(short.class)) {
//                return (T)new Short("0");
//            } else if (type.equals(float.class)) {
//                return (T) new Float(0.0);
//            } else if (type.equals(double.class)) {
//                return (T) new Double(0.0);
//            } else if (type.equals(byte.class)) {
//                return (T) new Byte("0");
//            } else if (type.equals(char.class)) {
//                return (T) new Character('\u0000');
//            }else {
//                return null;
//            }
//        }
//    }

    public static void setPropertyVal(String propertyName, Object s, Object newVal)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, s.getClass());
        Method setMethod = pd.getWriteMethod();
        setMethod.invoke(s, newVal);
    }

    public static Object getPropertyVal(String propertyName, Object s)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, s.getClass());
        Method getMethod = pd.getReadMethod();
        Object retVal = getMethod.invoke(s);
        return retVal;
    }


}