package game.entities;


import java.awt.*;

public abstract class Unit {
    public abstract void tick();

    public abstract void render(Graphics graphics);
}
