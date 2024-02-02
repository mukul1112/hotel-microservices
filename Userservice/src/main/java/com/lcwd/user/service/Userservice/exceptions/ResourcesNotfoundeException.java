package com.lcwd.user.service.Userservice.exceptions;

public class ResourcesNotfoundeException extends RuntimeException{
    public ResourcesNotfoundeException(){
        super("resources not found");
    }
    public ResourcesNotfoundeException(String messsage){
        super(messsage);

    }
}
