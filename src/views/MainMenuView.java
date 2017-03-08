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

        //setLayout(new GridLayout(0,1));
        setLayout(new BorderLayout(10,0));

        add(titles,BorderLayout.NORTH);
        add(buttons,BorderLayout.CENTER);

    }

    JButton createButton(String buttonLabel) {
        JButton button = new JButton(buttonLabel);
        button.setPreferredSize(new Dimension(200, 50));
        return button;
    }

    private class Titles extends JPanel {
        public Titles(JLabel titles, JLabel subTitles) {
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

            add(titles,JPanel.CENTER_ALIGNMENT);
            add(subTitles, JPanel.CENTER_ALIGNMENT);

            setVisible(true);
        }
    }

    private class ButtonsMenu extends JPanel {

        public ButtonsMenu(JButton... buttons){
            setLayout(new GridLayout(0,1));

            for(JButton e : buttons){
                add(e);
            }

            setVisible(true);
        }
    }
}
