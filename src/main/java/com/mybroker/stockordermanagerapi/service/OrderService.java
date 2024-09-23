package com.mybroker.stockordermanagerapi.service;

import com.mybroker.stockordermanagerapi.model.OrderFilterModel;
import com.mybroker.stockordermanagerapi.model.OrderModel;

import java.time.LocalDateTime;

public interface OrderService {

    Object createOrder(OrderModel order);

    Object listOrders(OrderFilterModel filterModel);

    Object cancelOrder(Long orderId);



}
