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
        this.controller = controller;

        setLayout(new GridLayout(0, 1));

        add(title);
        add(createOnOffSettingContainer(
                "Sound:",
                model.isSoundEnabled(),
                controller.getOnSoundTurnedOn(),
                controller.getOnSoundTurnedOff()));

        add(createOnOffSettingContainer("Music:",
                model.isMusicEnabled(),
                controller.getOnMusicTurnedOn(),
                controller.getOnMusicTurnedOff()));

        graphicsLabel = new JLabel("Graphics");
        add(graphicsLabel);

        JPanel checkBoxes = new JPanel(new FlowLayout(1));

        checkBoxes.add(createCheckBoxSetting(
                "Shadows",
                model.isShadowsEnabled(),
                controller.getOnShadowsToggled()));

        checkBoxes.add(createCheckBoxSetting(
                "Antialiasing",
                model.isShadowsEnabled(),
                controller.getOnAntialiasingToggled()));

        add(checkBoxes);

        //add backbutton listener
        backButton.addActionListener(controller.getGoToMainMenuListener());
        add(backButton);

        setVisible(true);
    }


    // Creates a simple container with a label and two radio buttons: one for enabling and one for disabling
    JPanel createOnOffSettingContainer(String label, boolean isOn, ActionListener onActionListener, ActionListener offActionListener) {

        JPanel container = new JPanel();
        JLabel settingLabel = new JLabel(label);

        container.setLayout(new FlowLayout(1));

        JRadioButton onButton = new JRadioButton("On");
        JRadioButton offButton = new JRadioButton("Off");

        if (isOn) {
            onButton.setSelected(true);
        } else {
            offButton.setSelected(true);
        }

        // Add listeners to buttons
        onButton.addActionListener(controller.getOnSettingsChangeListener());
        onButton.addActionListener(onActionListener);

        offButton.addActionListener(controller.getOnSettingsChangeListener());
        offButton.addActionListener(offActionListener);


        // Radio group makes sure only one radio is selected
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(onButton);
        radioGroup.add(offButton);

        // Put in container
        container.add(settingLabel);
        container.add(onButton);
        container.add(offButton);

        return container;
    }

    // Creates a simple container with a group label and however many label/checkbox pairs are desired
    JCheckBox createCheckBoxSetting(String label, boolean isOn, ActionListener onToggle) {

        JCheckBox checkBox = new JCheckBox(label, isOn);

        checkBox.addActionListener(controller.getOnSettingsChangeListener());
        checkBox.addActionListener(onToggle);



        return checkBox;
    }


}
