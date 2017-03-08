package views;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainMenuView extends JPanel {

    /*
        Construcs a JPanel with horizontally aligned and vertically spaced components, two labels and three buttons
        with their respective listeners.
    */
    public MainMenuView(Controller controller) {

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Trabajo Práctico Swing");
        titleLabel.setAlignmentX(0.5f);
        titleLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(titleLabel);

        JLabel subtitleLabel = new JLabel("Lautaro Paskevicius y Nicolás Gargano");
        subtitleLabel.setAlignmentX(0.5f);
        subtitleLabel.setBorder(new EmptyBorder(0, 10, 30, 10));
        add(subtitleLabel);

        JButton startGameButton = createButton("Start Game");
        startGameButton.addActionListener(controller.getGoToGameListener());
        startGameButton.setAlignmentX(0.5f);
        add(startGameButton);

        add(createMargin());

        JButton settingsButton = createButton("Settings");
        settingsButton.addActionListener(controller.getGoToSettingsListener());
        settingsButton.setAlignmentX(0.5f);
        add(settingsButton);

        add(createMargin());

        JButton exitButton = createButton("Exit");
        exitButton.addActionListener(controller.getExitListener());
        exitButton.setAlignmentX(0.5f);
        add(exitButton);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /*
        Creates a JButton with the provided label and a size of 200x30.
     */
    private JButton createButton(String buttonLabel) {
        JButton button = new JButton(buttonLabel);
        Dimension dimension = new Dimension(200,30);
        button.setPreferredSize(dimension);
        button.setMaximumSize(dimension);
        return button;
    }

    /*
        Creates a JLabel with invisible borders to be used as a vertical spacer.
    */
    private JLabel createMargin() {
        JLabel margin = new JLabel("");
        margin.setBorder(new EmptyBorder(10, 10, 10, 10));
        return margin;
    }
}
