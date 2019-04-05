package com.github.kjit.dao;

import com.github.kjit.dto.CatDto;
import com.github.kjit.dto.UserDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CatDao {
    private Map<Integer, CatDto> cats = new HashMap<>();

    public List<CatDto> getAllUsers() {
        return cats.values().stream().collect(Collectors.toList());
    }

    public int create(CatDto catDto) {
        int id = cats.size() + 1;
        catDto.setId(id);
        cats.put(id, catDto);
        return id;
    }

    public void delete(int id) {
        cats.remove(id);
    }

    public CatDto getOne(int id) {
        return cats.get(id);
    }

    public void update(CatDto catDto) {
        cats.put(catDto.getId(), catDto);
    }
}
