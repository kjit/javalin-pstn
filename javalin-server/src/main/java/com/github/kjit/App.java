package com.github.kjit;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.crud;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

public class App {
    static UserController userController = new UserController();


    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello there"));
        app.routes(() -> {
                    path("users", () -> {
                                get(userController::getAll);
                                post(userController::create);
                                crud("crud/:user-id", userController);
                            }
                    );
                }

        );
    }
}
