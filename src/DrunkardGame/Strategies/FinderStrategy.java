package DrunkardGame.Strategies;

import DrunkardGame.GameInterfaces.IDrunkardState;
import DrunkardGame.GameInterfaces.IFinderStrategy;
import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;
import DrunkardGame.GameObjects.CommonObjects.GameObject;
import DrunkardGame.GameObjects.DrunkardStates.DrunkardLyingState;
import DrunkardGame.GameObjects.DrunkardStates.DrunkardSleepingState;
import DrunkardGame.GameObjects.DrunkardStates.DrunkardWalkingState;
import DrunkardGame.GameObjects.MovableObjects.Beggar;
import DrunkardGame.GameObjects.MovableObjects.Drunkard;
import DrunkardGame.GameObjects.MovableObjects.Policeman;
import DrunkardGame.GameObjects.StaticObjects.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Admin on 4/13/14.
 */
public abstract class FinderStrategy implements IGameVisitor, IFinderStrategy {
    protected Coordinates targetObjectCoordinates;
    protected boolean[][] isVisit;
    protected GameObject[][] predecessors;
    protected Queue<GameObject> objectsForVisit;

    public FinderStrategy() {
        //isVisit and predecessors must init
        targetObjectCoordinates = null;
        objectsForVisit = new LinkedList<GameObject>();
    }

    public abstract Coordinates getOptimalStep(Coordinates startCoordinates, Field field);

    protected Coordinates getOptimalStepToTarget() {
        int currentX = targetObjectCoordinates.getX();
        int currentY = targetObjectCoordinates.getY();
        while (predecessors[currentX][currentY] != null) {
            currentX = predecessors[currentX][currentY].getX();
            currentY = predecessors[currentX][currentY].getY();
        }
        return new Coordinates(currentX, currentY);
    }

    protected void traverseField (Coordinates startCoordinates, Field field) {
        int startX = startCoordinates.getX();
        int startY = startCoordinates.getY();
        predecessors[startX][startY] = null;
        addNeighborsFromFieldForVisit(field.getObject(startX, startY), field);
        while (!objectsForVisit.isEmpty() && (targetObjectCoordinates != null)) {
            GameObject objectForVisit = objectsForVisit.poll();
            objectForVisit.accept(this, field);
        }
    }

    protected void addNeighborsFromFieldForVisit (GameObject predecessor, Field field) {
        int currentX = predecessor.getX();
        int currentY = predecessor.getY();
        addObjectFromFieldForVisit(currentX - 1, currentY, predecessor, field);
        addObjectFromFieldForVisit(currentX + 1, currentY, predecessor, field);
        addObjectFromFieldForVisit(currentX, currentY - 1, predecessor, field);
        addObjectFromFieldForVisit(currentX, currentY + 1, predecessor, field);
    }

    protected void addObjectFromFieldForVisit (int coordinateX, int coordinateY, GameObject predecessor, Field field) {
        objectsForVisit.add(field.getObject(coordinateX, coordinateY));
        isVisit[coordinateX][coordinateY] = true;
        predecessors[coordinateX][coordinateY] = predecessor;
    }

    @Override
    public void visit(GameObject gameObject, Field field) {
        addNeighborsFromFieldForVisit(gameObject, field);
    }

    @Override
    public void visit(Border border, Field field) {

    }

    @Override
    public void visit(Bottle bottle, Field field) {
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
