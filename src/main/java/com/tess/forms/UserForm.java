package com.tess.forms;

import com.tess.validations.FieldMatch;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ivan
 */
@FieldMatch(first = "password", second = "confirmPassword", message = "registration.password.match")
public class UserForm {
    
    @NotEmpty(message = "user.form.null")
    @Size(min = 1, max = 25, message = "user.form.size")
    private String firstName;
    
    @NotEmpty(message = "user.form.null")
    @Size(min = 1, max = 25, message = "user.form.size")
    private String lastName;
    
    
    @NotEmpty(message = "user.form.null")
    @Size(min = 6, max = 25, message = "user.form.size")
    private String username;

    @NotEmpty(message = "user.form.null")
    @Size(min = 6, max = 25, message = "user.form.size")
    private String password;

    @NotEmpty(message = "user.form.null")
    @Size(min = 6, max = 25, message = "user.form.size")
    private String confirmPassword;

    @NotEmpty(message = "user.form.null")
    @Email(message = "user.form.email")
    private String email;
    
    @Size(min = 8, max = 8, message = "user.form.passportsize")
    private String passport;
    
    @Override
    public String toString() {
        return "UserForm{" + "username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
