package com.harshit.orderservice.service;

import com.harshit.orderservice.client.InventoryClient;
import com.harshit.orderservice.dto.OrderRequest;
import com.harshit.orderservice.model.Order;
import com.harshit.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest){
        boolean isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isProductInStock){
            // map order request to order object
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            // save order to order repository
            orderRepository.save(order);
        }
        else{
            throw new RuntimeException("Product with skuCode: " + orderRequest.skuCode() + " is not in stock");
        }

    }

}
