package DrunkardGame.GameObjects.MovableObjects;

import DrunkardGame.GameInterfaces.IGameMoving;
import DrunkardGame.GameInterfaces.IGameVisitable;
import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;
import DrunkardGame.GameObjects.CommonObjects.GameObject;
import DrunkardGame.GameObjects.StaticObjects.*;

/**
 * Created by novokrest on 3/2/14.
 */
public class Drunkard extends GameObject implements IGameMoving, IGameVisitable {
    boolean hasBottle;
    public Drunkard.IDrunkardState drunkardState;

    public Drunkard(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
        hasBottle = true;
        drunkardState = new Drunkard.DrunkardWalkingState();
    }

    private void tryToLoseBottle(Coordinates coordinates, Field field) {
        if (hasBottle && (Math.random() < 0.0333)) {
            hasBottle = false;
            field.register(new Bottle(coordinates.getX(), coordinates.getY()));
        }
    }

    @Override
    public void accept(IGameVisitor visitor, Field field) {
        drunkardState.accept(visitor, field);
    }

    @Override
    public void makeStep(Field field) {
        Coordinates nextCoordinates = drunkardState.makeStepHandle(this.getCoordinates());
        if (nextCoordinates != this.getCoordinates()) {
            field.getObject(nextCoordinates.getX(), nextCoordinates.getY()).accept(this, field);
        }
    }

    public void print() {
        drunkardState.print();
    }

    @Override
    public void visit(GameObject gameObject, Field field) {
        field.swapGameObject(this.getCoordinates(), gameObject.getCoordinates());
        tryToLoseBottle(gameObject.getCoordinates(), field);
    }

    @Override
    public void visit(Border border, Field field) {
    }

    @Override
    public void visit(Bottle bottle, Field field) {
        drunkardState = new Drunkard.DrunkardLyingState();
    }

    @Override
    public void visit(Column column, Field field) {
        drunkardState = new Drunkard.DrunkardSleepingState();
    }

    @Override
    public void visit(GlassPoint glassPoint, Field field) {

    }

    @Override
    public void visit(Lamppost lamppost, Field field) {

    }

    @Override
    public void visit(PoliceStation policeStation, Field field) {

    }

    @Override
    public void visit(Pub pub, Field field) {

    }

    @Override
    public void visit(Drunkard drunkard, Field field) {

    }

    @Override
    public void visit(Drunkard.IDrunkardState state, Field field) {

    }

    @Override
    public void visit(Drunkard.DrunkardWalkingState state, Field field) {

    }

    @Override
    public void visit(Drunkard.DrunkardLyingState state, Field field) {
    }

    @Override
    public void visit(Drunkard.DrunkardSleepingState state, Field field) {
        drunkardState = new Drunkard.DrunkardSleepingState();
    }

    @Override
    public void visit(Beggar beggar, Field field) {

    }

    @Override
    public void visit(Policeman policeman, Field field) {

    }
}
