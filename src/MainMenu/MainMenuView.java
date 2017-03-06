package MainMenu;

import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {

    private JLabel titleLabel = new JLabel("Trabajo Práctico Swing");
    private JLabel subtitleLabel = new JLabel("Lautaro Paskevicius y Nicolás Gargano");
    private JPanel titlesLabel = new Titles(new GridLayout(2,1),titleLabel,subtitleLabel);
    private JButton startGameButton = createButton("Start Game");
    private JButton settingsButton = createButton("Settings");
    private JButton exitButton = createButton("Exit");
    private final JPanel MenuButtons = new MenuButtons(startGameButton,settingsButton,exitButton);

    public MainMenuView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setLayout(new BorderLayout());

        add(titlesLabel,BorderLayout.NORTH);
        add(MenuButtons,BorderLayout.CENTER);

        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    JButton createButton(String buttonLabel) {
        JButton button = new JButton(buttonLabel);
        button.setPreferredSize(new Dimension(200, 50));
        return button;
    }

    class Titles extends JPanel{
        public Titles(LayoutManager layoutManager, JLabel titleLabel, JLabel subtitleLabel){
            super(layoutManager);
            add(titleLabel);
            add(subtitleLabel);
        }
    }

    class MenuButtons extends JPanel{

        public MenuButtons(JButton startGameButton, JButton settingsButton, JButton exitButton){
            this.setLayout(new GridLayout(3,1));
            this.add(startGameButton);
            this.add(settingsButton);
            this.add(exitButton);
        }
    }

    void addStartGamelistener(ActionListener listenForStartGameButton) {
        startGameButton.addActionListener(listenForStartGameButton);
    }

    void addSettingsListener(ActionListener listenForSettingsButton) {
        settingsButton.addActionListener(listenForSettingsButton);
    }

    void addExitListener(ActionListener listenForExitButton) {
        exitButton.addActionListener(listenForExitButton);
    }
}
