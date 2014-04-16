package DrunkardGame.GameInterfaces;

/**
 * Created by novokrest on 3/4/14.
 */
public interface IGameObservable {
    public void registerGameObject(IGameMoving gameObject);
    public void notifyAboutStep();
}
