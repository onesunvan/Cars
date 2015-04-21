package com.tess.repositories;

import java.util.List;

/**
 *
 * @author ivan
 */
public interface Repository<E> {

    List<E> readAll();
    
    E read(Long id);
    
    Long save(E entity);
    
    void delete(E entity);
    
    void update(E entity);
}
