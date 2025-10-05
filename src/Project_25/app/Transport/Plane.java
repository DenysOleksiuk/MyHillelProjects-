package Project_25.app.Transport;

import Project_25.app.Interfaces.Transport;

public class Plane implements Transport {

    private String model;
    private String color;
    private int maxSpeed;

    public Plane(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void move() {
        System.out.println("Plane is flying");
    }

}
