package com.linjr.entity.db2;

public class Person {
    public String name;//公开的name
    private Double weight;//私有的weight
    protected char sex; //受保护的sex
    int age;    //默认的age

    //---------------构造方法-------------------
    //默认的构造方法
    Person(String str){
        System.out.println("(默认)的构造方法 s = " + str);
    }

    //无参构造方法
    public Person(){
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    //有一个参数的构造方法
    public Person(char name){
        System.out.println("姓名：" + name);
    }

    //有多个参数的构造方法
    public Person(String name ,int age){
        System.out.println("姓名："+name+"年龄："+ age);//这的执行效率有问题，以后解决。
    }

    //受保护的构造方法
    protected Person(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private Person(int age){
        System.out.println("私有的构造方法   年龄："+ age);
    }

    public void eat(String s){
        System.out.println("调用了：公有的，String参数的eat(): s = " + s);
    }
    protected void paly(){
        System.out.println("调用了：受保护的，无参的paly()");
    }
    void run(){
        System.out.println("调用了：默认的，无参的run()");
    }
    private String study(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的study(): age = " + age);
        return "abcd";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", weight=" + weight + ", sex=" + sex + ", age=" + age + "]";
    }
}
