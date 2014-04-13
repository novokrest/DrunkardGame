package DrunkardGame.GameObjects.MovableObjects.Drunkard;

import DrunkardGame.GameInterfaces.IGameVisitor;
import DrunkardGame.GameObjects.CommonObjects.Game;
import DrunkardGame.GameObjects.CommonObjects.GameObject;
import DrunkardGame.GameObjects.StaticObjects.Border;
import DrunkardGame.GameObjects.StaticObjects.Bottle;
import DrunkardGame.GameObjects.StaticObjects.Column;
import DrunkardGame.GameObjects.StaticObjects.Pub;

/**
 * Created by novokrest on 3/3/14.
 */
public class DrunkardWalkingState extends DrunkardState implements IGameVisitor {
    public DrunkardWalkingState(Drunkard drunkard) {
        super(drunkard);
    }

    @Override
    public void takeStep(Game game) {
        game.field.getObject(drunkard.getNextCoordinates()).accept(this, game);
    }

    @Override
    public void accept(IGameVisitor visitor, Game game) {
        visitor.visit(this, game);
    }

    @Override
    public void visit(GameObject gameObject, Game game) {
        game.field.swapGameObject(drunkard.coordinates, drunkard.nextCoordinates);
        if (drunkard.hasBottle) {
            if (Math.random() < 0.0333) {
                drunkard.hasBottle = false;
                Bottle bottle = new Bottle(drunkard.coordinates.getCoordinateX(),
                        drunkard.coordinates.getCoordinateY());
                game.registerGameObject(bottle);
            }
        }
        drunkard.refreshCoordinates();
    }

    @Override
    public void visit(Border border, Game game) {
        //do nothing
    }

    @Override
    public void visit(Bottle bottle, Game game) {
        drunkard.state = new DrunkardLyingState(drunkard);
    }

    @Override
    public void visit(Column column, Game game) {
        drunkard.state = new DrunkardSleepingState(drunkard);
    }

    @Override
    public void visit(Pub pub, Game game) {
        //do nothing
    }

    @Override
    public void visit(Drunkard drunkard, Game game) {
        //do nothing
    }

    @Override
    public void visit(DrunkardState state, Game game) {
        //do nothing
    }

    @Override
    public void visit(DrunkardWalkingState state, Game game) {
        //do nothing
    }

    @Override
    public void visit(DrunkardLyingState state, Game game) {
        //do nothing
    }

    @Override
    public void visit(DrunkardSleepingState state, Game game) {
        drunkard.state = new DrunkardSleepingState(drunkard);
    }
}
