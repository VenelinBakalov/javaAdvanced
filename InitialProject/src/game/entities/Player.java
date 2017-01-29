package game.entities;


import gfx.Assets;
import gfx.SpriteSheet;

import java.awt.*;

public class Player extends Unit{
    // Seriously???
    private final int CHUCK_NORRIS = Integer.MAX_VALUE;

    private String name;
    private int width, height, x, y, velocityX, velocityY, health;

    public static boolean isMovingLeft;
    public static boolean isMovingRight;

    private SpriteSheet playerImage;
    private Rectangle boundingBox;

    private int col;

    public Player(String name, int width, int height, int x, int y) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.velocityX = this.velocityY = 4;
        // Well...we are talking about nakovkata so...
        this.health = CHUCK_NORRIS;

        this.boundingBox = new Rectangle(x, y, width, height);
        this.playerImage = new SpriteSheet(Assets.player, width, height);
        this.col = 0;
    }

    @Override
    public void tick() {
        if (isMovingRight) {
            col++;
            if (col >= 7) {
                col = 0;
            }
        } else if (isMovingLeft) {
            col--;
            if (col < 0) {
                col = 6;
            }
        }

        //Isn't this supposed to be below the lower if() ???
        this.boundingBox.setBounds(this.x, this.y, this.width, this.height);

        if (isMovingRight) {
            this.x += this.velocityX;
        } else if (isMovingLeft) {
            this.x -= this.velocityX;
        }
    }

    @Override
    public void render(Graphics g) {
        if (isMovingLeft || isMovingRight) {
            g.drawImage(this.playerImage.crop(0, col), this.x, this.y, null);
        } else {
            g.drawImage(this.playerImage.crop(0, 0), this.x, this.y, null);
        }
    }

    public boolean intersects(Rectangle enemy) {
        if (this.boundingBox.contains(enemy.x, enemy.y) ||
            enemy.contains(this.boundingBox.x, this.boundingBox.y)) {
            return true;
        }

        return false;
    }
}
