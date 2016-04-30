package com.tess.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tess.entities.Car;
import com.tess.entities.CarOrder;
import com.tess.entities.OrderStatus;
import com.tess.entities.User;
import com.tess.exceptions.OrderNotFoundException;
import com.tess.repositories.OrderRepository;

/**
 *
 * @author ivan
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public CarOrder makeAnOrder(User user, Car car) {
        if (user.getId() == null || car.getId() == null) {
            throw new IllegalArgumentException();
        }
        if (!car.getIfExists()) {
            throw new IllegalStateException();
        }
        CarOrder order = new CarOrder();
        order.setCar(car);
        order.setUser(user);
        order.setStatus(OrderStatus.NEW);
        orderRepository.save(order);
        return order;
    }

    public List<CarOrder> getOrdersOnPage(Integer pageNumber) {
        return orderRepository.readLimitOffset(9, (pageNumber - 1) * 9);
    }
    
    public Long getAmountOfOrders() {
        return orderRepository.getCount();
    }

    public void acceptOrder(Long id) {
    	CarOrder order = orderRepository.read(id);
        if (order == null) {
            throw new IllegalArgumentException();
        }
        order.setStatus(OrderStatus.ACCEPTED);
        orderRepository.update(order);
    }

    public void declineOrder(Long id) {
    	CarOrder order = orderRepository.read(id);
        if (order == null) {
            throw new IllegalArgumentException();
        }
        order.setStatus(OrderStatus.DECLINED);
        orderRepository.update(order);
    }

    public List<CarOrder> getUserOrdersOnPage(Integer pageNumber, String name) {
        return orderRepository.readLimitOffsetForUser(9, (pageNumber - 1) * 9, name);
    }

    public Long getAmountOfUserOrders(String username) {
        return orderRepository.getAmountOfUserOrders(username);
    }
    
    public CarOrder getUserOrder(Long id, String username) {
    	CarOrder order = orderRepository.read(id);
    	if (order == null || order.getUser().getUsername().equals(username)) {
    		throw new OrderNotFoundException();
    	} else {
    		return order;
    	}
    }
    
    public CarOrder getOrder(Long id) {
    	CarOrder order = orderRepository.read(id);
    	if (order == null) {
    		throw new OrderNotFoundException();
    	} else {
    		return order;
    	}
    }
}
