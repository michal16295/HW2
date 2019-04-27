package GUI;

import game.entities.sportsman.Skier;
import game.entities.sportsman.WinterSportsman;
import game.enums.WeatherCondition;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class panelGame extends JPanel {
    private BufferedImage image;
    private BufferedImage icon;


    public panelGame() {

    }

    /**
     * Setting the background image
     * @param weatherCondition
     */
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

    /**
     * get image
     * @return image
     */
    public BufferedImage getImage(){
        return image;
    }

    /**
     * set image
     * @param image
     */
    public void setImage(BufferedImage image){
        this.image = image;
    }

    /**
     * set icon
     * @param icon
     */
    public void setIcon(BufferedImage icon){
        this.icon = icon;
    }

    /**
     * resizing the image
     * @param newW
     * @param newH
     * @param img
     * @return new image
     */
    public BufferedImage resizeImage(int newW, int newH, BufferedImage img) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;

    }
    public void paintComponent(Graphics g){
        g.drawImage(image,0, 0, null);
        g.drawImage(icon, 0, 0, null);


    }

    /**
     * setting the required icon for the sportsman
     * @param sportsman
     */
    public void playerIcon(WinterSportsman sportsman){
        if(sportsman.getGender().toString() == "FEMALE"){
            if(sportsman instanceof Skier){
                try{
                    icon = ImageIO.read(new File("assets/SkiFemale.png"));

                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            else{
                try{
                    icon = ImageIO.read(new File("assets/SnowboardFemale.png"));
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        else{
            if(sportsman instanceof Skier){
                try{
                    icon = ImageIO.read(new File("assets/Skimale.png"));
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            else{
                try{
                    icon = ImageIO.read(new File("assets/Snowboardmale.png"));
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        icon = resizeImage(50,50,icon);
        updateUI();
    }

}
