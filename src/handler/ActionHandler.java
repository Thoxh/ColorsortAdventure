package handler;
import game.Game;

public abstract class ActionHandler {
    protected Game game;

    public ActionHandler(Game game) {
        this.game = game;
    }

    public abstract String handle(String cmd, String arg);

    public abstract boolean matches(String cmd);
}
