package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {

    private int n, e, s, w;
    private String name;
    private String description;
    private ArrayList<Item> items;

    public Room(int n, int e, int s, int w, String name, String description, ArrayList<Item> items) {
        this.n = n;
        this.e = e;
        this.s = s;
        this.w = w;
        this.name = name;
        this.description = description;
        this.items = items;
    }

    public int getN() {
        return n;
    }

    public int getE() {
        return e;
    }

    public int getS() {
        return s;
    }

    public int getW() {
        return w;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItemToInventory(Item item) {
        items.add(item);
    }

    public void removeItemsFromRoom(Item item) {
        items.remove(item);
    }

    public String getInfo(Room r) {
        String roomInfo = "";
        roomInfo = roomInfo + "Raum: " + this.name.toUpperCase() + "\n";
        roomInfo = roomInfo + "Beschreibung: " + this.description + "\n";
        roomInfo = roomInfo + "Ausgänge: \n";
        Map<String, Integer> exits = new HashMap<>();
        String[] directions = {Direction.NORTH.name(), Direction.EAST.name(), Direction.SOUTH.name(), Direction.WEST.name()};
        int[] isExit = {this.n, this.e, this.s, this.w};
        for (int i = 0; i < directions.length; i++) {
            exits.put(directions[i], isExit[i]);
        }
        for (String key : exits.keySet()) {
            if (exits.get(key) != Direction.NOEXIT) {
                roomInfo = roomInfo + "- " + key + "\n";
            }
        }

        roomInfo = roomInfo + "Gegenstände: \n";
        for (Item item : items) {
            roomInfo = roomInfo + "- " + item.getName().toUpperCase() + "\n";
        }
        return roomInfo;
    }
    
}
