package DrunkardGame.GameInterfaces;

import DrunkardGame.GameObjects.CommonObjects.Field;

/**
 * Created by novokrest on 3/4/14.
 */
public interface IGameMoving extends IGameVisitor {
    public void makeStep(Field field);
}
