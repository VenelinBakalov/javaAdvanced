package states;

import display.Display;
import gfx.Assets;

import java.awt.*;

public class GameState extends State{
    public GameState() {
    }

    private void init() {
        Assets.init();
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        this.bs = this.display.getCanvas().getBufferStrategy();

        if (this.bs == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.g = this.bs.getDrawGraphics();

        g.clearRect(0, 0, Display.WIDTH, Display.HEIGHT);

        //Start drawing


        //g.drawImage(this.sh.crop(0, i), 100, 100, null);


        //END drawing
        this.g.dispose();
        this.bs.show();

    }
}
