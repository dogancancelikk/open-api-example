package com.example.OpenApiDemo.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


public class MissingRequiredFieldException extends RuntimeException
{
    public MissingRequiredFieldException( String message )
    {
        super( message );
    }
}
