package com.example.demo.model;

public class MessageResponse{
    String status;
    int code;
    String message;
    String errorMessage;

    

    public MessageResponse(String status, int code, String message, String errorMessage) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.errorMessage = errorMessage;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    
}