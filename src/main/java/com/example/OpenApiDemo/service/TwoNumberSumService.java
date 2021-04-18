package com.example.OpenApiDemo.service;

import com.example.OpenApiDemo.exceptions.ErrorMessages;
import com.example.OpenApiDemo.exceptions.MissingRequiredFieldException;

import java.util.*;

public class TwoNumberSumService
{
    public Integer getCountOfTwoNumberSumPair( List<Integer> targetArray, Integer targetSum )
    {
        if ( targetSum == null  )
        {
            throw new MissingRequiredFieldException( ErrorMessages.MISSING_TARGET_SUM_FIELD.getErrorMessage( ) );
        }
        else if ( targetArray == null || targetArray.size( ) <= 1 )
        {
            throw new MissingRequiredFieldException( ErrorMessages.MISSING_TARGET_ARRAY_FIELD.getErrorMessage() );
        }
        return findCountOfTwoNumberSumPair( targetArray, targetSum );
    }

    private Integer findCountOfTwoNumberSumPair( List<Integer> targetArray, int targetSum) {

        Set<Integer> distinctNumbersInTargetArray = new HashSet<>( );
        Set<Integer> repeatedNumbersInTargetArray = new HashSet<>( );

        Set<Integer> numbers = new HashSet<>( );
        List<Integer[]> listOfPairs = new ArrayList<>( );

        for ( int element : targetArray )
        {
            if ( distinctNumbersInTargetArray.contains( element ) )
            {
                repeatedNumbersInTargetArray.add( element );
            }else
            {
                distinctNumbersInTargetArray.add( element );
            }
        }

        for ( int num : distinctNumbersInTargetArray )
        {
            int potentialMatch = targetSum - num;
            if ( numbers.contains( potentialMatch ) )
            {
                listOfPairs.add( new Integer[] { potentialMatch, num } );
            }else
            {
                numbers.add( num );
            }
        }
        Integer[] pairFromRepeatedNumbers = findPairFromRepeatedNumbers(repeatedNumbersInTargetArray, targetSum);
        if ( pairFromRepeatedNumbers.length != 0 )
        {
            listOfPairs.add( pairFromRepeatedNumbers );
        }
        return listOfPairs.size( );
    }

    private Integer[] findPairFromRepeatedNumbers( Set<Integer> twiceNums, int targetSum )
    {
        if ( targetSum % 2 == 0 && twiceNums.contains( targetSum / 2 ) )
        {
            return new Integer[] { targetSum / 2, targetSum / 2 };
        }
        return new Integer[ 0 ];
    }
}
