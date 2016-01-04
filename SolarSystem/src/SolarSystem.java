import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun on 10/14/2015.
 *
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

    /**
     * Add a new Celestial Body to this Solar System
     * */
    public void addCelestialBody(CelestialBody aBody) {
        myCelestialBodies.add(aBody);
    }

    public void timePasses(double timeInterval) {

    }
}
