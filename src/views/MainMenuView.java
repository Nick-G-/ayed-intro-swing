package views;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JPanel {

    public MainMenuView(Controller controller) {

        setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("Trabajo Práctico Swing");
        add(titleLabel);

        JLabel subtitleLabel = new JLabel("Lautaro Paskevicius y Nicolás Gargano");
        add(subtitleLabel);

        JButton startGameButton = createButton("Start Game");
        startGameButton.addActionListener(controller.getGoToGameListener());
        add(startGameButton);

        JButton settingsButton = createButton("Settings");
        settingsButton.addActionListener(controller.getGoToSettingsListener());
        add(settingsButton);

        JButton exitButton = createButton("Exit");
        exitButton.addActionListener(controller.getExitListener());
        add(exitButton);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    JButton createButton(String buttonLabel) {
        JButton button = new JButton(buttonLabel);
        button.setPreferredSize(new Dimension(200, 50));
        return button;
    }
}
