package com.github.kjit.dto;

public class CatDto {
    private int id;
    private String name;
    private int age;

    public CatDto(int id, String name) {
        this.id = id;
        this.name = name;
        this.age = 1;
    }

    public CatDto(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public CatDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
