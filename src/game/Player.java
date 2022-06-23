package game;

import java.util.ArrayList;

public class Player {

    private Room room;
    private String name;
    private ArrayList<Item> inventory;

    public Player(Room room, String name) {
        this.room = room;
        this.name = name;
        this.inventory = new ArrayList<Item>();
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public void addItemToInventory(Item item) {
        this.inventory.add(item);
    }

    public void removeItemFromInventory(Item item) {
        this.inventory.remove(item);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        String playerInfo = "";
        playerInfo = playerInfo + "Name: " + this.getName().toUpperCase() + "\n";
        playerInfo = playerInfo + "Standort: " + this.getRoom().getName().toUpperCase() + "\n";
        playerInfo = playerInfo + "Inventar: \n";
        for (Item item : this.inventory) {
            playerInfo = playerInfo + "- " + item.getName().toUpperCase() + "\n";
        }
        return playerInfo;
    }
}
