package com.mybroker.stockordermanagerapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerBalanceModel {

    @JsonProperty(value = "balance")
    private Double balance;
}
