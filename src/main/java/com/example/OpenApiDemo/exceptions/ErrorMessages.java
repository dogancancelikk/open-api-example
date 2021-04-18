package com.example.OpenApiDemo.exceptions;

public enum ErrorMessages
{
    MISSING_TARGET_SUM_FIELD( "Target Sum value can't be null" ),
    MISSING_TARGET_ARRAY_FIELD( "The array should have more than one element" );

    private String errorMessage;

    ErrorMessages( String errorMessage )
    {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage( )
    {
        return errorMessage;
    }

    public void setErrorMessage( String errorMessage )
    {
        this.errorMessage = errorMessage;
    }
}
