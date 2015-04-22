package com.tess.forms;

import com.tess.validations.FieldMatch;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ivan
 */
@FieldMatch(first = "password", second = "confirmPassword")
public class UserEditForm {
    
    @NotEmpty
    @Size(min = 1, max = 25)
    private String firstName;
    
    @NotEmpty
    @Size(min = 1, max = 25)
    private String lastName;
    
    @NotEmpty
    @Size(min = 6, max = 25)
    private String oldPassword;

    @NotEmpty
    @Size(min = 6, max = 25)
    private String password;

    @NotEmpty
    @Size(min = 6, max = 25)
    private String confirmPassword;

    @Email
    private String email;
    
    @Size(min = 8, max = 8)
    private String passport;
    
    @Override
    public String toString() {
        return "UserForm{" + "oldPassword=" + oldPassword + ", password=" + password + ", confirmPassword=" + confirmPassword + '}';
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
    
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
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
