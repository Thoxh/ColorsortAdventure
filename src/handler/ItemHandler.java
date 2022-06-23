package handler;

import java.util.ArrayList;

import game.Game;
import game.Item;
import game.Player;
import game.Room;

public class ItemHandler extends CommandHandler {

    public ItemHandler(Game game) {
        super(game);
    }

    @Override
    public String handle(String cmd, String arg) {
        Player p = this.game.getPlayer();
        Room r = p.getRoom();
        ArrayList<Item> itemsInRoom = r.getItems();
        switch (cmd) {
            case "/viewitems":
                String itemListOutput = "";
                for (Item item : itemsInRoom) {
                    itemListOutput = itemListOutput + "- " + item.getName().toUpperCase() + "\n";
                }
                System.out.println("Im aktuellen Raum (" + r.getName().toUpperCase() + ") befinden sich folgende Gegenstände:");
                return itemListOutput;
            case "/pickup":
                if (arg.equals("")) {
                    return "Bitte gebe einen Gegenstand an. /pickup <Gegenstand>";
                }
                for (Item item : itemsInRoom){
                    if (item.getName().equals(arg)){
                        p.addItemToInventory(item);
                        r.removeItemsFromRoom(item);
                        return item.getName().toUpperCase() + " wurde aufgesammelt.";
                    }
                }
                return arg + " konnte nicht gefunden werden";
            case "/inventory":
                String inventoryOutput = "";
                ArrayList<Item> inventory = p.getInventory();
                if (inventory.isEmpty()) {
                    return "Es sind keine Gegenstände im Inventar vorhanden.";
                }
                for (Item item : inventory) {
                    inventoryOutput = inventoryOutput + "- " + item.getName().toUpperCase() + "\n";
                }
                System.out.println("Folgende Items befinden sich in deinem Inventar:");
                return inventoryOutput;
            case "/drop": 
                if (arg.equals("")) {
                    return "Bitte gebe einen Gegenstand an. /pickup <Gegenstand>";
                }
                for (Item item : p.getInventory()) {
                    if (item.getName().equals(arg)) {
                        p.removeItemFromInventory(item);
                        r.addItemToInventory(item);
                        game.checkGameFinished();
                        return item.getName().toUpperCase() + " wurde in " + r.getName().toUpperCase() + " abgelegt.";
                    }

                }
                return arg.toUpperCase() + " befindet sich nicht in deinem Inventar.";
            default: 
                return "Ein Fehler im ItemHandler ist aufgetreten";

        }
        
    }

    @Override
    protected String[] getPhrases() {
        return new String[]{"/pickup", "/viewitems", "/drop", "/inventory"};
    }
    
}
