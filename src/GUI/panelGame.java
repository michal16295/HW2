package GUI;

import game.GameEngine;
import game.competition.Competitor;
import game.entities.sportsman.Skier;
import game.entities.sportsman.WinterSportsman;
import game.enums.WeatherCondition;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Game panel
 */
public class panelGame extends JPanel implements Runnable{
    private BufferedImage image;
    private BufferedImage icon;
    ArrayList <Competitor> tempActive;
    private double ratio;


    public panelGame() {
        tempActive = new ArrayList<>();
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
        int j = 0;
        for(Competitor i: tempActive){
            g.drawImage(icon, j, (int)(i.getLocation().getX() * ratio), null);
            j += 100;
        }
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
    public void setTempActive(ArrayList <Competitor> tempActive){
        this.tempActive = tempActive;
    }
    public ArrayList <Competitor> getTempActive(){
        return tempActive;
    }
    public void addCompetitor(Competitor comp){
        this.tempActive.add(comp);
    }
    public void clearArray(){
        this.tempActive.clear();
    }
    public void startRace(){
        new Thread(this).start();
    }
    public void setRatio(){
        ratio = (GameEngine.getInstance().getArena().getLength() - 90) / GameEngine.getInstance().getArena().getLength();
    }

    /**
     * while has active player - update the info table every 30millis
     */
    @Override
    public void run() {
        while(GameEngine.getInstance().getComp().hasActiveCompetitors()){
            updatePlayers();
            try{
                Thread.sleep(30);
            }
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        updatePlayers();
    }

    private void updatePlayers() {
        updateUI();
        for (int i = 0; i < tempActive.size(); ++i) {
            Competitor c = tempActive.get(i);
            InfoTable.getModel().updateRow(i, c.getSpeed(), c.getLocation().getX(), c.isFinished());
        }
    }
}
