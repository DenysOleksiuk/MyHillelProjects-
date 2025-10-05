package Project_25.app.Factory;

import Project_25.app.Interfaces.Transport;
import Project_25.app.Transport.Plane;

public class PlaneFactory extends TransportFactory {

    @Override
    public Transport createTransport() {
        return new Plane("Boing", "White", 300);
    }
}
