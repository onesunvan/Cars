package com.tess.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    private byte[] image;
    
    public UserInformation() {
    }

    public UserInformation(String email, String passport, User user, String firstName, 
            String lastName, byte[] image) {
        this.email = email;
        this.passport = passport;
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
