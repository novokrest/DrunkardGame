package DrunkardGame.GameObjects.StaticObjects;

import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Game;
import DrunkardGame.GameObjects.CommonObjects.GameObject;

/**
 * Created by novokrest on 3/3/14.
 */
public class Column extends GameObject {
    public Column(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
    }

    @Override
    public void accept(IGameVisitor visitor, Game game) {
        visitor.visit(this, game);
    }
}
