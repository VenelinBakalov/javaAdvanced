package game.entities;


import gfx.Assets;
import gfx.SpriteSheet;
import states.GameState;

import java.awt.*;

public class EnemyMeleeUnit extends Unit {

    private String name;
    private int width, height, x, y, velocityX, velocityY, health, initialX, sightRange, weaponRange, damage;

    private SpriteSheet enemyMeleeImage;
    private Rectangle boundingBox;

    private int colAttack, colForward, colBackwards;

    private int attackTimer;

    public EnemyMeleeUnit(String name, int width, int height, int x, int y, int weaponRange, int damage, int health) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.weaponRange = weaponRange;
        this.damage = damage;

        this.velocityX = this.velocityY = 2;
        this.health = health;

        this.boundingBox = new Rectangle(x, y, width, height);
        this.enemyMeleeImage = new SpriteSheet(Assets.enemyMeleeUnit, width, height);
        this.colAttack = 9;
        this.colForward = 0;
        this.colBackwards = 0;

        this.initialX = x;
        this.sightRange = 100;

        this.attackTimer = 0;

    }

    @Override
    public void tick() {
        // Get the player from GameState
        Player currentPlayer = GameState.getPlayer();

        // Check whether player is within attack range and if yes - attack
        if (isPlayerInAttackRange(currentPlayer)) {

                colAttack++;
                if (colAttack >= 7) {
                    colAttack = 0;
                }

            if (attackTimer <= 0) {
                int playerRemainingHealth = currentPlayer.getHealth() - this.damage;
                currentPlayer.setHealth(playerRemainingHealth);
                GameState.setPlayer(currentPlayer);

                // Reset attack timer
                attackTimer = 20;

                System.out.println("Remaining player health: " + GameState.getPlayer().getHealth());

            } else {
                attackTimer--;
            }

            // Check if player is in range and move FAST towards him in order to attack when player is reached.
        } else if (isPlayerInSightRange(currentPlayer) && this.x >= this.initialX - this.sightRange) {
            colForward++;
            if (colForward >= 7) {
                colForward = 0;
            }

            this.x -= this.velocityX * 2;

            // If neither - return slowly to initial position.
        } else if (this.x < this.initialX) {

            colBackwards++;
            if (colBackwards >= 7) {
                colBackwards = 0;
            }

            this.x += this.velocityX;
        }

        this.boundingBox.setBounds(this.x, this.y, this.width, this.height);

    }

    @Override
    public void render(Graphics graphics) {

        // Get the player from GameState
        Player currentPlayer = GameState.getPlayer();

        // Check whether player is within attack range and if yes - render attack graphics
        if (isPlayerInAttackRange(currentPlayer)) {
            graphics.drawImage(this.enemyMeleeImage.crop(2, colAttack), this.x, this.y, null);

            // Check if player is in range and move FAST towards him.
        } else if (isPlayerInSightRange(currentPlayer) && this.x >= this.initialX - this.sightRange) {
            graphics.drawImage(this.enemyMeleeImage.crop(0, colForward), this.x, this.y, null);

            // If neither - return slowly to initial position.
        } else if (this.x < this.initialX) {
            graphics.drawImage(this.enemyMeleeImage.crop(0, colBackwards), this.x, this.y, null);

            // If at initial position - render static graphics
        } else {
            graphics.drawImage(this.enemyMeleeImage.crop(0, 2), this.x, this.y, null);
        }

    }

    public boolean isPlayerInSightRange(Player player) {
        return this.x - this.sightRange <= player.getBoundingBox().getMaxX() &&
                player.getBoundingBox().getMaxX() <= this.boundingBox.getMaxX();
    }

    public boolean isPlayerInAttackRange(Player player) {
        return this.x - this.weaponRange <= player.getBoundingBox().getMaxX() &&
                player.getBoundingBox().getMaxX() <= this.boundingBox.getMaxX();
    }
}
