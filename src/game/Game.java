package game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import handler.ActionHandler;
import handler.ErrorHandler;
import handler.ExitHandler;
import handler.InfoHandler;
import handler.ItemHandler;
import handler.PlayerHandler;

public class Game {
    private BufferedReader input;
    private PrintStream output;
    private List<ActionHandler> actionhandlers; 
    private boolean exitGame;
    private boolean wonGame;
    private ArrayList<Room> map;
    private Player player;
    

    public Game() {
        this.input = new BufferedReader(new InputStreamReader(System.in));
        this.output = System.out;
        this.actionhandlers = new ArrayList<>();
        this.exitGame = false;
        this.wonGame = false;
        this.map = new ArrayList<Room>();

        /*      3
         *    2 0 4   
         *      1
         */

        // BLUE ROOM 0
        ArrayList<Item> blueRoomItems = new ArrayList<Item>();
        blueRoomItems.add(new Item("red_ink_bag", "This item have to be collected and bring to the RED room", "red"));
        map.add(new Room(3, 4, 1, 2, "blue_room", "blue", blueRoomItems));

        // YELLOW ROOM 1
        ArrayList<Item> yellowRoomItems = new ArrayList<Item>();
        yellowRoomItems.add(new Item("black_ink_bag", "This item have to be collected and bring to the BLACK room", "black"));
        map.add(new Room(0, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, "yellow_room", "yellow", yellowRoomItems));

        // RED ROOM 2
        ArrayList<Item> redRoomItems = new ArrayList<Item>();
        redRoomItems.add(new Item("blue_ink_bag", "This item have to be collected and bring to the BLUE room", "blue"));
        map.add(new Room(Direction.NOEXIT, 0, Direction.NOEXIT, Direction.NOEXIT, "red_room", "red", redRoomItems));

        // GREEN ROOM 3
        ArrayList<Item> greenRoomItems = new ArrayList<Item>();
        greenRoomItems.add(new Item("yellow_ink_bag", "This item have to be collected and bring to the YELLOW room", "yellow"));
        map.add(new Room(Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT, "green_room", "green", greenRoomItems));

        // BLACK ROOM 4
        ArrayList<Item> blackRoomItems = new ArrayList<Item>();
        blackRoomItems.add(new Item("green_ink_bag", "This item have to be collected and bring to the GREEN room", "green"));
        map.add(new Room(Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, "black_room", "black", blackRoomItems));

        this.actionhandlers.add(new ExitHandler(this));
        this.actionhandlers.add(new PlayerHandler(this));
        this.actionhandlers.add(new ItemHandler(this));
        this.actionhandlers.add(new InfoHandler(this));
        
        this.player = new Player(map.get(0), "unknown");
    }

    public void changeExitStatus() {
        this.exitGame = true;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ArrayList<Room> getMap() {
        return map;
    }

    public void run() throws IOException {
        String cmd = "";
        System.out.println("--- Color Sort Adventure ---");
        System.out.println("Jeder Raum besitzt eine Farbe und einen Farbbeutel als Gegenstand. \nSammel alle Farben und bringe sie in den richtigen Raum.");
        while(!exitGame && !wonGame) {

            // input logic
            this.output.print(">> ");
            cmd = this.input.readLine();

            // working logic
            String output = this.process(cmd);
        

            // output logic
            this.output.println(output);
            this.output.println();
        }

    }

    public String process(String cmd) {
        ActionHandler relevantHandler = null;
        String arg = "";
        cmd = cmd.toLowerCase();
        List<String> splitedCMD = new ArrayList<String>(Arrays.asList(cmd.split(" ")));
        if (splitedCMD.size() > 2) {
            relevantHandler = new ErrorHandler(this);
            return relevantHandler.handle(cmd, "");
        }
        if (splitedCMD.size() > 1) {
            arg = splitedCMD.get(1);
        }
        cmd = splitedCMD.get(0);
        for (ActionHandler handler : this.actionhandlers) {
            if (handler.matches(cmd)) {
                relevantHandler = handler;
                break;
            }
        }
        if (relevantHandler == null) {
            relevantHandler = new ErrorHandler(this);
        }

        return relevantHandler.handle(cmd, arg);


    }

    public Boolean checkGameFinished() {
        int score = 0;
        for (Room r : map) {
            for (Item item : r.getItems()) {
                if (item.getColor().equals(r.getDescription())) {
                    score++;
                }
                if (score == map.size()) {
                    break;
                } 
            }
            if (score == map.size()) {
                break;
            } 
        }
        if (score == map.size()) {
            System.out.println("Du hast gewonnen!");
            this.wonGame = true;
        }
        System.out.println("Dein Punktestand: " + score + "/" + map.size());
        return false;
        
    }
}