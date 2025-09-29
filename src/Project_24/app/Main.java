package Project_24.app;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("logger == logger2: " + (logger == logger2));

        logger.log("Starting program.");

        logger2.log("Finishing program.");
    }
}