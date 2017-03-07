package Settings;

import MainMenu.MainMenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;

public class SettingsView extends JFrame {

    private JLabel title = new JLabel("Settings \n");
    private JButton backButton = new JButton("Back");
    private Container container = this.getContentPane();

    public SettingsView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Settings");
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1));

        container.add(title);
        container.add(createOnOffSettingContainer("Sound:", actionEvent -> System.out.println("Sound On"), actionEvent -> System.out.println("Sound Off")));
        container.add(createOnOffSettingContainer("Music:", actionEvent -> System.out.println("Music On"), actionEvent -> System.out.println("Music Off")));
        container.add(createCheckBoxSettings("Graphics:", "Shadows", "Antialiasing"));

        backButton.addActionListener(
                actionEvent -> {    MainMenuView mainMenuView = new MainMenuView();
                                    this.dispose();
                }
        );
        container.add(backButton);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }


    // Creates a simple container with a label and two radio buttons: one for enabling and one for disabling
    JPanel createOnOffSettingContainer(String label, ActionListener onActionListener, ActionListener offActionListener) {

        JPanel container = new JPanel();
        JLabel settingLabel = new JLabel(label);

        JRadioButton onButton = new JRadioButton("On");
        JRadioButton offButton = new JRadioButton("Off");

        // Add listener to buttons
        onButton.addActionListener(onActionListener);
        offButton.addActionListener(offActionListener);
        // Radio group makes sure only one radio is selected
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(onButton);
        radioGroup.add(offButton);

        // Put in container
        container.add(settingLabel);
        container.add(onButton);
        container.add(offButton);

        setLayout(new FlowLayout(1));

        return container;
    }

    // Creates a simple container with a group label and however many label/checkbox pairs are desired
    JPanel createCheckBoxSettings(String label, String... checkboxesLabels) {

        JPanel container = new JPanel();
        JLabel settingLabel = new JLabel(label);
        JPanel checkboxesPanel = new JPanel();

        for (String checkboxLabel : checkboxesLabels) {
            JCheckBox checkbox = new JCheckBox(checkboxLabel);
            checkbox.addActionListener(actionEvent -> {
                if(checkbox.isSelected()) {
                    System.out.println(checkboxLabel + " On");
                }else{
                    System.out.println(checkboxLabel + " Off");
                }
            });
            checkboxesPanel.add(checkbox);
        }

        container.add(settingLabel);
        container.add(checkboxesPanel);

        setLayout(new FlowLayout(1));

        return container;
    }


}
