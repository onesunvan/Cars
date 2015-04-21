package com.tess.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "USER_INFORMATION")
public class UserInformation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private String email;
    
    private String passport;
    
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public UserInformation() {
    }

    public UserInformation(String email, String passport, User user) {
        this.email = email;
        this.passport = passport;
        this.user = user;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
