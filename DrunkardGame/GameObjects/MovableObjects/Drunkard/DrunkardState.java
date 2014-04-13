package DrunkardGame.GameObjects.MovableObjects.Drunkard;

import DrunkardGame.GameInterfaces.IGameStrategy;
import DrunkardGame.GameInterfaces.IGameVisitable;
import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Field;
import DrunkardGame.GameObjects.CommonObjects.Game;

/**
 * Created by novokrest on 3/4/14.
 */

public class DrunkardState implements IGameVisitable {

    IGameStrategy strategy;

    public DrunkardState(IGameStrategy strategy) {
        this.strategy = strategy;
    }

    public void makeStepHandle(Drunkard drunkard) {

    }


    public void makeStep(Field field) {
    }

    @Override
    public void accept(IGameVisitor visitor, Game game) {
        visitor.visit(this, game);
    }
}