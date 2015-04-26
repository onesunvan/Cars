package com.tess.repositories.jpa;

import com.tess.entities.User;
import com.tess.repositories.UserRepository;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository extends JpaEntityRepository<User> 
    implements UserRepository {

    public JpaUserRepository() {
        super(User.class);
    }

    @Transactional
    @Override
    public List<User> readAll() {
        return super.readAll();
    }

    @Transactional
    @Override
    public Long save(User entity) {
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

    @Transactional
    @Override
    public User getUserByName(String username) {
        TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class)
                .setParameter("username", username);
        return query.getSingleResult();
    }
    
    @Transactional
    @Override
    public User read(Long id) {
        return super.read(id);
    }

    @Override
    protected String getFindAllQuery() {
        return "User.findAll";
    }
}
