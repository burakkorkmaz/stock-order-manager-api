package com.mybroker.stockordermanagerapi.service;

import com.mybroker.stockordermanagerapi.model.MoneyTransactionModel;

public interface CustomerService {

    Object depositMoney(MoneyTransactionModel transactMoney);

    Object withdrawMoney(MoneyTransactionModel transactMoney);


}
