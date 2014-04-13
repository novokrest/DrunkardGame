package DrunkardGame.Strategies.BeggarStrategies;

import DrunkardGame.GameObjects.CommonObjects.Field;
import DrunkardGame.GameObjects.StaticObjects.*;

/**
 * Created by novokrest on 4/13/14.
 */
public class BottleFinderStrategy extends BeggarStrategy {

    public BottleFinderStrategy() {
        super();
    }

    @Override
    public void visit(Bottle bottle, Field field) {
        targetObjectCoordinates = bottle.getCoordinates();
    }
}
