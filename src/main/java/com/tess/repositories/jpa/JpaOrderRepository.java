package com.tess.repositories.jpa;

import com.tess.entities.Car;
import com.tess.entities.Orders;
import com.tess.repositories.OrderRepository;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Long getCount() {
        TypedQuery<Long> q = em.createNamedQuery("Order.amount", Long.class);
        Long result =  q.getSingleResult();
        return result;
    }
    
    @Transactional
    @Override
    public List<Orders> readLimitOffset(Integer limit, Integer offset) {
        return super.readLimitOffset(limit, offset);
    }
    
    @Transactional
    @Override
    public Orders read(Long id) {
        return super.read(id);
    }

    @Transactional
    @Override
    public List<Orders> readLimitOffsetForUser(int limit, int offset, String name) {
        TypedQuery<Orders> query = em.createNamedQuery("Orders.findForUser", clazz);
        List<Orders> orders = query.setMaxResults(limit).setFirstResult(offset)
                .setParameter("username", name).getResultList();
        return orders;
    }

    @Override
    public Long getAmountOfUserOrders(String username) {
        TypedQuery<Long> q = em.createNamedQuery("Order.userAmount", Long.class);
        Long result =  q.setParameter("username", username).getSingleResult();
        return result;
    }

}
