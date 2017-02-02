package states;

import game.entities.EnemyMeleeUnit;
import game.entities.EnemyShootingUnit;
import game.entities.Player;
import gfx.Assets;

import java.awt.*;

public class GameState extends State {
    private static final int GRAVITY = 2;
    public static Player player;
    public static EnemyShootingUnit firstEnemyShootingUnit;
    public static EnemyMeleeUnit firstMeleeEnemy;

    public GameState() {
        init();

        player = new Player("Nakovkata", 95, 130, 100, 400);
        firstEnemyShootingUnit = new EnemyShootingUnit("NekvaPachaSLesenSpriteSheet", 60, 60, 650, 450, 150, 50, 250);
        firstMeleeEnemy = new EnemyMeleeUnit("Melee", 100, 134, 450, 400, 5, 35, 700);
    }

    private void init() {
        Assets.init();
    }


    @Override
    public void tick() {
        player.tick();
        firstEnemyShootingUnit.tick();
        firstMeleeEnemy.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        firstEnemyShootingUnit.render(g);
        firstMeleeEnemy.render(g);
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
