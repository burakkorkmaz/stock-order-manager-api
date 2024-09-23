package com.mybroker.stockordermanagerapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class OrderModel {


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

