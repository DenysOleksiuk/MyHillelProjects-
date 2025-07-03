package app;

public class Main {

    private static final double CONV_T = 273.15;

    public static void main(String[] args) {
        System.out.println("App for converting Celsius to Kelvin");
        System.out.println("Version 1.0");


        double celsius = 25;
        double klv = 300;
        double kelvin = toKelvin(celsius);
        double cls = toCelsius(klv);
        System.out.println("Result is: " + "Kelvin: " + kelvin + "Celsius: " + cls);

    }

    private static double toKelvin(double celsius) {
        return celsius + CONV_T;
    }

    private static double toCelsius(double kelvin) {
        return kelvin - CONV_T;
    }
}