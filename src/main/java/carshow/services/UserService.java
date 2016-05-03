package carshow.services;

import carshow.entities.Role;
import carshow.entities.User;
import carshow.entities.UserAuthorization;
import carshow.entities.UserInformation;
import carshow.exceptions.UsernameExistException;
import carshow.forms.UserCreditinalsForm;
import carshow.forms.UserForm;
import carshow.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivan
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void registerNewUser(UserForm userForm, byte[] image) throws UsernameExistException{
        if (!userRepository.isUsernameUnique(userForm.getUsername())) {
            throw new UsernameExistException();
        }
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setPassword(encryptPassword(userForm.getPassword()));
        user.setEnabled(Boolean.TRUE);
        user.getRoles().add(new UserAuthorization(Role.ROLE_USER));
        user.setUserInformation(
                new UserInformation(userForm.getEmail(), 
                    userForm.getPhoneNumber(), user, userForm.getFirstName(), 
                    userForm.getLastName(), image));
        userRepository.save(user);
    }
    
    public void updateUserByUserCreditinalsForm(String username, UserCreditinalsForm userForm, byte[] image) {
        User user = userRepository.getUserByName(username);
        user.getUserInformation().setEmail(userForm.getEmail());
        user.getUserInformation().setPhoneNumber(userForm.getPhoneNumber());
        user.getUserInformation().setFirstName(userForm.getFirstName());
        user.getUserInformation().setLastName(userForm.getLastName());
        if (image != null) {
             user.getUserInformation().setImage(image);
        }
        userRepository.update(user);
    }
    
    public void updateUserPassword(String username, String newPassword) {
        User user = userRepository.getUserByName(username);
        String encodedPassword = encryptPassword(newPassword);
        user.setPassword(encodedPassword);
        userRepository.update(user);
    }

    public User getUserByName(String username) {
        return userRepository.getUserByName(username);
    }

    public boolean isOldPasswordValid(String oldPassword, String username) {
        User user = userRepository.getUserByName(username);
        return passwordEncoder.matches(oldPassword, user.getPassword());
        
    }
    
    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }
    
}
