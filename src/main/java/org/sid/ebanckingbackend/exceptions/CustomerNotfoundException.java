package org.sid.ebanckingbackend.exceptions;

import org.aspectj.bridge.IMessage;

public class CustomerNotfoundException extends RuntimeException {
    public CustomerNotfoundException(String message) {
        super(message);
    }
}
