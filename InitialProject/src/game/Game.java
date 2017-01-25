package game;

import display.Display;
import gfx.Assets;
import gfx.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private String title;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    private SpriteSheet sh;

    private Thread thread;
    private boolean isRunning;

    //Testing
    private int i = 0;


    public Game(String name) {
        this.title = name;
    }

    private void init() {
        Assets.init();

        this.display = new Display(this.title);
        this.sh = new SpriteSheet(Assets.player, 95, 130);
      //  SpriteSheet background = new SpriteSheet(Assets.background, 800, 600);
    }

    private void tick() {
        i++;
        if (i >= 7) i = 0;

    }

    private void render() {
        this.bs = this.display.getCanvas().getBufferStrategy();

        if (this.bs == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.g = this.bs.getDrawGraphics();

        g.clearRect(0, 0, Display.WIDTH, Display.HEIGHT);

        //Start drawing


        g.drawImage(this.sh.crop(0, i), 100, 100, null);


        //END drawing
        this.g.dispose();
        this.bs.show();

    }

    @Override
    public void run() {
        this.init();

        int fps = 14;
        double timePerTick = 1_000_000_000.0 / fps;
        double delta = 0;
        //The current time in nanoseconds
        long now;
        long lastTime = System.nanoTime();

        while (isRunning) {
            //Sets the variable to the current time in nanoseconds
            now = System.nanoTime();

            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if (delta >= 1) {
                //If we don't want to lower the framerate take the this.tick() outside the while loop.
                this.tick();
                this.render();
                delta--;

            }


        }

        this.stop();
    }

    public synchronized void start() {
        this.thread = new Thread(this);

        this.isRunning = true;
        this.thread.start();
    }

    public synchronized void stop() {
        try {
            this.isRunning = false;
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
