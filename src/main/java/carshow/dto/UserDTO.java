package carshow.dto;

/**
 *
 * @author ivan
 */
public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String passport;

    public UserDTO(String firstName, String lastName, String email, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
}
