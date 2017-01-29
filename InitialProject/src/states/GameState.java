package states;

import display.Display;
import game.entities.Enemy;
import game.entities.Player;
import gfx.Assets;

import java.awt.*;

public class GameState extends State {
    private static final int GRAVITY = 2;
    public static Player player;
    public static Enemy firstEnemy;

    public GameState() {
        init();

        player = new Player("Nakovkata", 95, 130, 100, 400);
        firstEnemy = new Enemy("NekvaPachaSLesenSpriteSheet", 60, 60, 400, 450);
    }

    private void init() {
        Assets.init();
    }


    @Override
    public void tick() {
        player.tick();
        firstEnemy.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        firstEnemy.render(g);
    }
}
