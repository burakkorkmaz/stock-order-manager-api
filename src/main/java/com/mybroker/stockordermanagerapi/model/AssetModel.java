package com.mybroker.stockordermanagerapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AssetModel {


    private Long id;

    private Long customerId;
    private String assetName;
    private double size;
    private double usableSize;
}
