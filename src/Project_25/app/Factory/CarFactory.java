package Project_25.app.Factory;

import Project_25.app.Interfaces.Transport;
import Project_25.app.Transport.Car;

public class CarFactory extends TransportFactory{


    @Override
    public Transport createTransport() {
        return new Car("Audi", "Black", 200);
    }

}
