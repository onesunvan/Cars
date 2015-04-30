package com.tess.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "USER_AUTHORIZATION")
public class UserAuthorization implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "user_role_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserAuthorization() {
    }

    public UserAuthorization(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
