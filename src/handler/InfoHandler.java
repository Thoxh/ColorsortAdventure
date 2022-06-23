package handler;

import game.Game;
import game.Item;
import game.Player;
import game.Room;

public class InfoHandler extends CommandHandler {

    public InfoHandler(Game game) {
        super(game);
    }

    @Override
    public String handle(String cmd, String arg, Boolean isGui) {
        Player p = this.game.getPlayer();
        Room r = p.getRoom();
        switch (arg) {
            case "":
                return p.getInfo();
            case "room":
                return r.getInfo(r);
            default:
                for (Item item : p.getInventory()) {
                    if (item.getName().equals(arg)) {
                        return item.getInfo();
                    }
                }
                return "Der Gegenstand wurde nicht gefunden.";

        }
    }

    @Override
    protected String[] getPhrases() {
        return new String[]{"/info"};
    }


    
}
