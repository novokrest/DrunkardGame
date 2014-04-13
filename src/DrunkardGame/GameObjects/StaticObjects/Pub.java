package DrunkardGame.GameObjects.StaticObjects;

import DrunkardGame.GameInterfaces.IGameFactory;
import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Game;
import DrunkardGame.GameObjects.CommonObjects.GameObject;
import DrunkardGame.GameObjects.MovableObjects.Drunkard;

/**
 * Created by novokrest on 3/3/14.
 */
public class Pub extends GameObject implements IGameFactory {
    public Pub(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
    }

    @Override
    public void accept(IGameVisitor visitor, Game game) {
        visitor.visit(this, game);
    }

    @Override
    public Drunkard makeObject() {
        return new Drunkard(coordinates.getX(), coordinates.getY() + 1);
    }
}