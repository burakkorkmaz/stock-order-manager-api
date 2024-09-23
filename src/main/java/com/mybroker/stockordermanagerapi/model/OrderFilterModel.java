package com.mybroker.stockordermanagerapi.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderFilterModel {

    private Long customerId;

    private Status status;

    private LocalDateTime createDate;

}
