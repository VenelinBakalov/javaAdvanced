package game;

import display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    private String title;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    private Thread thread;
    private boolean isRunning;

    // Testing
    private int x;

    public Game(String name) {
        this.title = name;
    }

    private void init() {
        this.display = new Display(this.title);

        this.x = 100;
    }

    private void tick() {
        this.x++;
    }

    private void render() {
        this.bs = this.display.getCanvas().getBufferStrategy();

        if (this.bs == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.g = this.bs.getDrawGraphics();

        g.clearRect(0, 0, Display.WIDTH, Display.HEIGHT);

        g.setColor(Color.red);
        g.fillRect(this.x, 200, 50, 50);

        g.setColor(Color.green);
        g.fillRect(150, 250, 100, 100);

        this.g.dispose();
        this.bs.show();

    }

    @Override
    public void run() {
        this.init();

        while (isRunning) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.tick();
           this.render();
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
