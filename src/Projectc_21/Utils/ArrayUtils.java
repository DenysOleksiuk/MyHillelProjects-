package Projectc_21.Utils;

import Projectc_21.Anotation.Author;
import Projectc_21.Anotation.MethodInfo;

import java.util.Arrays;

public class ArrayUtils {

    @MethodInfo(
            methodName = "findMax",
            paramType = "int[]",
            description = "Finds the maximum value in the array",
            returnType = "int"
    )
    @Author(
            firstName = "Denys",
            lastName = "Oleksiuk"
    )

    public static int findMax(int[] arr){
        return Arrays.stream(arr).max().orElseThrow();
    }

    @MethodInfo(
            methodName = "findMin",
            paramType = "int[]",
            description = "Finds the minimum value in the array",
            returnType = "int"
    )
    @Author(
            firstName = "Denys",
            lastName = "Oleksiuk"
    )
    public static int findMin(int[] arr){
        return Arrays.stream(arr).min().orElseThrow();
    }

    @MethodInfo(
            methodName = "average",
            paramType = "int[]",
            description = "Calculates the average value of the array",
            returnType = "double"
    )
    @Author(
            firstName = "Denys",
            lastName = "Oleksiuk"
    )
    public static double average(int[] arr){
        return Arrays.stream(arr).average().orElseThrow();
    }



}
