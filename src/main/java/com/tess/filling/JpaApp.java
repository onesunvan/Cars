package com.tess.filling;

import com.tess.entities.Orders;
import com.tess.entities.User;
import com.tess.repositories.OrderRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ivan
 */
public class JpaApp {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("jpa-repositories.xml");
        OrderRepository orderRepository = appContext.getBean(OrderRepository.class);
        Orders order = orderRepository.read(17450L);
        System.out.println("hello");
        User user = order.getUser();
//        System.out.println(user.getUsername());
        
    }
}
