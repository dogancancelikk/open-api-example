package com.example.OpenApiDemo.controller;

import com.example.OpenApiDemo.exceptions.MissingRequiredFieldException;
import com.example.OpenApiDemo.model.TwoNumberSumRequest;
import com.example.OpenApiDemo.service.TwoNumberSumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/algorithm" )
@Api( "/algorithm" )
public class AlgorithmController
{

    @POST
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    @Path( "/twonumbersum" )
    public Response calculateTwoNumberSum( TwoNumberSumRequest twoNumberSumRequest )
    {
        TwoNumberSumService twoNumberSumService = new TwoNumberSumService( );
        Integer countOfTwoNumberSumPair = twoNumberSumService
            .getCountOfTwoNumberSumPair( twoNumberSumRequest.getArray( ), twoNumberSumRequest.getTargetSum( ) );

        return Response.status( Response.Status.OK ).entity( countOfTwoNumberSumPair ).build( );
    }
}