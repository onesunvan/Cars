package com.tess.repositories.jpa;

import com.tess.entities.Orders;
import com.tess.repositories.OrderRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivan
 */
@Repository
public class JpaOrderRepository extends JpaEntityRepository<Orders>
    implements OrderRepository {

    public JpaOrderRepository() {
        super(Orders.class);
    }

    @Override
    protected String getFindAllQuery() {
        return "Order.findAll";
    }
    
}
