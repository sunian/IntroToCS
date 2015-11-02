import javafx.geometry.Point3D;

import java.util.List;

/**
 * Created by Kathy on 11/1/2015.
 */
public class Planet extends CelestialBody {
    public List<Moon> moons;

    public Planet(String name, Point3D startingLocation, Double mass) {
        super(name, startingLocation, mass);
    }
}
