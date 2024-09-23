package com.mybroker.stockordermanagerapi.service;

import com.mybroker.stockordermanagerapi.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public Object listAsset(Long customerId) {

        assetRepository.findAllByCustomerId(customerId);
        return null;
    }
}
