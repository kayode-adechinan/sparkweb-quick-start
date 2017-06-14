package repositories;

import domains.User;
import utils.UserException;

import java.util.Collection;

/**
 * Created by atsk1618 on 6/12/2017.
 */
public interface UserRepository {

    public void addUser (User user);

    public Collection<User> getUsers ();
    public User getUser (String id);

    public User editUser (User user)
            throws UserException;


    public void deleteUser (String id);

    public boolean userExist (String id);
}
