package DrunkardGame.GameObjects.MovableObjects.Beggar;

import DrunkardGame.GameInterfaces.IGameMoving;
import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;
import DrunkardGame.GameObjects.CommonObjects.GameObject;
import DrunkardGame.GameObjects.MovableObjects.Drunkard.*;
import DrunkardGame.GameObjects.MovableObjects.Policeman;
import DrunkardGame.GameObjects.StaticObjects.*;

import java.util.Queue;

/**
 * Created by novokrest on 4/12/14.
 */
public class Beggar extends GameObject implements IGameMoving {

    BottleFinder bottleFinder;

    public Beggar(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
        bottleFinder = new BottleFinder();
    }

    @Override
    public void makeStep(Field field) {
        Coordinates nextCoordinates = bottleFinder.makeStepToBottle(coordinates, field);
        if (! nextCoordinates.equals(coordinates)) {
            field.swapGameObject(coordinates, nextCoordinates);
            coordinates = nextCoordinates;
        }
    }

    @Override
    public void visit(GameObject gameObject, Field field) {
        int currentX = gameObject.getX();
        int currentY = gameObject.getY();
        isVisit[currentX][currentY] = true;
        objectsForVisit.add(field.getObject(currentX - 1, currentY));
        objectsForVisit.add(field.getObject(currentX + 1, currentY));
        objectsForVisit.add(field.getObject(currentX, currentY - 1));
        objectsForVisit.add(field.getObject(currentX, currentY + 1));
        predecessors[currentX - 1][currentY] =
                predecessors[currentX + 1][currentY] =
                        predecessors[currentX][currentY - 1] =
                                predecessors[currentX][currentY + 1] = gameObject;
    }

    @Override
    public void visit(Border border, Field field) {

    }

    @Override
    public void visit(Bottle bottle, Field field) {
        isBottleFound = true;
        bottleCoordinates = bottle.getCoordinates();
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
    public void visit(DrunkardState state, Field field) {

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
