package game;

public class Item {

    private String name, description, color;

    public Item(String name, String description, String color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.description;
    }

    public String getColor() {
        return this.color;
    }

    public String getInfo() {
        String itemInfo = "";
        itemInfo = itemInfo + "Gegenstand: " + this.getName().toUpperCase() + "\n";
        itemInfo = itemInfo + "Beschreibung: " + this.getDesc() + "\n";
        return itemInfo;
    }
}
