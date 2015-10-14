/**
 * Created by Sun on 10/13/2015.
 *
 * A FluidObject is any object that is made of fluids, such as liquids or gases.
 * For example, a RainDrop or a Cloud are FluidObjects.
 * Because it is made of fluids, a FluidObject is able to merge with other physical objects.
 */
public interface FluidObject extends CollidableObject {
    void onMerge(CollidableObject otherObject); // this should be called when this FluidObject collides with another CollidableObject
}
