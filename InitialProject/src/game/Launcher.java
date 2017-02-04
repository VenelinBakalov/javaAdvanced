package game;

import javafx.scene.control.Menu;

public class Launcher  {
    public static void main(String[] args) {
    	Menu start = new Menu();
    	
        GameEngine game = new GameEngine("JAVA LIVE GAME!1!");

        game.start();
    }
}
