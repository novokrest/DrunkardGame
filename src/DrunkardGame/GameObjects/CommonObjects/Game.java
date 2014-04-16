package DrunkardGame.GameObjects.CommonObjects;

import DrunkardGame.GameInterfaces.IGameMoving;
import DrunkardGame.GameInterfaces.IGameObservable;
import DrunkardGame.GameObjects.StaticObjects.*;

import java.util.ArrayList;

/**
 * Created by novokrest on 3/3/14.
 */
public class Game implements IGameObservable {
    public int step = 0;
    Field field;
    ArrayList<IGameMoving> movingObjects;
    Pub pub;
    PoliceStation policeStation;
    GlassPoint glassPoint;

    public Game() {
        field = new Field(17, 17);
        movingObjects = new ArrayList<IGameMoving>();
        pub = new Pub(10, 0);
        policeStation = new PoliceStation(16, 4);
        glassPoint = new GlassPoint(0, 5);
        field.register(pub);
        field.register(policeStation);
        field.register(glassPoint);
        field.register(new Column(8, 8));
        field.register(new Lamppost(11, 4));
    }

    public void start() {
        while (true) {
            try { Thread.sleep(300); } catch (Exception e) {}
            notifyAboutStep();
            field.print();
            step++;
        }
    } 
    private void nextStep() {
        if (step % 20 == 0) {

        }
        notifyAboutStep();
        step++;
    }

    @Override
    public void registerGameObject(IGameMoving movingObject) {
        movingObjects.add(movingObject);
    }

    public void notifyAboutStep() {
        for (int i = 0; i < movingObjects.size(); i++) {
            movingObjects.get(i).makeStep(field);
        }
    }
}
