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
public class UserCreditinalsForm {
    
    @NotEmpty
    @Size(min = 1, max = 25)
    private String firstName;
    
    @NotEmpty
    @Size(min = 1, max = 25)
    private String lastName;

    @Email
    private String email;
    
    @Size(min = 8, max = 8)
    private String passport;
    

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
