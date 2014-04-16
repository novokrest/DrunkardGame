package DrunkardGame.GameInterfaces;

import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;

/**
 * Created by Admin on 4/13/14.
 */
public interface IFinderStrategy {
    Coordinates getOptimalStep(Coordinates startCoordinates, Field field);
}
