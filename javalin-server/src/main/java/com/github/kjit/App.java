package com.github.kjit;

import com.github.kjit.dto.Message;
import io.javalin.Javalin;
import io.javalin.staticfiles.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.javalin.apibuilder.ApiBuilder.crud;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static UserController userController = new UserController();
    private static CatController catController = new CatController();

    public static void main(String[] args) {

        Javalin app = Javalin.create()
                .enableCorsForOrigin("")
                .enableStaticFiles("static-files", Location.CLASSPATH);
        app.get("/", ctx -> ctx.result("Hello there"))
                .routes(() -> {
                            path("users", () -> {
                                        get(userController::getAll);
                                        post(userController::create);
                                        crud("crud/:user-id", userController);
                                    }
                            );
                            crud("cats/:cat-id", catController);
                        }
                );


        app.exception(IllegalArgumentException.class,
                (exception, ctx) -> ctx.status(410)
                        .json(new Message(exception.toString(), 410)));
        app.start(7000);
        LOGGER.info("Application started");
    }
}