package DrunkardGame.GameObjects.DrunkardStates;

import DrunkardGame.GameInterfaces.*;
import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;

/**
 * Created by novokrest on 3/3/14.
 */
public class DrunkardWalkingState implements IDrunkardState {

    @Override
    public Coordinates makeStepHandle(Coordinates drunkardCoordinates) {
        int oldX = drunkardCoordinates.getX();
        int oldY = drunkardCoordinates.getY();
        int newX = Math.random() < 0.5 ? oldX + 1 : oldX - 1;
        int newY = Math.random() < 0.5 ? oldY + 1 : oldY - 1;
        return new Coordinates(newX, newY);
    }

    @Override
    public void accept(IGameVisitor visitor, Field field) {
        visitor.visit(this, field);
    }

    @Override
    public void print() {
        System.out.print('D');
    }
}
