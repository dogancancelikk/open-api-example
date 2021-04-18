package com.example.OpenApiDemo.service;

import com.example.OpenApiDemo.exceptions.ErrorMessages;
import com.example.OpenApiDemo.exceptions.MissingRequiredFieldException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TwoNumberSumServiceTest
{

    @ParameterizedTest
    @MethodSource( "provideTargetArrayAndSum" )
    void getCountOfTwoNumberSumPair_valid( List<Integer> targetArray, Integer targetSum, Integer expectedValue )
    {
        TwoNumberSumService twoNumberSumService = new TwoNumberSumService( );
        Integer countOfTwoNumberSumPair = twoNumberSumService.getCountOfTwoNumberSumPair( targetArray, targetSum );

        assertEquals( expectedValue, countOfTwoNumberSumPair );
    }

    private static Stream<Arguments> provideTargetArrayAndSum( )
    {
        return Stream.of(
            Arguments.of( Arrays.asList( 1, 1, 2, 2, 3, 3, 4 ), 5, 2 ),
            Arguments.of( Arrays.asList( 3, 5, -4, 8, 11, 1, -1, 6 ), 10, 1 ),
            Arguments.of( Arrays.asList( 3, 5, -4, 8, 11, 1, -1, 6, 2 ), 10, 2 ),
            Arguments.of( Arrays.asList( 1,-1,2,-2,3,-3), 0, 3 ),
            Arguments.of( Arrays.asList( -1,-1, -2, 0, -2), -2, 2 )
        );
    }

    @Test
    void getCountOfTwoNumberSumPair_missingTargetSumField_throwException( )
    {
        List<Integer> array = Arrays.asList( 3, 5, -4, 8, 11, 1, -1, 6 );
        Integer targetSum = null;
        TwoNumberSumService twoNumberSumService = new TwoNumberSumService( );
        Executable executable = ( ) -> twoNumberSumService.getCountOfTwoNumberSumPair( array, targetSum );
        MissingRequiredFieldException missingRequiredFieldException =
            assertThrows( MissingRequiredFieldException.class, executable );

        assertEquals( ErrorMessages.MISSING_TARGET_SUM_FIELD.getErrorMessage( ),
            missingRequiredFieldException.getMessage( ) );
    }

    @ParameterizedTest
    @MethodSource( "provideMissingTargetArray" )
    void getCountOfTwoNumberSumPair_missingArrayField_throwException( List<Integer> array, Integer targetSum )
    {
        TwoNumberSumService twoNumberSumService = new TwoNumberSumService( );
        Executable executable = ( ) -> twoNumberSumService.getCountOfTwoNumberSumPair( array, targetSum );
        MissingRequiredFieldException missingRequiredFieldException =
            assertThrows( MissingRequiredFieldException.class, executable );

        assertEquals( ErrorMessages.MISSING_TARGET_ARRAY_FIELD.getErrorMessage( ),
            missingRequiredFieldException.getMessage( ) );
    }

    private static Stream<Arguments> provideMissingTargetArray( )
    {
        return Stream.of(
            Arguments.of( Arrays.asList( ), 5 ),
            Arguments.of( Arrays.asList( 6 ), 10 ),
            Arguments.of( null, 10 )
        );
    }

}