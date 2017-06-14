package controllers;

import com.google.gson.Gson;
import domains.User;
import repositories.UserRepository;
import services.UserServiceMapImpl;
import spark.Request;
import spark.Response;
import utils.StandardResponse;
import utils.StatusResponse;
import utils.UserException;

/**
 * Created by atsk1618 on 6/12/2017.
 */
public class UserController {

    final static UserRepository userService = new UserServiceMapImpl();


    public static String create (Request request, Response response) {
        response.type("application/json");
        User user = new Gson().fromJson(request.body(), User.class);
        userService.addUser(user);
        return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
    }

    public static String read (Request request, Response response) {
        response.type("application/json");
        return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUsers())));
    }

    public static String show (Request request, Response response) {
        response.type("application/json");

        return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUser(request.params(":id")))));
    }

    public static String update (Request request, Response response) throws UserException {
        response.type("application/json");

        User toEdit = new Gson().fromJson(request.body(), User.class);
        User editedUser = userService.editUser(toEdit);

        if (editedUser != null) {
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedUser)));
        } else {
            return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("User not found or error in edit")));
        }
    }

    public static String delete (Request request, Response response) {
        response.type("application/json");

        userService.deleteUser(request.params(":id"));
        return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "user deleted"));
    }
}
