/**
 * Created by Sun on 10/13/2015.
 *
 * This is a star (a large ball of very hot gas)
 */
public class Star extends CelestialBody implements FluidObject {

    @Override
    public void onMerge(CollidableObject otherObject) {
        //for now, nothing special happens
    }
}
