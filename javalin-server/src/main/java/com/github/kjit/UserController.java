package com.github.kjit;

import com.github.kjit.dao.UserDao;
import com.github.kjit.dto.Message;
import com.github.kjit.dto.UserDto;
import io.javalin.Context;
import io.javalin.apibuilder.CrudHandler;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserController implements CrudHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private UserDao userDao = new UserDao();

    @Override
    public void create(@NotNull Context context) {
        LOGGER.info("create");
        UserDto userDto = context.bodyAsClass(UserDto.class);
        userDao.create(userDto);
    }

    @Override
    public void delete(@NotNull Context context, @NotNull String s) {
        LOGGER.info("delete");
        int id = Integer.valueOf(s);
        userDao.delete(id);
        context.json(new Message("Used deleted", id));
    }

    @Override
    public void getAll(@NotNull Context context) {
        LOGGER.info("GetAll");
        context.json(userDao.getAllUsers());
    }

    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        LOGGER.info("get one {}", s);
        int id = Integer.valueOf(s);
        userDao.delete(id);
        context.json(new Message("Used deleted", id));
    }

    @Override
    public void update(@NotNull Context context, @NotNull String s) {

    }
}
