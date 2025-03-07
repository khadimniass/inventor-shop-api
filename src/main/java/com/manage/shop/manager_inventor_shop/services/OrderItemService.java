package com.manage.shop.manager_inventor_shop.services;

import com.manage.shop.manager_inventor_shop.entities.OrderItem;
import com.manage.shop.manager_inventor_shop.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    public List<OrderItem> getAllOrderItems(){
        return this.orderItemRepository.findAll();
    }
    public Optional<OrderItem> getOrderItemById(Long id){
        return this.orderItemRepository.findById(id);
    }
    public OrderItem createOrderItem(OrderItem orderItem){
        return this.orderItemRepository.save(orderItem);
    }
    public OrderItem updateOrderItem(Long id,OrderItem orderItemDetail){
        return this.orderItemRepository.findById(id).map((orderItem)->{
            orderItemDetail.setQuantity(orderItem.getQuantity());
            orderItemDetail.setOrder(orderItem.getOrder());
            orderItemDetail.setProduct(orderItem.getProduct());
            orderItemDetail.setUnitPrice(orderItem.getUnitPrice());

            return orderItemRepository.save(orderItem);
        }).orElseThrow(()->new RuntimeException("details order not found"));
    }
    public void deleteOrderItem(Long id){
        this.orderItemRepository.deleteById(id);
    }
}
