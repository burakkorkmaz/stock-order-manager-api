package com.mybroker.stockordermanagerapi.repository;

import com.mybroker.stockordermanagerapi.entity.OrderEntity;
import com.mybroker.stockordermanagerapi.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByCustomerIdAndCreateDateBetween(Long customerId, LocalDateTime startDate, LocalDateTime endDate);
    List<OrderEntity> findByCustomerIdAndStatus(Long customerId, Status status);
    List<OrderEntity> findByCustomerId(Long customerId);
}
