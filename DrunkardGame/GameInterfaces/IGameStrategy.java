package DrunkardGame.GameInterfaces;

import DrunkardGame.GameObjects.CommonObjects.Coordinates;

/**
 * Created by novokrest on 4/12/14.
 */
public interface IGameStrategy {
    Coordinates generateNewCoordinates(Coordinates oldCoordinates);
}
