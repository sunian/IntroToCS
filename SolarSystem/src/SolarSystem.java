import javafx.geometry.Point3D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun on 10/14/2015.
 * <p>
 * A solar system consists of many celestial bodies, including a star, some planets, and maybe a comet.
 * As time passes, the celestial bodies should revolve around one another because of gravity.
 */
public class SolarSystem {
    public List<CelestialBody> myCelestialBodies;

    public SolarSystem() {
        myCelestialBodies = new ArrayList<CelestialBody>();
    }

    public List<CelestialBody> getMyCelestialBodies() {
        return myCelestialBodies;
    }

    public void draw(GraphicsContext gc) {
        for (int i = 0; i < getMyCelestialBodies().size(); i++) {
            getMyCelestialBodies().get(i).draw(gc);
        }
    }

    /**
     * Add a new Celestial Body to this Solar System
     */
    public void addCelestialBody(CelestialBody aBody) {
        myCelestialBodies.add(aBody);
    }

    public void handleTimeLapse(double timeInterval) {
        timeInterval /= 1000;
        for (int firstIndex = 0; firstIndex < myCelestialBodies.size() - 1; firstIndex++) {
            CelestialBody firstBody = myCelestialBodies.get(firstIndex);
            for (int secondIndex = firstIndex + 1; secondIndex < myCelestialBodies.size(); secondIndex++) {
                CelestialBody secondBody = myCelestialBodies.get(secondIndex);
                Point3D force = secondBody.calcForceOnBody(firstBody);
                firstBody.applyForce(force, timeInterval);
                force = force.multiply(-1); // reverse the force before applying to second body
                secondBody.applyForce(force, timeInterval);
            }
        }
        for (CelestialBody body : myCelestialBodies) {
            body.applyMyVelocity(timeInterval);
        }
    }
}
