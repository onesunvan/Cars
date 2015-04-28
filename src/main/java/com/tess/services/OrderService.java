package com.tess.services;

import com.tess.entities.Car;
import com.tess.entities.OrderStatus;
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
        order.setStatus(OrderStatus.NEW);
        orderRepository.save(order);
        return order;
    }

    public List<Orders> getOrdersOnPage(Integer pageNumber) {
        return orderRepository.readLimitOffset(9, (pageNumber - 1) * 9);
    }
    
    public Long getAmountOfOrders() {
        return orderRepository.getCount();
    }

    public void acceptOrder(Long id) {
        Orders order = orderRepository.read(id);
        if (order == null) {
            throw new IllegalArgumentException();
        }
        order.setStatus(OrderStatus.ACCEPTED);
        orderRepository.update(order);
    }

    public void declineOrder(Long id) {
        Orders order = orderRepository.read(id);
        if (order == null) {
            throw new IllegalArgumentException();
        }
        order.setStatus(OrderStatus.DECLINED);
        orderRepository.update(order);
    }

    public List<Orders> getUserOrdersOnPage(Integer pageNumber, String name) {
        return orderRepository.readLimitOffsetForUser(9, (pageNumber - 1) * 9, name);
    }

    public Long getAmountOfUserOrders(String username) {
        return orderRepository.getAmountOfUserOrders(username);
    }
}
