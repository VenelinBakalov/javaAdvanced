package game.entities;


import java.awt.*;

public interface Collectable {

    void tick();

    void render(Graphics graphics);

    boolean isCollected(Player player);
}
