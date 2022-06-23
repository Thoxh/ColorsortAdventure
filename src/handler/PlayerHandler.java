package handler;

import java.util.ArrayList;

import game.Direction;
import game.Game;
import game.Player;
import game.Room;

public class PlayerHandler extends CommandHandler {

    public PlayerHandler(Game game) {
        super(game);
    }

    @Override
    public String handle(String cmd, String arg, Boolean isGui) {
        Player p = this.game.getPlayer();
        Room currentRoomOfPlayer = p.getRoom();
        switch (cmd) {
            case "/go":
            switch (arg) {
                case "north":
                    int roomNorth = currentRoomOfPlayer.getN();
                    if (roomNorth != Direction.NOEXIT) {
                        ArrayList<Room> map = this.game.getMap();
                        p.setRoom(map.get(roomNorth));
                        return "In den nördlichen Raum gewechselt. Du befindest dich nun in " + map.get(roomNorth).getName().toUpperCase();
                    } else {
                        return "Es gibt nördlich keinen Raum.";
                    }
                case "east":
                    int roomEast = currentRoomOfPlayer.getE();
                    if (roomEast != Direction.NOEXIT) {
                        ArrayList<Room> map = this.game.getMap();
                        p.setRoom(map.get(roomEast));
                        return "In den östlichen Raum gewechselt. Du befindest dich nun in " + map.get(roomEast).getName().toUpperCase();
                    } else {
                        return "Es gibt östlich keinen Raum.";
                    }
                case "south":
                    int roomSouth = currentRoomOfPlayer.getS();
                    if (roomSouth != Direction.NOEXIT) {
                        ArrayList<Room> map = this.game.getMap();
                        p.setRoom(map.get(roomSouth));
                        return "In den südlichen Raum gewechselt. Du befindest dich nun in " + map.get(roomSouth).getName().toUpperCase();
                    } else {
                        return "Es gibt südlich keinen Raum.";
                    }
                case "west":
                    int roomWest = currentRoomOfPlayer.getW();
                    if (roomWest != Direction.NOEXIT) {
                        ArrayList<Room> map = this.game.getMap();
                        p.setRoom(map.get(roomWest));
                        return "In den westlichen Raum gewechselt. Du befindest dich nun in " + map.get(roomWest).getName().toUpperCase();
                    } else {
                        return "Es gibt westlich keinen Raum.";
                    }
                default:
                return "Du kannst nur in die Richtungen NORTH, EAST, SOUTH und WEST gehen. Probiere es erneut.";
            }
            case "/setname":
                if (arg.equals("")) {
                    return "Benutze /setname <name>";
                }
                p.setName(arg);
                return "Dein Name lautet nun " + p.getName().toUpperCase() + ".";
            default:
                return "Ein Fehler im PlayerHandler ist aufgetreten.";

        }
    }

    @Override
    protected String[] getPhrases() {
        return new String[]{"/go", "/setname"};
    }    
}
