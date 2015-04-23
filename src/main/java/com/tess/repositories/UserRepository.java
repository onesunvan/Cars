package com.tess.repositories;

import com.tess.entities.User;

/**
 *
 * @author ivan
 */
public interface UserRepository extends Repository<User> {
    public boolean isUsernameUnique(String username);

    public User getUserByName(String username);

}
