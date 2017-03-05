package Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SettingsView extends JFrame {

    private JLabel title = new JLabel("Settings");

    private JPanel soundSettingContainer = createOnOffSettingContainer("Sound:");
    private JPanel musicSettingContainer = createOnOffSettingContainer("Music:");
    private JPanel graphicsSettingsContainer = createCheckBoxSettings("Graphics:", "Shadows", "Antialiasing");
    private JButton backButton = new JButton("Back");

    private Container container = this.getContentPane();

    public SettingsView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Settings");
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        container.add(createOnOffSettingContainer("Sound:"));
        container.add(createOnOffSettingContainer("Music:"));
        container.add(createCheckBoxSettings("Graphics:", "Shadows", "Antialiasing"));
        container.add(backButton);
    }


    // Creates a simple container with a label and two radio buttons: one for enabling and one for disabling
    JPanel createOnOffSettingContainer(String label) {

        JPanel container = new JPanel();
        JLabel settingLabel = new JLabel(label);

        JRadioButton onButton = new JRadioButton("On");
        JRadioButton offButton = new JRadioButton("Off");

        // Add listener to buttons
        onButton.addActionListener(actionEvent -> {
            System.out.println("Settings changed");
        });
        offButton.addActionListener(actionEvent -> {
            System.out.println("Settings changed");
        });

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
                System.out.println("Setting changed");
            });
            checkboxesPanel.add(checkbox);
        }

        container.add(settingLabel);
        container.add(checkboxesPanel);

        setLayout(new FlowLayout(1));

        return container;
    }


}
