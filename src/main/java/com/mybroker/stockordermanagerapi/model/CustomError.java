package com.mybroker.stockordermanagerapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * An API uses this model when throws an Error.
 * HTTP error response code (3xx, 4xx, 5xx)
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomError {
    @JsonProperty("code")
    private String code = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("message")
    private String message = null;

    @JsonProperty("status")
    private String status = null;

}
