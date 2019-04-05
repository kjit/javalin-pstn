package com.github.kjit;

import com.github.kjit.dao.CatDao;
import com.github.kjit.dto.CatDto;
import com.github.kjit.dto.Message;
import io.javalin.Context;
import io.javalin.apibuilder.CrudHandler;
import org.jetbrains.annotations.NotNull;

public class CatController implements CrudHandler {
    CatDao catDao = new CatDao();

    @Override
    public void create(@NotNull Context context) {
        int id = catDao.create(context.bodyAsClass(CatDto.class));
        context.status(201).json(new Message("Created", id));
    }

    @Override
    public void delete(@NotNull Context context, @NotNull String s) {
        catDao.delete(Integer.valueOf(s));
        context.status(200).json(new Message("Deleted", Integer.valueOf(s)));
    }

    @Override
    public void getAll(@NotNull Context context) {
        context.json(catDao.getAllUsers());
    }

    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        context.json(catDao.getOne(Integer.valueOf(s)));
    }

    @Override
    public void update(@NotNull Context context, @NotNull String s) {
        catDao.update(context.bodyAsClass(CatDto.class));
        context.json(new Message("Updated", Integer.valueOf(s)));
    }
}
