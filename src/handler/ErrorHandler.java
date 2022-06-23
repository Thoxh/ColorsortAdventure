package handler;
import game.Game;

public class ErrorHandler extends ActionHandler {

    public ErrorHandler(Game game) {
        super(game);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String handle(String cmd, String arg, Boolean isGui) {
        return "Der Befehl wurde nicht gefunden oder besitzt mehr als einen Parameter.";
    }

    @Override
    public boolean matches(String cmd) {
        return true;
    }
    
}
