package app;

public class Main {

    private static final double CONV_T = 273.15;

    public static void main(String[] args) {
        System.out.println("App for converting Celsius to Kelvin");
        System.out.println("Version 1.0");


        double celsius = 25.0;
        double kelvin = toKelvin(celsius);
        System.out.println("Result is: " + "Kelvin: " + kelvin);

    }

    private static double toKelvin(double celsius) {
        return celsius + CONV_T;
    }
}