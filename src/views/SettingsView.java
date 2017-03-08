package views;

import controller.Controller;
import model.SettingsModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SettingsView extends JPanel {

    private JLabel title = new JLabel("Settings \n");
    private JButton backButton = new JButton("Back");

    private SettingsModel model;
    private Controller controller;

    private JLabel graphicsLabel;
    private JCheckBox shadowsCheckbox;
    private JCheckBox antialiasingCheckbox;


    public SettingsView(Controller controller, SettingsModel settings) {

        this.model = new SettingsModel();

        setLayout(new GridLayout(5,1));

        add(title);
        add(createOnOffSettingContainer("Sound:", model.isSoundEnabled(), actionEvent -> System.out.println("Music On") , actionEvent -> System.out.println("Sound Off")));
        add(createOnOffSettingContainer("Music:", model.isMusicEnabled(), actionEvent -> System.out.println("Music On"), actionEvent -> System.out.println("Music Off")));
//        container.add(createCheckBoxSettings("Graphics:", "Shadows", "Antialiasing"));


        graphicsLabel = new JLabel("Graphics");
        shadowsCheckbox = new JCheckBox("Shadows", model.isShadowsEnabled());
        antialiasingCheckbox = new JCheckBox("Antialiasing", model.isAntialiasingEnabled());



        //add backbutton listener
        add(backButton);
        backButton.addActionListener(controller.getGoToMainMenuListener());

        setVisible(true);
    }


    // Creates a simple container with a label and two radio buttons: one for enabling and one for disabling
    JPanel createOnOffSettingContainer(String label, boolean isOn, ActionListener onActionListener, ActionListener offActionListener) {

        JPanel container = new JPanel();
        JLabel settingLabel = new JLabel(label);

        JRadioButton onButton = new JRadioButton("On");
        JRadioButton offButton = new JRadioButton("Off");

        if(isOn) {
            onButton.setSelected(true);
        } else {
            offButton.setSelected(true);
        }

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
