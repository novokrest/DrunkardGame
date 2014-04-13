package DrunkardGame.GameObjects.StaticObjects;

import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Game;
import DrunkardGame.GameObjects.CommonObjects.GameObject;

/**
 * Created by novokrest on 3/3/14.
 */
public class Bottle extends GameObject {
    public Bottle(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
    }

    @Override
    public void accept(IGameVisitor visitor, Game game) {
        visitor.visit(this, game);
    }
}
