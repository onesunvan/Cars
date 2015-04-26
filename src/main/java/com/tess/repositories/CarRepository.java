package com.tess.repositories;

import com.tess.entities.Car;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface CarRepository extends Repository<Car> {

    public List<Car> readLimitOffsetIfExists(int limit, int offset);

    public List<Car> readLimitOffsetLikeIfExists(int limit, int offset, String filter);

    public List<Car> readLimitOffsetLike(int limit, int offset, String filter);
    
}
