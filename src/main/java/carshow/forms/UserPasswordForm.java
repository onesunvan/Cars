package carshow.forms;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ivan
 */
public class UserPasswordForm {

    @NotEmpty
    @Size(min = 6, max = 25)
    private String oldPassword;

    @NotEmpty
    @Size(min = 6, max = 25)
    private String password;

    @NotEmpty
    @Size(min = 6, max = 25)
    private String confirmPassword;

    public UserPasswordForm() {
    }

    public UserPasswordForm(String oldPassword, String password, String confirmPassword) {
        this.oldPassword = oldPassword;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
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
}
