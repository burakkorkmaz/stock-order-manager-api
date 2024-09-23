package com.mybroker.stockordermanagerapi.controller;

import com.mybroker.stockordermanagerapi.service.AssetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "asset")
public class AssetController {

    @Autowired
    private AssetServiceImpl assetService;

    @GetMapping(path = "/list/{customerId}", produces = "application/json")
    public Object listAssets(@PathVariable Long customerId) {
        return assetService.listAsset(customerId);
    }
}
