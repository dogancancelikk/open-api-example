package com.example.OpenApiDemo.model;

import java.util.ArrayList;
import java.util.List;

public class TwoNumberSumRequest
{
    ArrayList<Integer> array;
    Integer targetSum;

    public ArrayList<Integer> getArray( )
    {
        return array;
    }

    public void setArray( ArrayList<Integer> array )
    {
        this.array = array;
    }

    public Integer getTargetSum( )
    {
        return targetSum;
    }

    public void setTargetSum( Integer targetSum )
    {
        this.targetSum = targetSum;
    }
}
