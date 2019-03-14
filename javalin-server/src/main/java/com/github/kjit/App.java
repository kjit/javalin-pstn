package com.github.kjit;

import com.github.kjit.dto.Message;
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

        Javalin app = Javalin.create()
                .enableCorsForAllOrigins()
                .enableStaticFiles("static-files");
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
        app.exception(IllegalArgumentException.class,
                (exception, ctx) -> ctx.status(410)
                        .json(new Message(exception.toString(), 410)));
        app.start(7000);
        LOGGER.info("Application started");
    }
}