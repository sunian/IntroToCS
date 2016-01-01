import javafx.geometry.Point3D;

/**
 * Created by Sun on 10/13/2015.
 *
 * This is the parent class for all celestial bodies.
 */
public abstract class CelestialBody implements CollidableObject {
    public Point3D location; // the body's current location in space; units = AU
    public String name;
    public double mass; //  units = Earth masses

    public CelestialBody(String name, Point3D startingLocation, Double mass) {
        this.name = name;
        this.location = startingLocation;
        this.mass = mass;
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
