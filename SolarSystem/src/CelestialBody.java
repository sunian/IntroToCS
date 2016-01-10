import javafx.geometry.Point3D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Sun on 10/13/2015.
 * <p>
 * This is the parent class for all celestial bodies.
 */
public abstract class CelestialBody implements CollidableObject {
    public Point3D location; // the body's current location in space; units = AU
    public String name;
    public double mass; //  units = Earth masses
    public Color color;
    public static int axisScale = 100;
    public static int massScale = 200;
    public static double logBase = 1.4;
    public static double diameterScale = Math.log(logBase);

    public CelestialBody(String name, Point3D startingLocation, Double mass) {
        this.name = name;
        this.location = startingLocation;
        this.mass = mass;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(GraphicsContext gc) {
        double diameter = Math.log(mass * massScale) / diameterScale;
        gc.setFill(color);
        gc.fillOval(location.getX() * axisScale - diameter / 2.0, location.getY() * axisScale - diameter / 2.0, diameter, diameter);
    }

    @Override
    public void collideWith(CollidableObject otherObject) {
        if (this == otherObject) {
            //an object cannot collide with itself
            return;
        }
        if (this instanceof FluidObject) {// if this object is a FluidObject
            ((FluidObject) this).onMerge(otherObject);
        }
        if (otherObject instanceof FluidObject) {// if the other object is a FluidObject
            ((FluidObject) otherObject).onMerge(this);
        }
    }

    @Override
    public String toString() {
        return "this is a celestial body called " + name;
    }
}
