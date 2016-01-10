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
    public Point3D velocity; // the body's current velocity; units = AU/yr
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
        velocity = new Point3D(0, 0, 0);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public void setVelocity(Point3D velocity) {
        this.velocity = velocity;
    }

    public double calcDistanceToBody(CelestialBody otherBody) {
        return otherBody.location.distance(this.location);
    }

    public Point3D calcForceOnBody(CelestialBody otherBody) {
        double distanceToBody = calcDistanceToBody(otherBody);
        double magnitude = 0.0000001 * otherBody.mass * this.mass / distanceToBody * distanceToBody;
        double angleFromThisToOther = Math.atan2(this.location.getY() - otherBody.location.getY(),
                this.location.getX() - otherBody.location.getX());
        return new Point3D(magnitude * Math.cos(angleFromThisToOther), magnitude * Math.sin(angleFromThisToOther), 0);
    }

    public void applyForce(Point3D force, double timeInterval) {
        Point3D aTimesT = force.multiply(timeInterval / mass); // acceleration * timeInterval
        velocity = velocity.add(aTimesT);
    }

    public void applyMyVelocity(double timeInterval) {
        location = location.add(velocity.multiply(timeInterval));
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
