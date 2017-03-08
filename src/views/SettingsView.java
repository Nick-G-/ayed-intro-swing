package views;

import controller.Controller;
import model.SettingsModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SettingsView extends JPanel {

    private JButton backButton = new JButton("Back");

    private SettingsModel model;
    private Controller controller;

    private JLabel graphicsLabel;
    private JLabel audioLabel;

    /*
        Constructs a JPanel with settings for audio and video options
     */
    public SettingsView(Controller controller, SettingsModel settings) {

        this.model = new SettingsModel();
        this.controller = controller;

        setLayout(new GridLayout(0, 1));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        audioLabel = new JLabel("Audio settings");
        audioLabel.setAlignmentX(0.5f);
        add(audioLabel);

        add(createOnOffSettingContainer(
                "Sound:",
                model.isSoundEnabled(),
                controller.getOnSoundTurnedOn(),
                controller.getOnSoundTurnedOff()));

        add(createOnOffSettingContainer("Music:",
                model.isMusicEnabled(),
                controller.getOnMusicTurnedOn(),
                controller.getOnMusicTurnedOff()));

        graphicsLabel = new JLabel("Graphics settings");
        graphicsLabel.setAlignmentX(0.5f);
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

        backButton.addActionListener(controller.getGoToMainMenuListener());
        add(backButton);

        setVisible(true);
    }


    /*
        Creates a simple container with a label and two radio buttons: one for enabling and one for disabling.
        The provided boolean determines which one should start selected.
        Each button receives its corresponding listener
     */
    JPanel createOnOffSettingContainer(String label, boolean isOn, ActionListener onActionListener, ActionListener offActionListener) {

        JPanel container = new JPanel();
        JLabel settingLabel = new JLabel(label);
        settingLabel.setAlignmentX(0);

        container.setLayout(new FlowLayout(1));

        JRadioButton onButton = new JRadioButton("On");
        JRadioButton offButton = new JRadioButton("Off");

        // Decide which one starts selected
        if (isOn) { onButton.setSelected(true);}
        else {offButton.setSelected(true);}

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

    /*
        Creates a simple JCheckBox with the provided label, value and toggle listener.
     */
    JCheckBox createCheckBoxSetting(String label, boolean isOn, ActionListener onToggle) {

        JCheckBox checkBox = new JCheckBox(label, isOn);

        checkBox.addActionListener(controller.getOnSettingsChangeListener());
        checkBox.addActionListener(onToggle);

        return checkBox;
    }
}
