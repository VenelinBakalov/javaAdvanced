package gfx;


import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage image;
    private int cropWidth;
    private int cropHeight;

    public SpriteSheet(BufferedImage image, int cropWidth, int cropHeight) {
        this.image = image;
        this.cropWidth = cropWidth;
        this.cropHeight = cropHeight;
    }

    public BufferedImage crop(int row, int col) {
        return this.image.getSubimage(col * cropWidth, row * cropHeight, cropWidth, cropHeight);
    }
}
