package com.example.jpa.exception;


public class CusNotFoundException extends RuntimeException{

    public CusNotFoundException(String msg, Throwable t){
        super(msg,t);
    }

    public CusNotFoundException(String msg){
        super(msg);
    }

    public CusNotFoundException(){
        super();
    }
}
