package gfx;


import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage background;
    public static BufferedImage player;

    public static void init() {
        background = ImageLoader.loadImage("/textures/bckg.jpg");
        player = ImageLoader.loadImage("/textures/player.png");

    }
}
