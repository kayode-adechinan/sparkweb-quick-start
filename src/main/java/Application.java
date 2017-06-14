import controllers.UserController;
import repositories.UserRepository;
import services.UserServiceMapImpl;

import static spark.Spark.*;

/**
 * Created by atsk1618 on 6/12/2017.
 */
public class Application {

    public static void main(String[] args) {
        final UserRepository userRepository = new UserServiceMapImpl();

        post("/users", UserController::create);
        get("/users", UserController::read);
        get("/users/:id", UserController::show);
        put("/users/:id", UserController::update);
        delete("/users/:id", UserController::delete);


    }
}
