package com.why.entity;

/**
 * Created by why on 2016/11/2.
 */
public class Person {
    /**
     * 唯一标识
     */
    private int id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 描述
     */
    private String description;

    //省略Getter和Setter

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }
}
