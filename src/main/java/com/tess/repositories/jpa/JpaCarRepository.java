package com.tess.repositories.jpa;

import com.tess.entities.Car;
import com.tess.repositories.CarRepository;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivan
 */
@Repository
public class JpaCarRepository extends JpaEntityRepository<Car>
    implements CarRepository {

    public JpaCarRepository() {
        super(Car.class);
    }

    @Override
    protected String getFindAllQuery() {
        return "Car.findAll";
    }

    @Transactional
    @Override
    public Long save(Car entity) {
        saveEntity(entity);
        return entity.getId();
    }
    
    @Transactional
    @Override
    public Car read(Long id) {
        return super.read(id);
    } 
    
    @Transactional
    @Override
    public List<Car> readLimitOffset(Integer limit, Integer offset) {
        return super.readLimitOffset(limit, offset);
    }

    @Transactional
    @Override
    public List<Car> readLimitOffsetIfExists(int limit, int offset) {
        TypedQuery<Car> query = em.createNamedQuery("Car.findIfExists", clazz);
        List<Car> cars = query.setMaxResults(limit).setFirstResult(offset).getResultList();
        return cars;
    }

    @Transactional
    @Override
    public List<Car> readLimitOffsetLikeIfExists(int limit, int offset, String filter) {
        TypedQuery<Car> query = em.createNamedQuery("Car.findLikeIfExists", clazz);
        List<Car> cars = query.setMaxResults(limit).setFirstResult(offset)
                .setParameter("filter", filter).getResultList();
        return cars;
    }

    @Transactional
    @Override
    public List<Car> readLimitOffsetLike(int limit, int offset, String filter) {
        TypedQuery<Car> query = em.createNamedQuery("Car.findLike", clazz);
        List<Car> cars = query.setMaxResults(limit).setFirstResult(offset)
                .setParameter("filter", filter).getResultList();
        return cars;
    }


    
}
