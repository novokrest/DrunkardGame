package DrunkardGame.CommonObjects;

import DrunkardGame.GameInterfaces.IGameStrategy;
import DrunkardGame.GameObjects.CommonObjects.Coordinates;

/**
 * Created by novokrest on 4/12/14.
 */
public class DrunkardWalkingStrategy implements IGameStrategy{
    @Override
    public Coordinates generateNewCoordinates(Coordinates oldCoordinates) {
        int oldX = oldCoordinates.getX();
        int oldY = oldCoordinates.getY();
        int newX = Math.random() < 0.5 ? oldX + 1 : oldX - 1;
        int newY = Math.random() < 0.5 ? oldY + 1 : oldY - 1;

        return new Coordinates(newX, newY);
    }
}
