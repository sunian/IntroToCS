import javafx.geometry.Point3D;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

/**
 * Created by Sun on 10/13/2015.
 *
 * This is a star (a large ball of very hot gas)
 */
public class Star extends CelestialBody implements FluidObject {
    public List<Planet> planets;

    public Star(String name, Point3D startingLocation, Double mass) {
        super(name, startingLocation, mass);
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(500, 200, 100, 100);

    }


    @Override
    public void onMerge(CollidableObject otherObject) {
        //for now, nothing special happens
    }
}
