package Project_25.app;

import Project_25.app.Factory.CarFactory;
import Project_25.app.Factory.PlaneFactory;
import Project_25.app.Factory.TransportFactory;
import Project_25.app.Interfaces.Transport;

public class Client {

    public static void run() {
        TransportFactory planeFactory = new PlaneFactory();
        TransportFactory carFactory = new CarFactory();

        Transport plane = planeFactory.createTransport();
        Transport car = carFactory.createTransport();

        plane.move();
        car.move();

    }

}
