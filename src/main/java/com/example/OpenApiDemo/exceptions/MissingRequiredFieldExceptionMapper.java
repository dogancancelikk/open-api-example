package com.example.OpenApiDemo.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MissingRequiredFieldExceptionMapper implements
    ExceptionMapper<MissingRequiredFieldException>
{
    @Override public Response toResponse( MissingRequiredFieldException e )
    {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage())
            .type("text/plain").build();
    }
}
