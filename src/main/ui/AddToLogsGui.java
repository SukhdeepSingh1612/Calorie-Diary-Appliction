package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
// Class represents a Jframe containing food and workout labels and text field.
// Jfame has to get users food intake and workout detail

public class AddToLogsGui extends DiaryInitializer {
    JFrame logFrame = new JFrame("Logs");              //creates Jframe with title logs.
    JLabel addFoodLabel;                                   //food label for users entry
    JLabel addFoodCalorieLabel;                            //food calorie label for users entry
    JLabel addWorkoutLabel;                                //workout label for users entry
    JLabel addWorkoutCalorieLabel;                         //workout calorie label for users entry
    JTextField foodNameText;                               //Food name text for the user
    JTextField foodCaloriesText;                           //Food calorie text for the user
    JTextField workoutNameText;                            //workout name text for the user
    JTextField workoutCaloriesText;                        //workout calorie text for the user
    JButton addFoodToLogs;                                 //button to add food to logs
    JButton addWorkoutToLogs;                              //button to add workout to logs
    JButton logsButton;                                    //button to show logs
    JLabel mylabel;                                        //label for image
    ImageIcon logo;                                        //image icon for icon

    /*
     * MODIFIES: this
     * EFFECTS: calls initializer and other panels on to frame and sets frame default setting
     */
    public AddToLogsGui() {

        initializer();
        imagePanel();
        foodInfoPanel();
        workoutInfoPanel();
        logsButton = new JButton("Show Logs");
        logFrame.add(logsButton);
        ActionListener showLogs = showTheLogs();
        logsButton.addActionListener(showLogs);
        File imageIcon = new File("./data/logogif.png");
        Image icon = null;
        try {
            icon = ImageIO.read(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logFrame.setIconImage(icon);
        logFrame.setLayout(new FlowLayout());
        logFrame.setVisible(true);
        logFrame.setSize(1000, 640);
        logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        logFrame.add(panelimage);
    }

    /*
     * EFFECTS: initializer calls methods to initialize labels  and buttons
     */
    private void initializer() {
        textInitializer();
        buttonInitializer();
        labelInitializer();

    }
    /*
     * EFFECTS:  initializes labels
     */

    private void labelInitializer() {
        addFoodLabel = new JLabel("Add food :");
        addFoodCalorieLabel = new JLabel("Add Food Calories :");
        addWorkoutLabel = new JLabel("Add Workout :");
        addWorkoutCalorieLabel = new JLabel("Add Workout Calories :");
        logo = new ImageIcon("./data/logonew.png");
        mylabel = new JLabel(logo);
        mylabel.setSize(10, 10);
    }
    /*
     * EFFECTS:  initializes button
     */

    private void buttonInitializer() {
        addFoodToLogs = new JButton("Add New Food to logs");
        addWorkoutToLogs = new JButton(" Add New Workout to Logs");
    }
    /*
     * EFFECTS:  initializes text
     */

    private void textInitializer() {
        workoutNameText = new JTextField(19);
        workoutCaloriesText = new JTextField(19);
        foodNameText = new JTextField(19);
        foodCaloriesText = new JTextField(19);
    }

    /*
     * EFFECTS: creates new panel for food information, to add users information in label and text field and then
     * add to panel with constraints.
     */
    private void foodInfoPanel() {
        JPanel panel6 = new JPanel(new GridBagLayout());

        panel6.setSize(1000, 100);
        GridBagConstraints a = new GridBagConstraints();
        a.insets = new Insets(10, 25, 10, 25);
        a.gridx = 0;
        a.gridy = 1;
        panel6.add(addFoodLabel, a);
        a.gridx = 2;
        a.gridy = 1;
        panel6.add(workoutNameText, a);
        a.gridx = 4;
        a.gridy = 1;
        panel6.add(addFoodCalorieLabel, a);
        a.gridx = 6;
        a.gridy = 1;
        panel6.add(workoutCaloriesText, a);
        a.gridx = 8;
        a.gridy = 1;
        panel6.add(addFoodToLogs, a);
        ActionListener action3 = addFoodToLogGui();
        addFoodToLogs.addActionListener(action3);
        logFrame.add(panel6);
    }
    /*
     * EFFECTS: creates new panel for workout information, to add users information in label and text field and then
     * add to panel with constraints.
     */

    private void workoutInfoPanel() {
        JPanel panel7 = new JPanel(new GridBagLayout());

        //panel7.setBackground(Color.lightGray);
        panel7.setSize(1000, 100);
        GridBagConstraints a = new GridBagConstraints();
        a.insets = new Insets(50, 19, 50, 19);
        a.gridx = 0;
        a.gridy = 1;
        panel7.add(addWorkoutLabel, a);
        a.gridx = 2;
        a.gridy = 1;
        panel7.add(foodNameText, a);
        a.gridx = 4;
        a.gridy = 1;
        panel7.add(addWorkoutCalorieLabel, a);
        a.gridx = 6;
        a.gridy = 1;
        panel7.add(foodCaloriesText, a);
        a.gridx = 8;
        a.gridy = 1;
        panel7.add(addWorkoutToLogs, a);
        ActionListener action4 = addWorkoutToLogGui();
        addWorkoutToLogs.addActionListener(action4);
        logFrame.add(panel7);
    }

    /*
     * EFFECTS: creates new action for food to logs button.
     */
    private ActionListener addFoodToLogGui() {
        ActionListener action3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String foodName = workoutNameText.getText();
                double calories = Double.parseDouble(workoutCaloriesText.getText());
                diary.calorieLeft = diary.calorieLeft - calories;
                diary.addFood(foodName, calories, diary.calorieLeft);
                workoutNameText.setText("");
                workoutCaloriesText.setText("");
            }
        };
        return action3;
    }
    /*
     * EFFECTS: creates new action for workout to logs button.
     */

    private ActionListener addWorkoutToLogGui() {
        ActionListener action4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String workoutName = foodNameText.getText();
                double calories = Double.parseDouble(foodCaloriesText.getText());
                diary.calorieLeft = diary.calorieLeft + calories;
                diary.addWorkout(workoutName, calories, diary.calorieLeft);
                foodNameText.setText("");
                foodCaloriesText.setText("");
            }
        };
        return action4;
    }
    /*
     * EFFECTS: creates new action for show logs button.
     */

    private ActionListener showTheLogs() {
        ActionListener showLogs = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CalorieDiaryGui();
                logFrame.setVisible(false);
            }
        };

        return showLogs;
    }

}
