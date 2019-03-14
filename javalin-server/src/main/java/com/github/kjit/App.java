package com.github.kjit;

import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.javalin.apibuilder.ApiBuilder.crud;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static UserController userController = new UserController();

    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello there"))
                .routes(() -> {
                            path("users", () -> {
                                        get(userController::getAll);
                                        post(userController::create);
                                        crud("crud/:user-id", userController);
                                    }
                            );
                        }
                );
        LOGGER.info("Application started");
    }
}
q