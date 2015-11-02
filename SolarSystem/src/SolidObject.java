/**
 * Created by Kathy on 11/1/2015.
 */
public interface SolidObject extends CollidableObject {
    void bounce(SolidObject otherObject);
}
