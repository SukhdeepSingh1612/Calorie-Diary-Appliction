package ui;

import exceptions.DataNotFilled;
import model.Diary;
import persistence.Reader;
import persistence.Writer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserInformation extends DiaryInitializer {
    Writer writer = new Writer("./data/Diary.json");        //Writer Object
    Reader reader = new Reader("./data/Diary.json");           //Reader Object
    JFrame userInformation = new JFrame("User Information");     //creates Jframe with title User Information.
    JTextField heightText;                                           //creates text field for height
    JTextField weightText;                                           //creates text field for weight
    JTextField ageText;                                              //creates text field for age
    JTextField nameText;                                             //creates text field for name
    JLabel heightLabel;                                              //creates label for height
    JLabel weightLabel;                                              //creates label for weight
    JLabel ageLabel;                                                 //creates label for age
    JLabel nameLabel;                                                //creates label for name
    JLabel bmiLabel;                                                 //creates label for BMI results
    JLabel dailyCaloriesLabel;                                       //creates label for daily calories requirement
    JButton getBmiButton;                                            //creates button to get BMI
    JButton getDailyCaloriesButton;                                  //creates button to get daily calorie requirement
    JButton enterDataButton;                                         //creates button to enter data
    JButton addToLogsButton;                                         //creates button to add to logs
    JButton saveButton;                                              //creates button to save the data
    ImageIcon logo;                                                  //creates image icon to store image logo
    ImageIcon logogif;                                               //creates image icon to store image logo gif
    JLabel mylabel;                                                  //creates label to store image logo
    boolean dataLoaded = false;                                      // creates boolean for data loaded ques.
    boolean choice = false;                                          // creates boolean for choice of constructor
    /*
     * MODIFIES: this
     * EFFECTS: calls initializer and other panels on to frame and sets frame default setting
     */

    public UserInformation() {

        try {
            diary = (Diary) reader.read();
            dataLoaded = true;
        } catch (IOException e) {
            System.out.println("Error in loading previous session");
        }
        if (dataLoaded) {
            initializer1();
        } else {
            initializer();
        }
        imagePanel();
        labelPanel();
        textFieldPanel();
        buttonPanel();
        resultPanel();
        Image icon = getImagegif();
        frameSettings(icon);
    }
    /*
     * EFFECTS: creates new panel for image, to add image in label and then add to panel with constraints.
     */

    private Image getImagegif() {
        File imageIcon = new File("./data/logogif.png");
        Image icon = null;
        try {
            icon = ImageIO.read(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icon;
    }
    /*
     * EFFECTS: sets frame default setting
     */

    private void frameSettings(Image icon) {
        userInformation.setIconImage(icon);
        userInformation.setLayout(new FlowLayout());
        userInformation.setVisible(true);
        userInformation.setSize(1000, 640);
        userInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*
     * MODIFIES: this
     * EFFECTS: calls initializer and other panels on to frame and sets frame default setting without reading data
     *  from Json
     */

    public UserInformation(boolean choice) {

        initializer1();
        imagePanel();
        labelPanel();
        textFieldPanel();
        buttonPanel();
        resultPanel();
        File imageIcon = new File("./data/logogif.png");
        this.choice = choice;
        Image icon = null;
        try {
            icon = ImageIO.read(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userInformation.setIconImage(icon);
        userInformation.setLayout(new FlowLayout());
        userInformation.setVisible(true);
        userInformation.setSize(1000, 640);
        userInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
     * EFFECTS: initializer1 calls different methods to initialize labels  and buttons
     */

    private void initializer1() {
        textInitializer1();
        buttonInitializer();
        labelInitializer();
    }
    /*
     * EFFECTS:  initializes button
     */

    private void buttonInitializer() {
        getBmiButton = new JButton("Get BMI");
        getDailyCaloriesButton = new JButton("Get Daily Calories");
        addToLogsButton = new JButton("Add to your Logs");
        saveButton = new JButton("Save Current Record");
        enterDataButton = new JButton("Re-enter Data To System");
    }

    /*
     * EFFECTS:  initializes labels
     */

    private void labelInitializer() {
        heightLabel = new JLabel("Height");
        weightLabel = new JLabel("Weight");
        ageLabel = new JLabel("Age");
        nameLabel = new JLabel("Name");
        bmiLabel = new JLabel("                BMI Result                ");
        dailyCaloriesLabel = new JLabel("               Daily Calories             ");
        logo = new ImageIcon("./data/logonew.png");
        logogif = new ImageIcon("./data/loggif.png");
        mylabel = new JLabel(logo);
        mylabel.setSize(10, 10);

    }
    /*
     * EFFECTS:  initializes text
     */

    private void textInitializer() {
        heightText = new JTextField(19);
        weightText = new JTextField(19);
        ageText = new JTextField(19);
        nameText = new JTextField(19);
    }
    /*
     * EFFECTS:  initializes text fields for user input
     * set onto panel with constraints
     */

    private void textInitializer1() {
        heightText = new JTextField(19);
        heightText.setText(String.valueOf(diary.getHeight()));
        weightText = new JTextField(19);
        weightText.setText(String.valueOf(diary.getWeight()));
        ageText = new JTextField(19);
        ageText.setText(String.valueOf(diary.getAge()));
        nameText = new JTextField(19);
        nameText.setText((diary.getName()));
    }
    /*
     * EFFECTS:  initializes labels for to tell user which text field is which.
     * set onto panel with constraints
     */

    private void labelPanel() {
        JPanel panel2 = new JPanel(new GridBagLayout());
        GridBagConstraints a = new GridBagConstraints();
        a.insets = new Insets(10, 100, 10, 100);
        a.gridx = 0;
        a.gridy = 1;
        panel2.add(heightLabel, a);
        a.gridx = 2;
        a.gridy = 1;
        panel2.add(weightLabel, a);
        a.gridx = 4;
        a.gridy = 1;
        panel2.add(ageLabel, a);
        a.gridx = 6;
        a.gridy = 1;
        panel2.add(nameLabel, a);
        userInformation.add(panel2);
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
        userInformation.add(panelimage);
    }
    /*
     * EFFECTS: creates new panel for text field, to add information for program to use.
     * set onto panel with constraints
     */

    private void textFieldPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints x = new GridBagConstraints();
        x.insets = new Insets(10, 10, 10, 10);
        x.gridx = 0;
        x.gridy = 4;
        panel.add(heightText, x);
        x.gridx = 2;
        x.gridy = 4;
        panel.add(weightText, x);
        x.gridx = 4;
        x.gridy = 4;
        panel.add(ageText, x);
        x.gridx = 6;
        x.gridy = 4;
        panel.add(nameText, x);
        userInformation.add(panel);
    }
    /*
     * EFFECTS: creates new panel for button, to get Bmi and daily calories from program.
     * set onto panel with constraints
     */

    private void buttonPanel() {
        JPanel panel3 = new JPanel(new GridBagLayout());
        buttonPanelGridLayout(panel3);

        userInformation.add(panel3);
    }
    /*
     * EFFECTS: does the same as buttonPanel() with more buttons and new constraints
     * set onto panel with constraints
     */

    private void buttonPanelGridLayout(JPanel panel3) {
        GridBagConstraints a = new GridBagConstraints();
        a.insets = new Insets(10, 80, 10, 80);
        a.gridx = 0;
        a.gridy = 6;
        panel3.add(getBmiButton, a);
        ActionListener action1 = bodyMassIndexGui();
        getBmiButton.addActionListener(action1);
        moreButtonPanelGridLayout(panel3, a);

    }
    /*
     * EFFECTS: does the same as buttonPanel() with even more buttons and new constraints
     * set onto panel with constraints
     */

    private void moreButtonPanelGridLayout(JPanel panel3, GridBagConstraints a) {
        a.gridx = 2;
        a.gridy = 6;
        panel3.add(getDailyCaloriesButton, a);
        ActionListener action2 = dailyCalorieGui();
        getDailyCaloriesButton.addActionListener(action2);
        a.gridx = 1;
        a.gridy = 10;
        panel3.add(addToLogsButton, a);
        ActionListener addLogs = addToLogs();
        addToLogsButton.addActionListener(addLogs);
        a.gridx = 2;
        a.gridy = 10;
        panel3.add(saveButton, a);
        ActionListener saveData = saveData();
        saveButton.addActionListener(saveData);
        a.gridx = 1;
        a.gridy = 6;
        ActionListener enterData = enterData();
        enterDataButton.addActionListener(enterData);
        panel3.add(enterDataButton, a);
    }

    /*
     * EFFECTS: creates new action for enter data button.
     */

    private ActionListener enterData() {
        ActionListener enterData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double height = Double.parseDouble(heightText.getText());
                    double weight = Double.parseDouble(weightText.getText());
                    int age = Integer.parseInt(ageText.getText());
                    String name = nameText.getText();

                    if (!dataLoaded) {
                        diary = new Diary(name, height, weight, age);
                    } else {
                        diary.setHeight(height);
                        diary.setWeight(weight);
                        diary.setAge(age);
                        diary.setName(name);
                    }
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(userInformation, "Enter Data in the Data Fields");
                }
            }
        };
        return enterData;
    }

    /*
     * EFFECTS: creates new action for save data button.
     */
    private ActionListener saveData() {
        ActionListener saveData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    writer.open();
                    writer.write(diary);
                    writer.close();
                } catch (FileNotFoundException f) {
                    System.out.println("File Not Found!");
                }
            }
        };
        return saveData;
    }

    /*
     * EFFECTS: creates new panel for result labels, to display Bmi and daily calories from program.
     * set onto panel with constraints
     */
    private void resultPanel() {
        JPanel panel4 = new JPanel(new GridBagLayout());

        panel4.setBackground(Color.lightGray);
        panel4.setSize(1000, 100);
        GridBagConstraints a = new GridBagConstraints();
        a.insets = new Insets(10, 150, 10, 150);
        a.gridx = 0;
        a.gridy = 1;
        panel4.add(bmiLabel, a);
        a.gridx = 2;
        a.gridy = 1;
        panel4.add(dailyCaloriesLabel, a);
        a.gridx = 4;
        a.gridy = 1;
        userInformation.add(panel4);
    }

    /*
     * EFFECTS: creates new action for BMI button.
     */

    private ActionListener bodyMassIndexGui() {
        ActionListener action1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double bodyMassIndex = 0;
                try {
                    bodyMassIndex = diary.getBodyMassIndex();
                    bmiLabel.setText(String.format("Your Body Mass Index Is : " + "%.2f", bodyMassIndex));
                } catch (NullPointerException | DataNotFilled a) {
                    JOptionPane.showMessageDialog(userInformation, "Make sure to enter the data in the system first");
                }

            }
        };
        return action1;
    }
    /*
     * EFFECTS: creates new action for daily calorie button.
     */

    private ActionListener dailyCalorieGui() {
        ActionListener action2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double dailyCalories = diary.getMaintenanceCalories();
                    dailyCaloriesLabel.setText(String.format("Your Daily Calories are : " + "%.2f", dailyCalories));
                } catch (NullPointerException | DataNotFilled a) {
                    JOptionPane.showMessageDialog(userInformation, "Make sure to enter the data in the system first");
                }
            }
        };
        return action2;
    }

    /*
     * EFFECTS: creates new action for add to logs button.
     */

    private ActionListener addToLogs() {
        ActionListener addToLog = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // new CalorieDiaryGui(localWeight);
                userInformation.setVisible(false);
                new AddToLogsGui();
            }
        };
        return addToLog;
    }

}
