package display;


import javax.swing.*;
import java.awt.*;

public class Display {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private String name;
    private JFrame frame;
    private Canvas canvas;

    public Display(String name) {
        this.name = name;

        init(name);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    private void init(String name) {
        this.frame = new JFrame(name);
        this.frame.setSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setFocusable(true);

        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);

        this.canvas = new Canvas();
        this.canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.canvas.setVisible(true);

        this.frame.add(canvas);
        this.frame.pack();
    }
}
