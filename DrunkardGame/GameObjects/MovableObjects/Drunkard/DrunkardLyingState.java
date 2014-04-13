package DrunkardGame.GameObjects.MovableObjects.Drunkard;

import DrunkardGame.GameInterfaces.IGamePrintable;
import DrunkardGame.GameInterfaces.IGameVisitable;
import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Game;

/**
 * Created by novokrest on 3/3/14.
 */
public class DrunkardLyingState extends DrunkardState implements IGameVisitable, IGamePrintable {

    @Override
    public void accept(IGameVisitor visitor, Game game) {
        visitor.visit(this, game);
    }

    @Override
    public void print() {
        System.out.print('&');
    }
}
