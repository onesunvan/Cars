package com.tess.repositories;

import com.tess.entities.Orders;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface OrderRepository extends Repository<Orders>{
    public Long getCount();

    public List<Orders> readLimitOffsetForUser(int limit, int offset, String name);

    public Long getAmountOfUserOrders(String username);
}
