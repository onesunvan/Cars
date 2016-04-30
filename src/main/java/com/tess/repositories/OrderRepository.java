package com.tess.repositories;

import com.tess.entities.CarOrder;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface OrderRepository extends Repository<CarOrder>{
    public Long getCount();

    public List<CarOrder> readLimitOffsetForUser(int limit, int offset, String name);

    public Long getAmountOfUserOrders(String username);
}
