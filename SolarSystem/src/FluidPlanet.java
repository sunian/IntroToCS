import javafx.geometry.Point3D;

/**
 * Created by Kathy on 11/1/2015.
 */
public class FluidPlanet extends Planet implements FluidObject {

    public FluidPlanet(String name, Point3D startingLocation, Double mass) {
        super(name, startingLocation, mass);
    }

    @Override
    public void onMerge(CollidableObject otherObject) {

    }
}
