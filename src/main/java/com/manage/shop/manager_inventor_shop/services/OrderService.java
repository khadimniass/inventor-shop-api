package com.manage.shop.manager_inventor_shop.services;

import com.manage.shop.manager_inventor_shop.entities.Order;
import com.manage.shop.manager_inventor_shop.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order>getAllOrder(){
        return this.orderRepository.findAll();
    }
    public Optional<Order> getOrderById(Long id){
        return this.orderRepository.findById(id);
    }
    public Order createOrder(Order order){
        return this.orderRepository.save(order);
    }
    public Order updateOrder(Long id, Order orderDetail){
        return this.orderRepository.findById(id).map((order)->{
            order.setOrderDate(orderDetail.getOrderDate());
            order.setOrderItems(orderDetail.getOrderItems());
            order.setCustomerName(orderDetail.getCustomerName());
            order.setTotalAmont(orderDetail.getTotalAmont());

            return this.orderRepository.save(order);
        }).orElseThrow(()->new RuntimeException("order not found"));
    }
}
