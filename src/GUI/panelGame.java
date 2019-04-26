package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class panelGame extends JPanel {
    private BufferedImage image;
    private panelArena arena;


    public panelGame() {
        try {
            image = ImageIO.read(new File("/Users/michalbarski/Desktop/Work/HW2/assets/Cloudy.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, null);
    }

}
