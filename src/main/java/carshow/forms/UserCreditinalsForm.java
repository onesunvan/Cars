package carshow.forms;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import carshow.validations.FieldMatch;

/**
 *
 * @author ivan
 */
@FieldMatch(first = "password", second = "confirmPassword")
public class UserCreditinalsForm {
    
    @NotEmpty
    @Size(min = 1, max = 50)
    private String firstName;
    
    @NotEmpty
    @Size(min = 1, max = 50)
    private String lastName;

    @Email
    private String email;
    
    @Size(min = 10, max = 12)
    private String phoneNumber;
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
