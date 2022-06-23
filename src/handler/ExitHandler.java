package handler;
import game.Game;

public class ExitHandler extends CommandHandler {

    public ExitHandler(Game game) {
        super(game);
    }

    @Override
    public String handle(String cmd, String arg) {
        this.game.changeExitStatus();
        return "Das Programm wurde beendet.";
        
    }

    @Override
    protected String[] getPhrases() {
        return new String[]{"/exit"};
    }

    
}
