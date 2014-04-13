package DrunkardGame.GameObjects.MovableObjects.Drunkard;

import DrunkardGame.GameInterfaces.IGameMoving;
import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;
import DrunkardGame.GameObjects.CommonObjects.GameObject;

/**
 * Created by novokrest on 3/2/14.
 */
public class Drunkard extends GameObject implements IGameMoving {
    public boolean hasBottle;
    public DrunkardState state;
    public Coordinates nextCoordinates;

    public Drunkard(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
        hasBottle = true;
        state = new DrunkardWalkingState(this);
    }

    public Coordinates getNextCoordinates() {
        return nextCoordinates;
    }

    public void refreshCoordinates() {
        coordinates.coordinateX = nextCoordinates.coordinateX;
        coordinates.coordinateY = nextCoordinates.coordinateY;
    }

    //@Override
    public void accept(IGameVisitor visitor, Field field) {
        state.accept(visitor, field);
    }

    @Override
    public void makeStep(Field field) {
        state.makeStepHandle(this, field);
    }

    public void print() {
        state.print();
    }
}
