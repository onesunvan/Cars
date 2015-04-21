package com.tess.repositories.jpa;

import com.tess.repositories.Repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author ivan
 */
public abstract class JpaEntityRepository <E> implements Repository <E> {
    
    protected Class<E> clazz;

    protected JpaEntityRepository(Class<E> clazz) {
        this.clazz = clazz;
    }
    
    @PersistenceContext
    protected EntityManager em;
    
    protected List<E> readAll(String namedQuery) {
        TypedQuery<E> query = em.createNamedQuery(namedQuery, clazz);
        List<E> pizzas = query.getResultList();
        return pizzas;
    }
    
    public void saveEntity(E entity) {
        em.persist(entity);
    }
    
    @Override
    public E read(Long id) {
        return em.find(clazz, id);
    }
    
    @Transactional
    @Override
    public void delete(E entity) {
        em.remove(entity);
    }
    
    @Transactional
    @Override
    public void update(E entity) {
        em.merge(entity);
    }
}
