package DrunkardGame.GameObjects.MovableObjects;

import DrunkardGame.GameInterfaces.IDrunkardState;
import DrunkardGame.GameInterfaces.IFinderStrategy;
import DrunkardGame.GameInterfaces.IGameMoving;
import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;
import DrunkardGame.GameObjects.CommonObjects.GameObject;
import DrunkardGame.GameObjects.StaticObjects.*;
import DrunkardGame.GameObjects.DrunkardStates.DrunkardLyingState;
import DrunkardGame.GameObjects.DrunkardStates.DrunkardSleepingState;
import DrunkardGame.GameObjects.DrunkardStates.DrunkardWalkingState;
import DrunkardGame.Strategies.BeggarStrategies.BottleFinderStrategy;
import DrunkardGame.Strategies.BeggarStrategies.GlassPointFinderStrategy;

/**
 * Created by novokrest on 4/12/14.
 */
public class Beggar extends GameObject implements IGameMoving {

    IFinderStrategy beggarStrategy;

    public Beggar(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
        beggarStrategy = new BottleFinderStrategy();
    }

    @Override
    public void makeStep(Field field) {
        Coordinates nextCoordinates = beggarStrategy.getOptimalStep(getCoordinates(), field);
        field.getObject(nextCoordinates.getX(), nextCoordinates.getY()).accept(this, field);
    }

    @Override
    public void visit(GameObject gameObject, Field field) {
        field.swapGameObject(this.getCoordinates(), gameObject.getCoordinates());
    }

    @Override
    public void visit(Border border, Field field) {

    }

    @Override
    public void visit(Bottle bottle, Field field) {
        field.unregister(bottle.getCoordinates());
        beggarStrategy = new GlassPointFinderStrategy();
    }

    @Override
    public void visit(Column column, Field field) {
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
    public void visit(IDrunkardState state, Field field) {

    }

    @Override
    public void visit(DrunkardWalkingState state, Field field) {

    }

    @Override
    public void visit(DrunkardLyingState state, Field field) {

    }

    @Override
    public void visit(DrunkardSleepingState state, Field field) {

    }

    @Override
    public void visit(Beggar beggar, Field field) {

    }

    @Override
    public void visit(Policeman policeman, Field field) {

    }
}
