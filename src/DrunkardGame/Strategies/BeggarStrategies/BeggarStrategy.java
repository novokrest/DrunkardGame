package DrunkardGame.Strategies.BeggarStrategies;

import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;
import DrunkardGame.Strategies.FinderStrategy;

/**
 * Created by Admin on 4/13/14.
 */
public class BeggarStrategy extends FinderStrategy{

    @Override
    public Coordinates getOptimalStep (Coordinates startCoordinates,  Field field) {
        traverseField(startCoordinates, field);
        if (targetObjectCoordinates != null) {
            Coordinates nextCoordinates = getOptimalStepToTarget();
            return nextCoordinates;
        }
        return startCoordinates;
    }
}
