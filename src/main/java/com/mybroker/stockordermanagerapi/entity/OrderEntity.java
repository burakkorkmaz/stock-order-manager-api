package com.mybroker.stockordermanagerapi.entity;

import com.mybroker.stockordermanagerapi.model.Side;
import com.mybroker.stockordermanagerapi.model.Status;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private String assetName;

    @Enumerated(EnumType.STRING)
    private Side orderSide;

    private double size;

    private double price;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createDate;
}

