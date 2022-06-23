package handler;
import game.Game;

public abstract class CommandHandler extends ActionHandler {

    public CommandHandler(Game game) {
        super(game);
    }

    @Override
    public boolean matches(String command) {
        String[] phrases = this.getPhrases();
        for (String phrase : phrases) {
            if (phrase.equals(command)) {
                return true;
            }
        }
        return false;
    }
    
    protected abstract String[] getPhrases(); 
    
}
