package com.tess.repositories.jpa;

import com.tess.entities.User;
import com.tess.repositories.UserRepository;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository extends JpaEntityRepository<User> 
    implements UserRepository {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public JpaUserRepository() {
        super(User.class);
    }

    @Transactional
    @Override
    public List<User> readAll() {
        return readAll("User.findAll");
    }

    @Transactional
    @Override
    public Long save(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        saveEntity(entity);
        return entity.getId();
    }

    @Override
    public boolean isUsernameUnique(String username) {
        TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class)
                .setParameter("username", username);
        List<User> users = query.getResultList();
        return users == null || users.isEmpty();
    }

    @Override
    public User getUserByName(String username) {
        TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class)
                .setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public boolean isOldPasswordValid(String oldPassword, String username) {
        TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class)
                .setParameter("username", username);
        User user = query.getSingleResult();
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }
    
    @Transactional
    @Override
    public void update(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        super.update(entity);
    }
}
