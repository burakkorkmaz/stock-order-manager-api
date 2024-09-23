package com.mybroker.stockordermanagerapi.service;

import com.mybroker.stockordermanagerapi.entity.AssetEntity;
import com.mybroker.stockordermanagerapi.model.MoneyTransactionModel;
import com.mybroker.stockordermanagerapi.repository.AssetRepository;
import com.mybroker.stockordermanagerapi.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private AssetRepository assetRepository;


    public Object depositMoney(MoneyTransactionModel transactMoney) {
        try {
            if (!transactMoney.getCurrency().equals("TRY")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidationUtil.SetError("400", "BAD_REQUEST", "Only TRY currency can deposit."));
            }

            AssetEntity assetTRY = assetRepository.findByCustomerIdAndAssetName(transactMoney.getCustomerId(), "TRY");
            if (isNull(assetTRY)) {
                return ResponseEntity.status(HttpStatus.OK).body(ValidationUtil.SetError("204", "NO_ASSET", "No asset found."));
            }
            assetTRY.setSize(assetTRY.getSize() + transactMoney.getAmount());
            assetTRY.setUsableSize(assetTRY.getUsableSize() + transactMoney.getAmount());
            assetRepository.save(assetTRY);

            return ResponseEntity.status(HttpStatus.OK).body(assetTRY);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ValidationUtil.SetError("500", "SERVER_ERROR", e.getMessage()));

        }
    }

    public Object withdrawMoney(MoneyTransactionModel transactMoney) {
        try {
            AssetEntity assetTRY = assetRepository.findByCustomerIdAndAssetName(transactMoney.getCustomerId(), "TRY");
            if (isNull(assetTRY)) {
                return ResponseEntity.status(HttpStatus.OK).body(ValidationUtil.SetError("204", "NO_CUSTOMER", "No customer found."));
            }

            if (assetTRY.getUsableSize() >= transactMoney.getAmount()) {
                assetTRY.setUsableSize(assetTRY.getUsableSize() - transactMoney.getAmount());
                assetRepository.save(assetTRY);

                return ResponseEntity.status(HttpStatus.OK).body(assetTRY);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(ValidationUtil.SetError("406", "NOT_ACCEPTABLE", "Insufficient funds"));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ValidationUtil.SetError("500", "SERVER_ERROR", e.getMessage()));

        }
    }
}
