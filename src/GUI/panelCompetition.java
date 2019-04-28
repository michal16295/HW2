package GUI;

import game.GameEngine;
import game.arena.IArena;
import game.enums.Competition;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

/**
 * Competition panel - Creates the competition
 */
public class panelCompetition extends JPanel {
    private JLabel CreateCompLabel;
    private JLabel ChooseCompLabel;
    private JLabel MaxCompLabel;
    private JLabel DisciplineLabel;
    private JLabel LeagueLabel;
    private JLabel GenderLabel;

    private JComboBox ChooseCompCombobox;
    private JComboBox DisciplineCombobox;
    private JComboBox LeagueCombobox;
    private JComboBox GenderCombobox;

    private JTextField MaxCompText;
    private JButton CreateCompBtn;
    private Border blackLine;

    /***
     * panel competition ctor
     */
    public panelCompetition(){
        createData();
        //After pressing the button
        CreateCompBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelGame game = GuiManager.getInstance().get_panelGame();
                panelInfo info = GuiManager.getInstance().get_panelInfo();
                String path = "game.competition.";
                String type = "";
                int maxComp;
                try{
                    switch(ChooseCompCombobox.getSelectedItem().toString()){
                        case "Ski": type = path + "SkiCompetition";
                            break;
                        case "Snowboard": type = path + "SnowboardCompetition";
                            break;
                        default:
                            break;
                    }
                    //check if arena exists
                    IArena arena = GameEngine.getInstance().getArena();
                    if(arena == null){
                        JOptionPane.showMessageDialog(null, "Please build arena first", "Message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    //max competitors
                    try{
                        maxComp = Integer.parseInt(MaxCompText.getText());
                        if(maxComp < 1 || maxComp > 20){
                            JOptionPane.showMessageDialog(null, "Max competitors should be a between 1 to 20", "Message", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Max competitors should be a number", "Message", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                        return;
                    }
                    createCompetition(info,game,type, maxComp);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        addData();

    }

    /**
     * creating the labels, comboboxes and text fields
     */
    public void createData(){
        this.setSize(new Dimension(300,400));
        //Setting the layout
        setLayout(new GridLayout(12, 1));
        blackLine = BorderFactory.createLineBorder(Color.black);

        //Create competition label
        CreateCompLabel = new JLabel("CREATE COMPETITION");
        CreateCompLabel.setForeground(Color.blue);

        //choose competition
        ChooseCompLabel = new JLabel("Choose Competition");
        ChooseCompCombobox = new JComboBox(Competition.values());

        //Max competitors
        MaxCompLabel = new JLabel("Max Competitors Number");
        MaxCompText = new JTextField("10");

        //Discipline
        DisciplineLabel = new JLabel("Discipline");
        DisciplineCombobox = new JComboBox(Discipline.values());

        //League
        LeagueLabel = new JLabel("League");
        LeagueCombobox = new JComboBox(League.values());

        //Gender
        GenderLabel = new JLabel("Gender");
        GenderCombobox = new JComboBox(Gender.values());

        //Create comp button
        CreateCompBtn = new JButton("Create Competition");
    }

    /**
     * adding the data to the panel
     */
    public void addData(){
        add(CreateCompLabel);
        add(ChooseCompLabel);
        add(ChooseCompCombobox);
        add(MaxCompLabel);
        add(MaxCompText);
        add(DisciplineLabel);
        add(DisciplineCombobox);
        add(LeagueLabel);
        add(LeagueCombobox);
        add(GenderLabel);
        add(GenderCombobox);
        add(CreateCompBtn);
        setBorder(blackLine);
    }

    /**
     * creating the competition
     * @param info
     * @param game
     * @param type
     * @param maxComp
     */
    public void createCompetition(panelInfo info,panelGame game,String type, int maxComp){
        try{
            //Discipline
            Discipline discipline = (Discipline)DisciplineCombobox.getSelectedItem();

            //League
            League league = (League)LeagueCombobox.getSelectedItem();

            //Gender
            Gender gender = (Gender)GenderCombobox.getSelectedItem();

            //Competitor type
            GameEngine.getInstance().setType((Competition)ChooseCompCombobox.getSelectedItem());
            //dynamic class
            Class aClass = getClass().getClassLoader().loadClass(type);
            Constructor ctor = aClass.getConstructor(IArena.class, int.class, Discipline.class, League.class, Gender.class);
            Object o = ctor.newInstance(GameEngine.getInstance().getArena(), maxComp, discipline, league, gender);
            GameEngine.getInstance().setComp((game.competition.Competition) o);
            //init the race
            game.clearArray();
            info.setInRace(false);
            InfoTable.getModel().deleteData();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
