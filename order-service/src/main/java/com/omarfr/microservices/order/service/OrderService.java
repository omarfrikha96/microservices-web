package com.omarfr.microservices.order.service;

import com.omarfr.microservices.order.dto.OrderRequest;
import com.omarfr.microservices.order.model.Order;
import com.omarfr.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;


    public void placeOrder(OrderRequest orderRequest) {
        //map OrderRequest to Order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setSkuCode(orderRequest.skuCode());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        //save order to order repository
        orderRepository.save(order);
    }

}