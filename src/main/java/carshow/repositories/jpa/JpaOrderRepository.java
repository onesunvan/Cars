package carshow.repositories.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import carshow.entities.CarOrder;
import carshow.repositories.OrderRepository;

/**
 *
 * @author ivan
 */
@Repository
public class JpaOrderRepository extends JpaEntityRepository<CarOrder>
        implements OrderRepository {

    public JpaOrderRepository() {
        super(CarOrder.class);
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
    public List<CarOrder> readLimitOffset(Integer limit, Integer offset) {
        return super.readLimitOffset(limit, offset);
    }
    
    @Transactional
    @Override
    public CarOrder read(Long id) {
        return super.read(id);
    }

    @Transactional
    @Override
    public List<CarOrder> readLimitOffsetForUser(int limit, int offset, String name) {
        TypedQuery<CarOrder> query = em.createNamedQuery("Orders.findForUser", clazz);
        List<CarOrder> orders = query.setMaxResults(limit).setFirstResult(offset)
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
