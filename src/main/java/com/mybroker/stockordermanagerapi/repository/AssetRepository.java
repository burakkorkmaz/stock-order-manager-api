package com.mybroker.stockordermanagerapi.repository;

import com.mybroker.stockordermanagerapi.entity.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<AssetEntity, Long> {
    List<AssetEntity> findAllByCustomerId(Long customerId);
   AssetEntity findByCustomerIdAndAssetName(Long customerId, String assetName);
}
