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
    
    protected abstract String getFindAllQuery();
    
    @Override
    public List<E> readAll() {
        TypedQuery<E> query = em.createNamedQuery(getFindAllQuery(), clazz);
        List<E> entities = query.getResultList();
        return entities;
    }
    
    @Override
    public List<E> readLimitOffset(Integer limit, Integer offset) {
        TypedQuery<E> query = em.createNamedQuery(getFindAllQuery(), clazz);
        List<E> entities = query.setMaxResults(limit).setFirstResult(offset).getResultList();
        return entities;
    }
    
    @Transactional
    @Override
    public void save(E entity) {
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
