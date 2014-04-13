package DrunkardGame.GameObjects.MovableObjects.Beggar;

import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Coordinates;
import DrunkardGame.GameObjects.CommonObjects.Field;
import DrunkardGame.GameObjects.CommonObjects.GameObject;
import DrunkardGame.GameObjects.MovableObjects.Drunkard.*;
import DrunkardGame.GameObjects.MovableObjects.Policeman;
import DrunkardGame.GameObjects.StaticObjects.*;

import java.util.Queue;

/**
 * Created by novokrest on 4/13/14.
 */
public class BottleFinder implements IGameVisitor{

    boolean isBottleFound;
    boolean[][] isVisit;
    Coordinates bottleCoordinates;
    GameObject[][] predecessors;
    Queue<GameObject> objectsForVisit;

    public BottleFinder() {}

    public Coordinates makeStepToBottle (Coordinates startCoordinates,  Field field) {
        isBottleFound = false;
        isVisit = new boolean[field.getRowCount()][field.getColumnCount()];
        predecessors = new GameObject[field.getRowCount()][field.getColumnCount()];
        findBottle(startCoordinates, field);
        if (isBottleFound) {
            Coordinates nextCoordinates = getOptimalStepToBottle();
            return nextCoordinates;
        }
        return startCoordinates;
    }

    private void findBottle (Coordinates startCoordinates, Field field) {
        int startX = startCoordinates.getX();
        int startY = startCoordinates.getY();
        objectsForVisit.add(field.getObject(startX, startY));
        predecessors[startX][startY] = null;
        while (!objectsForVisit.isEmpty() && !isBottleFound) {
            GameObject objectForVisit = objectsForVisit.poll();
            objectForVisit.accept(this, field);
        }
    }

    private Coordinates getOptimalStepToBottle() {
        int currentX = bottleCoordinates.getX();
        int currentY = bottleCoordinates.getY();
        while (predecessors[currentX][currentY] != null) {
            currentX = predecessors[currentX][currentY].getX();
            currentY = predecessors[currentX][currentY].getY();
        }
        return new Coordinates(currentX, currentY);
    }

    private void addNeighborsFromFieldForVisit (GameObject predecessor, Field field) {
        int currentX = predecessor.getX();
        int currentY = predecessor.getY();
        addObjectFromFieldForVisit(currentX - 1, currentY, predecessor, field);
        addObjectFromFieldForVisit(currentX + 1, currentY, predecessor, field);
        addObjectFromFieldForVisit(currentX, currentY - 1, predecessor, field);
        addObjectFromFieldForVisit(currentX, currentY + 1, predecessor, field);
    }

    private void addObjectFromFieldForVisit (int coordinateX, int coordinateY, GameObject predecessor, Field field) {
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
        addNeighborsFromFieldForVisit(beggar, field);
    }

    @Override
    public void visit(Policeman policeman, Field field) {

    }
}
