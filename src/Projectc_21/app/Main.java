package Projectc_21.app;

import Projectc_21.Utils.ArrayUtils;
import Projectc_21.Anotation.Author;
import Projectc_21.Anotation.MethodInfo;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Method[] methods = ArrayUtils.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodInfo.class) && method.isAnnotationPresent(Author.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                Author author = method.getAnnotation(Author.class);
                System.out.println("Method name: " + methodInfo.methodName());
                System.out.println("Param type: " + methodInfo.paramType());
                System.out.println("Description: " + methodInfo.description());
                System.out.println("Return type: " + methodInfo.returnType());
                System.out.println("Author: " + author.firstName() + " " + author.lastName());
                System.out.println("--------------------------------------------------");
            }
        }

        int[] arr = {5,546,34,2,46};

        System.out.println("Max value: " + ArrayUtils.findMax(arr));
        System.out.println("Min value: " + ArrayUtils.findMin(arr));
        System.out.println("Average value: " + ArrayUtils.average(arr));

    }
}
