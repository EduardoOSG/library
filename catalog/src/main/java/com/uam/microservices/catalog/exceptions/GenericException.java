package com.uam.microservices.catalog.exceptions;

public class GenericException extends RuntimeException {

    private String message;

    public GenericException(){

    }

    public GenericException(String msg){

        super(msg);
        this.message = msg;

    }

}
