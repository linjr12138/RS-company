package com.linjr.utils;

import java.util.Calendar;
import java.util.Date;

public class OrderNoUtil {
    private static final String ORDER_TPYE = "RS";

    /**
     * 右补位，左对齐
     *
     * @param len    目标字符串长度
     * @param alexin 补位字符
     * @return 目标字符串
     * 以alexin 做为补位
     * @pparam oriStr  原字符串
     */
    public static String padRight(String clientcode,String oriStr, int len, String alexin) {
        String str = "";
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int year = c.get(Calendar.YEAR);
        int day = c.get(Calendar.DAY_OF_YEAR);  //从今天属于今年的第多少天？365 2位 3位 267 001
        int hour = c.get(Calendar.HOUR_OF_DAY);
        String dayFmt = String.format("%1$03d", day);
        String hourFmt = String.format("%1$02d", hour);
        String prefix = (year - 2000) + dayFmt + hourFmt;
        str = clientcode + prefix + oriStr;
        int strlen = str.length();
        if (strlen < len) {
            for (int i = 0; i < len - strlen; i++) {
                str = str + alexin;
            }
        }
        str = str + oriStr;
        return str;
    }


    /**
     * 获取机构编码 YXD0001
     *
     * @param oriStr 初始值
     * @param len    位数
     * @param alexin 不足 以什么补充
     * @return java.lang.String
     * @throws
     * @Author: 小霍
     * @CreateDate: 2019/9/19 12:06
     * @UpdateUser:
     * @UpdateDate: 2019/9/19 12:06
     * @Version: 0.0.1
     */
    public static String orderNo(String clientcode,String oriStr, int len, String alexin) {
        return ORDER_TPYE + padRight(clientcode,oriStr, len, alexin);
    }

}
