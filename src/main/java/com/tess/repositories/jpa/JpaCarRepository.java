package com.tess.repositories.jpa;

import com.tess.entities.Car;
import com.tess.repositories.CarRepository;
import java.util.List;
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

    @Transactional
    @Override
    public List<Car> readAll() {
        return readAll("Car.findAll");
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
    
}
