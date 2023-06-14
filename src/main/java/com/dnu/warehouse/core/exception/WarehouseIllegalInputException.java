package com.dnu.warehouse.core.exception;

public class WarehouseIllegalInputException extends WarehouseException {
    public WarehouseIllegalInputException() {
    }

    public WarehouseIllegalInputException(String message) {
        super(message);
    }

    public WarehouseIllegalInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public WarehouseIllegalInputException(Throwable cause) {
        super(cause);
    }

    public WarehouseIllegalInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
