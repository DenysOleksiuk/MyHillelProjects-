package Project_16.app.Classes;

public class RandomNumberGenerator {

    public int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
