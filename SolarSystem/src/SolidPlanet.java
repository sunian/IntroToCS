import javafx.geometry.Point3D;

/**
 * Created by Kathy on 11/1/2015.
 */
public class SolidPlanet extends Planet implements SolidObject {

    public SolidPlanet(String name, Point3D startingLocation, Double mass) {
        super(name, startingLocation, mass);
    }

    @Override
    public void bounce(SolidObject otherObject) {

    }
}
