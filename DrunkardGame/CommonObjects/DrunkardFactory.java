package DrunkardGame.CommonObjects;

import DrunkardGame.GameInterfaces.IGameFactory;
import DrunkardGame.GameObjects.MovableObjects.Drunkard.Drunkard;

/**
 * Created by novokrest on 4/12/14.
 */
public class DrunkardFactory implements IGameFactory{
    int drunkardX;
    int drunkardY;

    public DrunkardFactory(int x, int y) {
        drunkardX = x;
        drunkardY = y;
    }

    @Override
    public Drunkard makeObject() {
        return new Drunkard(drunkardX, drunkardY);
    }
}
