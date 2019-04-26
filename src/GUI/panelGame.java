package GUI;

import game.enums.WeatherCondition;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class panelGame extends JPanel {
    private BufferedImage image;



    public panelGame() {

    }
    public void setImage(WeatherCondition weatherCondition) {
        if (weatherCondition == WeatherCondition.CLOUDY) {
            try {
                image = ImageIO.read(new File("assets/Cloudy.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (weatherCondition == WeatherCondition.SUNNY) {
            try {
                image = ImageIO.read(new File("assets/Sunny.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (weatherCondition == WeatherCondition.STORMY) {
            try {
                image = ImageIO.read(new File("assets/Stormy.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        updateUI();
    }
    public void resize(int newW, int newH) {
        Image tmp = image.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        this.image = dimg;

    }
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, null);

    }

}
