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
public class UserForm {
    
    @NotEmpty
    @Size(min = 1, max = 25)
    private String firstName;
    
    @NotEmpty
    @Size(min = 1, max = 25)
    private String lastName;
    
    
    @NotEmpty
    @Size(min = 4, max = 25)
    private String username;

    @NotEmpty
    @Size(min = 6, max = 25)
    private String password;

    @NotEmpty
    @Size(min = 6, max = 25)
    private String confirmPassword;

    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    @Size(min = 10, max = 12)
    private String phoneNumber;
    
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
