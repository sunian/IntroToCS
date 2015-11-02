import javafx.geometry.Point3D;

/**
 * Created by Sun on 10/3/2015.
 */
public class Main {

    /**
     * This is where the program begins execution.
     * */
    public static void main(String[] args) {
        SolarSystem mySolarSystem = new SolarSystem(); // create a new SolarSystem
        mySolarSystem.addCelestialBody(new Star("SUN", new Point3D(0, 0, 0), 3330000.0)); // our SolarSystem now has a Star!
    }
}
