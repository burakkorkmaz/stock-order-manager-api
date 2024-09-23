package com.mybroker.stockordermanagerapi.util;

import com.mybroker.stockordermanagerapi.model.CustomError;

public class ValidationUtil {

    public static Object SetError(String code, String reason, String message) {
        CustomError error = new CustomError();
        error.setCode(code);
        error.setReason(reason);
        error.setMessage(message);
        error.setStatus(code.equals("200") ? "OK": "Err");

        return error;
    }
}
