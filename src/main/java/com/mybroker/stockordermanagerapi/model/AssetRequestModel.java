package com.mybroker.stockordermanagerapi.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetRequestModel {

    @NotNull
    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("customerId")
    private Long customerId;

    @NotNull
    @NotBlank
    @JsonProperty("assetName")
    private String assetName;

    @JsonProperty("size")
    private double size;

    @JsonProperty("usableSize")
    private double usableSize;
}
