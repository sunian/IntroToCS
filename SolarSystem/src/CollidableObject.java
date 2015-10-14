/**
 * Created by Sun on 10/14/2015.
 *
 * A CollidableObject is any physical object that is able to collide with other objects.
 * For example, a car is a CollidableObject because it can collide with other cars or buildings.
 * But an Integer or a Poem are not collidable since they are not physical objects.
 */
public interface CollidableObject {
    void collideWith(CollidableObject otherObject); // this should be called in order to collide this CollidableObject with another CollidableObject
}
