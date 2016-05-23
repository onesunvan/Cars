package carshow.repositories;

import java.util.List;

import carshow.entities.CarOrder;

/**
 *
 * @author ivan
 */
public interface OrderRepository extends Repository<CarOrder>{
    public Long getCount();

    public List<CarOrder> readLimitOffsetForUser(int limit, int offset, String name);

    public Long getAmountOfUserOrders(String username);

	public void declineNewOrdersForCar(Long id);
}
