package com.harshit.orderservice.controller;

import com.harshit.orderservice.dto.OrderRequest;
import com.harshit.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest request){
        orderService.placeOrder(request);
        return "Order placed successfully";
    }
}
