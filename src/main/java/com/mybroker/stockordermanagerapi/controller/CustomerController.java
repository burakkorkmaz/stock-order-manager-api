package com.mybroker.stockordermanagerapi.controller;

import com.mybroker.stockordermanagerapi.model.MoneyTransactionModel;
import com.mybroker.stockordermanagerapi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping(path = "/deposit", produces = "application/json")
    public Object deposit(@RequestBody MoneyTransactionModel transactMoney) {
        return customerService.depositMoney(transactMoney);
    }

    @PostMapping(path = "/withdraw", produces = "application/json")
    public Object withdraw(@RequestBody MoneyTransactionModel transactMoney) {
        return customerService.withdrawMoney(transactMoney);
    }
}
