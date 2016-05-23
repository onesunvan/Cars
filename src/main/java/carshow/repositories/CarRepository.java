package carshow.repositories;

import java.util.List;

import carshow.entities.Car;

/**
 *
 * @author ivan
 */
public interface CarRepository extends Repository<Car> {

    public List<Car> readLimitOffsetIfExists(int limit, int offset);

    public List<Car> readLimitOffsetLikeIfExists(int limit, int offset, String filter);

    public List<Car> readLimitOffsetLike(int limit, int offset, String filter);
    
}
