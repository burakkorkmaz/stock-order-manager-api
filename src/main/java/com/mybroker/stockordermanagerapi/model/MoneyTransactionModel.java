package com.mybroker.stockordermanagerapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyTransactionModel {

    //TODO: IBAN will be added

    @NotNull
    @JsonProperty(value = "customerId")
    private Long customerId;

    @NotNull
    @NotBlank
    @JsonProperty(value = "currency")
    private String currency;

    @NotNull
    @JsonProperty(value = "amount")
    private Double amount;
}
