package com.tess.services;

import com.tess.entities.Role;
import com.tess.entities.User;
import com.tess.entities.UserAuthorization;
import com.tess.entities.UserInformation;
import com.tess.forms.UserEditForm;
import com.tess.forms.UserForm;
import com.tess.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivan
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public void registerNewUser(UserForm userForm) throws UsernameExistException{
        if (!userRepository.isUsernameUnique(userForm.getUsername())) {
            throw new UsernameExistException();
        }
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        user.setEnabled(Boolean.TRUE);
        user.getRoles().add(new UserAuthorization(Role.ROLE_USER));
        user.setUserInformation(new UserInformation(userForm.getEmail(), 
                userForm.getPassport(), user, userForm.getFirstName(), userForm.getLastName()));
        userRepository.save(user);
    }
    
    public void updateUserByUserEditForm(String username, UserEditForm userForm) {
        User user = userRepository.getUserByName(username);
        user.setPassword(userForm.getPassword());
        user.getUserInformation().setEmail(userForm.getEmail());
        user.getUserInformation().setPassport(userForm.getPassport());
        user.getUserInformation().setFirstName(userForm.getFirstName());
        user.getUserInformation().setLastName(userForm.getLastName());
        userRepository.update(user);
    }

    public User getUserByName(String username) {
        return userRepository.getUserByName(username);
    }

    public boolean isOldPasswordValid(String oldPassword, String username) {
        return userRepository.isOldPasswordValid(oldPassword, username);
    }
    
}
