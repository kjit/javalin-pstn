package com.github.kjit.dao;

import com.github.kjit.dto.UserDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDao {
    private Map<Integer, UserDto> users = new HashMap<>();

    public List<UserDto> getAllUsers() {
        return users.values().stream().collect(Collectors.toList());
    }

    public int create(UserDto userDto) {
        int id = users.size() + 1;
        userDto.setId(id);
        users.put(id, userDto);
        return id;
    }

    public void delete(int id) {
        users.remove(id);
    }

    public UserDto getOne(int id) {
        return users.get(id);
    }

    public void update(UserDto userDto) {
        users.put(userDto.getId(), userDto);
    }

}
