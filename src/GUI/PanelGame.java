package GUI;

import GUI.leftpanel.infopanel.InfoTable;
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
import java.util.Collections;

/**
 * Game panel
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class PanelGame extends JPanel implements Runnable {
    private final String path = "assets/";
    private final double OFFSET_X = 60;

    private Thread thread;
    private BufferedImage image;
    private BufferedImage icon;
    private ArrayList<Competitor> activeCompetitors;
    private ArrayList<Competitor> competitors;
    private double ratio;

    /**
     * Default ctor
     */
    public PanelGame() {
        activeCompetitors = new ArrayList<>();
    }

    /**
     * Setting the background image
     *
     * @param weatherCondition the weather condition
     */
    private void setImage(WeatherCondition weatherCondition) {
        String pic = null;
        switch (weatherCondition) {
            case STORMY:
                pic = path + "Stormy.jpg";
                break;
            case CLOUDY:
                pic = path + "Cloudy.jpg";
                break;
            case SUNNY:
                pic = path + "Sunny.jpg";
                break;
        }
        try {
            image = ImageIO.read(new File(pic));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        updateUI();
    }

    /**
     * Resizing the image with new width and height
     *
     * @param newW the new width
     * @param newH the new height
     * @param img  the image to resize
     * @return new image with new width and height
     */
    private BufferedImage resizeImage(int newW, int newH, BufferedImage img) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;

    }

    /**
     * Paints the component. Draws the background and the players.
     *
     * @param g graphics object
     */
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);

        // Indent each player to the right
        int j = 0;
        for (Competitor i : activeCompetitors) {
            g.drawImage(icon, j, (int) (i.getLocation().getX() * ratio), null);
            j += OFFSET_X;
            System.out.println(i);
        }

    }

    /**
     * Setting the required icon for the sportsman
     *
     * @param sportsman the sportsman to use to define the icon
     */
    public void setPlayerIcon(WinterSportsman sportsman) {
        boolean isFemale = sportsman.getGender().toString().equals("FEMALE");
        boolean isSkier = sportsman instanceof Skier;
        String sb = (isSkier ? "ski" : "snowboard") + (isFemale ? "female" : "male") + ".png";
        String playerIcon = path + sb;

        try {
            icon = ImageIO.read(new File(playerIcon));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        icon = resizeImage(50, 50, icon);
        updateUI();
    }

    /**
     * Adds a competitor to the active competitors array
     *
     * @param comp the competitor to add
     */
    public void addCompetitor(Competitor comp) {
        this.activeCompetitors.add(comp);
        updateMainFrameWidth();
    }

    /**
     * Updates main frame size if there too many competitors
     */
    private void updateMainFrameWidth() {
        int width = 1000;
        int height = GuiManager.getMainFrame().getHeight();

        if (activeCompetitors.size() > 14) {
            int numOfPlayers = activeCompetitors.size() - 14;
            width += numOfPlayers * (OFFSET_X + 5);
        }

        GuiManager.getMainFrame().setSize(width, height);

        image = resizeImage(width, height, image);
    }

    /**
     * Clears the array of active players
     */
    public void clearCompetitorsArray() {
        this.activeCompetitors.clear();
        updateUI();
    }

    /**
     * Starts the race and updates the graphics
     */
    public void startRace() {
        if (thread == null || !thread.isAlive()) {
            thread = new Thread(this);
            thread.start();
        }
        competitors = new ArrayList<>(activeCompetitors);
    }

    /**
     * Updates the ratio of arena length to keep the players in the screen
     */
    public void setRatio(double len) {
        ratio = (len - 90) / len;
    }

    /**
     * While has active players - update the UI and info table every 30millis
     */
    @Override
    public void run() {
        while (GameEngine.getInstance().getComp().hasActiveCompetitors()) {
            updatePlayers();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        updatePlayers();
    }

    /**
     * Updates the UI and info table for each player
     */
    private void updatePlayers() {
        updateUI();
        ArrayList<Competitor> temp = sortPlayers();
        for (int i = 0; i < temp.size(); ++i) {
            Competitor c = temp.get(i);
            InfoTable.getModel().updateRow(i, c.getName(), c.getSpeed(), c.getMaxSpeed(), c.getLocation().getX(), c.isFinished());
        }
    }

    /**
     * Sorts the info table by location in real time
     * from top to bottom
     * the winner placed first in the table
     */
    private ArrayList<Competitor> sortPlayers() {
        for (int i = 0; i < competitors.size() - 1; i++) {
            for (int j = 0; j < competitors.size() - i - 1; j++) {
                Competitor player1 = competitors.get(j);
                Competitor player2 = competitors.get(j + 1);
                if (player1.isFinished() || player2.isFinished())
                    continue;
                if (player1.getLocation().getX() < player2.getLocation().getX()) {
                    Collections.swap(competitors, j, j + 1);
                }
            }
        }
        return competitors;
    }

    /**
     * Sets the background image according to the weather condition and resize it to arena length
     *
     * @param weatherCondition the weather condition
     * @param width            window width
     * @param len              arena length
     */
    public void setBackgroundImage(WeatherCondition weatherCondition, int width, int len) {
        setImage(weatherCondition);
        image = resizeImage(width, len, image);
    }
}
