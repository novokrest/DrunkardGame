package DrunkardGame.GameObjects.MovableObjects.Drunkard;

import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Game;

/**
 * Created by novokrest on 3/3/14.
 */
public class DrunkardSleepingState extends DrunkardState {
    public DrunkardSleepingState(Drunkard drunkard) {
        super(drunkard);
    }

    @Override
    public void accept(IGameVisitor visitor, Game game) {
        visitor.visit(this, game);
    }
}
