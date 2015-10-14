/**
 * Created by Sun on 10/3/2015.
 */
public class Main {

    /**
     * This is where the program begins execution.
     * */
    public static void main(String[] args) {
        SolarSystem mySolarSystem = new SolarSystem(); // create a new SolarSystem
        mySolarSystem.addCelestialBody(new Star()); // our SolarSystem now has a Star!
    }
}
