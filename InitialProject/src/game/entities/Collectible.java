package game.entities;


import gfx.SpriteSheet;

import java.awt.*;

public abstract class Collectible {

    private String name;

    private int width, height, x, y;

    private SpriteSheet collectibleImage;
    private Rectangle boundingBox;


    public Collectible(String name, int width, int height, int x, int y) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        this.boundingBox = new Rectangle(x, y, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    public boolean isCollected(Player player) {
        if (this.boundingBox.contains(player.getX(), player.getY()) ||
                this.boundingBox.contains(player.getBoundingBox().getMaxX(), player.getBoundingBox().getY()) ||
                this.boundingBox.contains(player.getBoundingBox().getX(), player.getBoundingBox().getMaxY()) ||
                this.boundingBox.contains(player.getBoundingBox().getMaxX(), player.getBoundingBox().getMaxY())) {
            return true;
        }

        return false;
    }
}
