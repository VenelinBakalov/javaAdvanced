package gfx;


import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage background;
    public static BufferedImage player;
    public static BufferedImage enemy;
    public static BufferedImage projectile;
    public static BufferedImage enemyMeleeUnit;

    public static void init() {
        background = ImageLoader.loadImage("/textures/bckg.jpg");
        player = ImageLoader.loadImage("/textures/player.png");
        enemy = ImageLoader.loadImage("/textures/firstEnemy.png");
        projectile = ImageLoader.loadImage("/textures/blast.png");
        enemyMeleeUnit = ImageLoader.loadImage("/textures/meleeEnemy.png");
    }
}
