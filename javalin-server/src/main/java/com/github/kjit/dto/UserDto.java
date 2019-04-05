package com.github.kjit.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private int id;
    private String name;

    private List<CatDto> cats = new ArrayList<>();

    public UserDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDto() {
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

    public void addCat(CatDto cat) {
        cats.add(cat);
    }

    public CatDto getCat(int idx) {
        return cats.get(idx);
    }

    public CatDto removeCat(int idx) {
        return cats.remove(idx);
    }

    public int howManyCats() {
        return cats.size();
    }
}
