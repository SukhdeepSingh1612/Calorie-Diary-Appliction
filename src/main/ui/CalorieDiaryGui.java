package ui;

import model.Food;
import model.Workout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

// Class represents a Jframe containing food and workout lists.
// Jfame has to get users food intake and workout detail

public class CalorieDiaryGui extends DiaryInitializer {

    JFrame mainframe = new JFrame("Calorie Diary");             //creates Jframe with title mainframe.
    JButton button3;                                                //creates button to go back to home sceen
    private JList list;                                             //creates list for food logs
    private JList list2;                                            //creates list for workout logs
    JLabel mylabel;                                                 //creates label to store image
    ImageIcon logo;                                                 //creates imageicon to hold image

    /*
     * MODIFIES: this
     * EFFECTS: calls initializer and other panels on to frame and sets frame default setting
     */
    public CalorieDiaryGui() {

        mainframe.setLayout(new FlowLayout());
        mainframe.setBackground(Color.BLACK);
        initializer();
        imagePanel();
        buttonPanel();
        logPanel();
        File imageIcon = new File("./data/logogif.png");
        Image icon = null;
        try {
            icon = ImageIO.read(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainframe.setIconImage(icon);
        mainframe.pack();
        mainframe.setVisible(true);
        mainframe.setSize(1000, 640);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    /*
     * EFFECTS: creates new panel for image, to add image in label and then add to panel with constraints.
     */

    private void imagePanel() {
        JPanel panelimage = new JPanel(new GridBagLayout());
        GridBagConstraints a = new GridBagConstraints();
        a.insets = new Insets(10, 100, 10, 100);
        a.gridx = 0;
        a.gridy = 1;
        panelimage.add(mylabel);
        mainframe.add(panelimage);
    }

    /*
     * EFFECTS: initializer calls methods to initialize labels, images and buttons
     */

    private void initializer() {
        logo = new ImageIcon("./data/logonew.png");
        mylabel = new JLabel(logo);
        mylabel.setSize(10, 10);

        buttonInitializer();
    }
    /*
     * EFFECTS:  initializes button
     */

    private void buttonInitializer() {
        button3 = new JButton("Go back to Home Screen");
    }

    /*
     * EFFECTS: creates new panel for buttons, to add button for user to go back to home screen and then
     * add to panel with constraints.
     */
    private void buttonPanel() {
        JPanel panel3 = new JPanel(new GridBagLayout());
        GridBagConstraints a = new GridBagConstraints();
        a.insets = new Insets(10, 100, 10, 100);
        panel3.add(button3, a);
        ActionListener action4 = goBackToHomeScreen();
        button3.addActionListener(action4);
        mainframe.add(panel3);

    }

    /*
     * EFFECTS: creates new panel for logs, to add food and workout list for user to go see their logs and then
     * add to panel with constraints. Adds Logs to the list using listModels methods
     */
    private void logPanel() {

        List<Food> foodList = diary.sendFood();
        List<Workout> workoutList = diary.sendWorkout();
        JPanel panel5 = new JPanel();
        panelSettings(panel5);
        DefaultListModel listModel = new DefaultListModel();
        DefaultListModel listModel2 = new DefaultListModel();
        listModel.addElement("Your Food Logs :- ");
        listModel2.addElement("Your Workout Logs :- ");
        list = new JList(listModel);
        list.setPreferredSize(new Dimension(450, 450));
        list2 = new JList(listModel2);
        list2.setPreferredSize(new Dimension(450, 450));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(list);
        for (Food food : foodList) {
            listModel.addElement(food.toString());
        }
        JScrollPane listScrollPane2 = new JScrollPane(list2);
        for (Workout workout : workoutList) {
            listModel2.addElement(workout.toString());
        }
        panelToFrame(panel5, listScrollPane, listScrollPane2);
    }
    /*
     * EFFECTS:  sets default panel settings
     */

    private void panelSettings(JPanel panel5) {
        panel5.setBackground(Color.darkGray);
        panel5.setSize(1000, 450);
    }
    /*
     * EFFECTS:  Adds list to panel and then adds panel to frame
     */

    private void panelToFrame(JPanel panel5, JScrollPane listScrollPane, JScrollPane listScrollPane2) {
        panel5.add(listScrollPane);
        panel5.add(listScrollPane2);
        mainframe.add(panel5);
    }

    /*
     * EFFECTS: creates new action for go back to home screen button.
     */

    private ActionListener goBackToHomeScreen() {
        ActionListener action4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainframe.setVisible(false);
                new UserInformation(false);
            }
        };
        return action4;
    }


}
