package carshow.repositories;

import carshow.entities.User;

/**
 *
 * @author ivan
 */
public interface UserRepository extends Repository<User> {
    public boolean isUsernameUnique(String username);

    public User getUserByName(String username);

}
