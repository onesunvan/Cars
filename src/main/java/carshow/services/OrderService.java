package carshow.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carshow.entities.Car;
import carshow.entities.CarOrder;
import carshow.entities.OrderStatus;
import carshow.entities.User;
import carshow.exceptions.OrderNotFoundException;
import carshow.repositories.OrderRepository;

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
        order.setStatus(OrderStatus.NEW_ORDER);
        orderRepository.save(order);
        return order;
    }

    public List<CarOrder> getOrdersOnPage(Integer pageNumber) {
        return orderRepository.readLimitOffset(9, (pageNumber - 1) * 9);
    }
    
    public Long getAmountOfOrders() {
        return orderRepository.getCount();
    }

    @Transactional
    public void acceptOrder(Long id) {
    	CarOrder order = orderRepository.read(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        if (order.getStatus() == OrderStatus.NEW_ORDER) {
        	order.setStatus(OrderStatus.ACCEPTED);
        	orderRepository.declineNewOrdersForCar(order.getCar().getId());
        } else {
        	throw new IllegalStateException();
        }
        orderRepository.update(order);
    }

    public void declineOrder(Long id) {
    	CarOrder order = orderRepository.read(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        if (order.getStatus() == OrderStatus.NEW_ORDER) {
        	order.setStatus(OrderStatus.DECLINED);
        } else {
        	throw new IllegalStateException();
        }
        orderRepository.update(order);
    }
    
    public void payOrder(Long id) {
    	CarOrder order = orderRepository.read(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        if (order.getStatus() == OrderStatus.ACCEPTED) {
        	order.setStatus(OrderStatus.IN_USE);
        } else {
        	throw new IllegalStateException();
        }
        orderRepository.update(order);
    }
    
    public void returnCar(Long id) {
    	CarOrder order = orderRepository.read(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        if (order.getStatus() == OrderStatus.IN_USE) {
        	order.setStatus(OrderStatus.RETURNED);
        } else {
        	throw new IllegalStateException();
        }
        orderRepository.update(order);
    }

    public void fineOrder(Long id) {
    	CarOrder order = orderRepository.read(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        if (order.getStatus() == OrderStatus.RETURNED) {
        	order.setStatus(OrderStatus.FINED);
        } else {
        	throw new IllegalStateException();
        }
        orderRepository.update(order);
    }
    
    public void closeOrder(Long id) {
    	CarOrder order = orderRepository.read(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        if (order.getStatus() == OrderStatus.RETURNED) {
        	order.setStatus(OrderStatus.CLOSED);
        } else {
        	throw new IllegalStateException();
        }
        orderRepository.update(order);
    }
    
    public void payFinedOrder(Long id) {
    	CarOrder order = orderRepository.read(id);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        if (order.getStatus() == OrderStatus.FINED) {
        	order.setStatus(OrderStatus.CLOSED);
        } else {
        	throw new IllegalStateException();
        }
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
    	if (order != null && order.getUser().getUsername().equals(username)) {
    		return order;
    	} else {
    		throw new OrderNotFoundException();
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
