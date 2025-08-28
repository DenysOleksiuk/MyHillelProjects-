package Project_16.app;

import Project_16.app.Classes.RandomNumberGenerator;
import Project_16.app.Classes.StringListProcessor;
import Project_16.app.Interfaces.MathOperation;
import Project_16.app.Interfaces.StringManipulator;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        MathOperation operation = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        StringManipulator manipulator = new StringManipulator() {
            @Override
            public String toUpperCase(String s) {
                return s.toUpperCase();
            }
        };

        Function<String, Integer> countUppercase = s -> StringListProcessor.countUppercase(s);

        Supplier<Integer> random = () -> new RandomNumberGenerator().generateRandomNumber(1, 100);

        System.out.println("Math operation result: " + operation.operate(1, 2));
        System.out.println("Manipulator result: " + manipulator.toUpperCase("Hello"));
        System.out.println("Count uppercase result: " + countUppercase.apply("Hello World!"));
        System.out.println("Random number: " + random.get());




    }
}
