package com.tess.services;

import com.tess.entities.Car;
import com.tess.entities.Orders;
import com.tess.entities.User;
import com.tess.repositories.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivan
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Orders makeAnOrder(User user, Car car) {
        if (user.getId() == null || car.getId() == null) {
            throw new IllegalArgumentException();
        }
        if (!car.getIfExists()) {
            throw new IllegalStateException();
        }
        Orders order = new Orders();
        order.setCar(car);
        order.setUser(user);
        orderRepository.save(order);
        return order;
    }

    public List<Orders> getOrdersOnPage(Integer pageNumber) {
        return orderRepository.readLimitOffset(9, (pageNumber - 1) * 9);
    }

}
