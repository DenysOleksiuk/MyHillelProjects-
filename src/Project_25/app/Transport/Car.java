package Project_25.app.Transport;

import Project_25.app.Interfaces.Transport;

public class Car implements Transport {

    private String model;
    private String color;
    private int maxSpeed;

    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void move(){
        System.out.println("Car is driving.");
    }


}
