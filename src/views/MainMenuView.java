package views;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JPanel {

    public MainMenuView(Controller controller) {

        JLabel title = new JLabel("Trabajo Práctico Swing");
        JLabel subTitle = new JLabel("Lautaro Paskevicius y Nicolás Gargano");

        JPanel titles = new Titles(title,subTitle);

        JButton startGameButton = createButton("Start Game");
        startGameButton.addActionListener(controller.getGoToGameListener());
        JButton settingsButton = createButton("Settings");
        settingsButton.addActionListener(controller.getGoToSettingsListener());
        JButton exitButton = createButton("Exit");
        exitButton.addActionListener(controller.getExitListener());

        JPanel buttons = new ButtonsMenu(startGameButton,settingsButton,exitButton);

        setLayout(new GridLayout(0,1));

        add(titles);
        add(buttons);

    }

    JButton createButton(String buttonLabel) {
        JButton button = new JButton(buttonLabel);
        button.setPreferredSize(new Dimension(200, 50));
        return button;
    }

    private class Titles extends JPanel {
        public Titles(JLabel titles, JLabel subTitles) {
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

            add(titles);
            add(subTitles);

            setVisible(true);
        }
    }

    private class ButtonsMenu extends JPanel {

        public ButtonsMenu(JButton... buttons){
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

            for(JButton e : buttons){
                add(e);
            }

            setVisible(true);
        }
    }
}
