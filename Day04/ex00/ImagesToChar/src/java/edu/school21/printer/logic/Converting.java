package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Converting {
    private char white;
    private char black;
    private File file;
    public Converting(char white, char black, File file) {
        this.white = white;
        this.black = black;
        this.file = file;
    }

    public void draw() {
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < bufferedImage.getHeight(); i++) {
            for (int j = 0; j < bufferedImage.getWidth(); j++) {
                if (bufferedImage.getRGB(j,i) == -16777216) System.out.print(black);
                else if (bufferedImage.getRGB(j,i) == -1) System.out.print(white);
            }
            if (i + 1 < bufferedImage.getHeight()) System.out.println();
        }
    }
}
//C:\Users\edvar\OneDrive\Рабочий стол\java_subj\it.bmp