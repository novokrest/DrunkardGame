package DrunkardGame.GameObjects.DrunkardStates;

import DrunkardGame.GameInterfaces.IDrunkardState;
import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;

/**
 * Created by novokrest on 3/3/14.
 */
public class DrunkardLyingState implements IDrunkardState {

    @Override
    public Coordinates makeStepHandle(Coordinates drunkaCoordinates) {
        return drunkaCoordinates;
    }

    @Override
    public void accept(IGameVisitor visitor, Field field) {
        visitor.visit(this, field);
    }

    @Override
    public void print() {
        System.out.print('&');
    }
}
