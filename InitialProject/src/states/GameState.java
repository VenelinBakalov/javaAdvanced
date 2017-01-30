package states;

import game.entities.EnemyShootingUnit;
import game.entities.Player;
import gfx.Assets;

import java.awt.*;

public class GameState extends State {
    private static final int GRAVITY = 2;
    public static Player player;
    public static EnemyShootingUnit firstEnemyShootingUnit;

    public GameState() {
        init();

        player = new Player("Nakovkata", 95, 130, 100, 400);
        firstEnemyShootingUnit = new EnemyShootingUnit("NekvaPachaSLesenSpriteSheet", 60, 60, 500, 450, 300, 50);
    }

    private void init() {
        Assets.init();
    }


    @Override
    public void tick() {
        player.tick();
        firstEnemyShootingUnit.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        firstEnemyShootingUnit.render(g);
    }

    public static int getGRAVITY() {
        return GRAVITY;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        GameState.player = player;
    }

    public static EnemyShootingUnit getFirstEnemyShootingUnit() {
        return firstEnemyShootingUnit;
    }

    public static void setFirstEnemyShootingUnit(EnemyShootingUnit firstEnemyShootingUnit) {
        GameState.firstEnemyShootingUnit = firstEnemyShootingUnit;
    }
}
