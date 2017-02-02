package game.entities;


import gfx.Assets;
import gfx.SpriteSheet;
import states.GameState;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class EnemyShootingUnit extends Unit {

    private String name;
    private int width, height, x, y, velocityX, velocityY, health, initialX, movementRange, shootingRange, damage;

    private String direction;

    private SpriteSheet enemyImage;
    private Rectangle boundingBox;

    private int col;

    private int shootingTimer;
    private Set<Projectile> projectiles;

    public EnemyShootingUnit(String name, int width, int height, int x, int y, int shootingRange, int damage, int health) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        this.shootingRange = shootingRange;
        this.damage = damage;

        this.velocityX = this.velocityY = 4;
        this.health = health;

        this.boundingBox = new Rectangle(x, y, width, height);
        this.enemyImage = new SpriteSheet(Assets.enemy, width, height);
        this.col = 0;

        this.direction = "left";
        this.initialX = x;
        this.movementRange = this.velocityX * 20;

        this.shootingTimer = 0;
        this.projectiles = new HashSet<>();
    }

    @Override
    public void tick() {

        // See if player is in range. If yes - stop and fire at him.
        if (isPlayerInRange(GameState.getPlayer())) {
            if (shootingTimer <= 0) {
                Projectile projectile = new Projectile(13, 30, this.x, this.y, this);
                projectiles.add(projectile);
                shootingTimer = 30;
            } else {
                shootingTimer--;
            }

            // If no player is in range the Unit moves left and right around it's spawn point.
        } else {
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

        // If there are any projectiles fired call their tick().
        for (Projectile projectile : projectiles) {
            projectile.tick();
        }
    }

    @Override
    public void render(Graphics graphics) {

        // See if player is in range. If yes - render static graphics.
        if (isPlayerInRange(GameState.getPlayer())) {
            graphics.drawImage(this.enemyImage.crop(1, 3), this.x, this.y, null);
        } else {
            if (direction.equals("left")) {
                graphics.drawImage(this.enemyImage.crop(1, col), this.x, this.y, null);
            } else {
                graphics.drawImage(this.enemyImage.crop(2, col), this.x, this.y, null);
            }
        }

        // If there are any projectiles fired call their render().
        for (Projectile projectile : projectiles) {
            projectile.render(graphics);
        }
    }

    public boolean isPlayerInRange(Player player) {
        return this.x - this.shootingRange <= player.getBoundingBox().getMaxX();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getShootingRange() {
        return shootingRange;
    }

    public void setShootingRange(int shootingRange) {
        this.shootingRange = shootingRange;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Set<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(Set<Projectile> projectiles) {
        this.projectiles = projectiles;
    }
}
