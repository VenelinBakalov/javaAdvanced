package game.entities;


import gfx.Assets;
import gfx.SpriteSheet;

import java.awt.*;

public class Enemy extends Unit {

    private String name;
    private int width, height, x, y, velocityX, velocityY, health, initialX, movementRange;

    private String direction;

    private SpriteSheet enemyImage;
    private Rectangle boundingBox;

    private int col;

    public Enemy(String name, int width, int height, int x, int y) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        this.velocityX = this.velocityY = 4;
        this.health = 250;

        this.boundingBox = new Rectangle(x, y, width, height);
        this.enemyImage = new SpriteSheet(Assets.enemy, width, height);
        this.col = 0;

        this.direction = "left";
        this.initialX = x;
        this.movementRange = this.velocityX * 20;
    }

    @Override
    public void tick() {

        col++;
        if (col >= 8) {
            col = 0;
        }

        if (direction.equals("left")) {
            this.x -= this.velocityX;

            if (this.x <= initialX - movementRange) {
                direction = "right";
            }

        } else if (direction.equals("right")) {
            this.x += this.velocityX;

            if (this.x >= initialX + movementRange) {
                direction = "left";
            }
        }

        this.boundingBox.setBounds(this.x, this.y, this.width, this.height);
    }

    @Override
    public void render(Graphics graphics) {

        if (direction.equals("left")) {
            graphics.drawImage(this.enemyImage.crop(1, col), this.x, this.y, null);
        } else {
            graphics.drawImage(this.enemyImage.crop(2, col), this.x, this.y, null);
        }

    }
}
