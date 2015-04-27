package com.tess.repositories;

import java.util.List;

/**
 *
 * @author ivan
 */
public interface Repository<E> {

    List<E> readAll();
    
    List<E> readLimitOffset(Integer limit, Integer offset);
    
    E read(Long id);
    
    void save(E entity);
    
    void delete(E entity);
    
    void update(E entity);
}
