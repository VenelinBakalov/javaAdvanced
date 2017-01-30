package game.entities;


import gfx.Assets;
import gfx.SpriteSheet;
import states.GameState;

import java.awt.*;

public class Projectile implements Shootable{

    private int width, height, x, y, velocityX, velocityY, damage;

    private SpriteSheet projectileImage;
    private Rectangle boundingBox;

    private int col;

    private EnemyShootingUnit enemyShootingUnit;

    public Projectile(int width, int height, int x, int y, EnemyShootingUnit enemyShootingUnit) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.velocityX = this.velocityY = 10;

        this.boundingBox = new Rectangle(x, y, width, height);
        this.projectileImage = new SpriteSheet(Assets.projectile, width, height);

        this.enemyShootingUnit = enemyShootingUnit;

        this.damage = enemyShootingUnit.getDamage();
    }

    @Override
    public void tick() {
        // Flying in left direction
        this.x -= this.velocityX;

        this.boundingBox.setBounds(this.x, this.y, this.width, this.height);

        Player player = GameState.getPlayer();

        // Projectile hits target
        if (this.intersects(player.getBoundingBox())) {
            player.setHealth(player.getHealth() - this.damage);
            GameState.setPlayer(player);

            System.out.println(GameState.getPlayer().getHealth());

            this.enemyShootingUnit.getProjectiles().remove(this);
        } else if (!this.isInRange()) {
            // Check whether projectile is out of range
            this.enemyShootingUnit.getProjectiles().remove(this);
        }
    }

    @Override
    public void render(Graphics graphics) {

        graphics.drawImage(this.projectileImage.crop(8, 5), this.x, this.y, null);

    }

    @Override
    public boolean intersects(Rectangle player) {
        if (this.boundingBox.contains(player.x, player.y) ||
                player.contains(this.boundingBox.x, this.boundingBox.y)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isInRange() {
        return this.x >= enemyShootingUnit.getX() - enemyShootingUnit.getShootingRange();
    }
}
