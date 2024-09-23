package com.mybroker.stockordermanagerapi.service;

import com.mybroker.stockordermanagerapi.entity.OrderEntity;
import com.mybroker.stockordermanagerapi.model.OrderFilterModel;
import com.mybroker.stockordermanagerapi.model.OrderModel;
import com.mybroker.stockordermanagerapi.model.Status;
import com.mybroker.stockordermanagerapi.repository.OrderRepository;
import com.mybroker.stockordermanagerapi.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Objects.isNull;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Object createOrder(OrderModel order) {
        try {
        OrderEntity orderEntity = new OrderEntity();
        // TODO: entity mapper here
            orderEntity.setCustomerId(order.getCustomerId());
            orderEntity.setAssetName(order.getAssetName());
            orderEntity.setOrderSide(order.getOrderSide());
            orderEntity.setSize(order.getSize());
            orderEntity.setPrice(order.getPrice());
            orderEntity.setStatus(Status.PENDING);
            orderEntity.setCreateDate(!isNull(order.getCreateDate()) ? order.getCreateDate(): LocalDateTime.now());
            orderRepository.save(orderEntity);

            return ResponseEntity.status(HttpStatus.OK).body("created");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ValidationUtil.SetError("500", "SERVER_ERROR", e.getMessage()));
        }
    }

    public Object listOrders(OrderFilterModel orderFilter) {
        try {
            List<OrderEntity> orderEntityList;
            if (isNull(orderFilter.getCustomerId())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidationUtil.SetError("400", "BAD_REQUEST", "Customer ID missing."));
            }

            //TODO: add order filter spec
            if (isNull(orderFilter.getCreateDate()) && isNull(orderFilter.getStatus())) {
                orderEntityList = orderRepository.findByCustomerId(orderFilter.getCustomerId());
            } else if (!isNull(orderFilter.getStatus())){
                orderEntityList = orderRepository.findByCustomerIdAndStatus(orderFilter.getCustomerId(), orderFilter.getStatus());
            } else{
                orderEntityList = orderRepository.findByCustomerIdAndCreateDateBetween(orderFilter.getCustomerId(), orderFilter.getCreateDate(), LocalDateTime.now());
            }

            if (isNull(orderEntityList) || orderEntityList.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK).body(ValidationUtil.SetError("204", "NO_CONTENT", "No order found."));
            }

            //TODO: add entity list mapper and show
            return ResponseEntity.status(HttpStatus.OK).body("listed");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ValidationUtil.SetError("500", "SERVER_ERROR", e.getMessage()));
        }
    }

    public Object cancelOrder(Long orderId) {
        try {
            OrderEntity order = orderRepository.findById(orderId).orElseThrow();
            if (order.getStatus() == Status.PENDING) {
                order.setStatus(Status.CANCELED);
                orderRepository.save(order);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidationUtil.SetError("400", "BAD_REQUEST", "Assets on pending can be only deleted."));
            }

            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.OK).body(ValidationUtil.SetError("204", "NO_CONTENT", "No order found to delete."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ValidationUtil.SetError("500", "SERVER_ERROR", e.getMessage()));
        }
    }
}
