package com.ClientLogin.C_Login.Service;

public class DuplicateClientException extends RuntimeException{
    public DuplicateClientException(String s)
    {
        super(s);
    }
}
