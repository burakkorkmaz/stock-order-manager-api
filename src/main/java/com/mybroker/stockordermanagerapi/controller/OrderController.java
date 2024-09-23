package com.mybroker.stockordermanagerapi.controller;

import com.mybroker.stockordermanagerapi.model.OrderFilterModel;
import com.mybroker.stockordermanagerapi.model.OrderModel;
import com.mybroker.stockordermanagerapi.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/create", produces = "application/json")
    public Object createOrder(@RequestBody OrderModel order) {
        return orderService.createOrder(order);
    }

    @PostMapping(path = "/list", produces = "application/json")
    public Object listOrders(@RequestBody OrderFilterModel orderFilter) {
        return orderService.listOrders(orderFilter);
    }

    @DeleteMapping(path = "/delete/{orderId}", produces = "application/json")
    public Object cancelOrder(@PathVariable Long orderId) {
        return orderService.cancelOrder(orderId);
    }
}
