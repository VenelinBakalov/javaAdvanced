package game.entities;


import java.awt.*;

public interface Shootable {

    public void tick();

    public void render(Graphics graphics);

    public boolean intersects(Rectangle player);

    public boolean isInRange();
}
