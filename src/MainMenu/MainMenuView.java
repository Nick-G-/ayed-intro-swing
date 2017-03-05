package MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {

    private JLabel titleLabel = new JLabel("Trabajo Práctico Swing");

    private JLabel subtitleLabel = new JLabel("Lautaro Paskevicius y Nicolás Gargano");
    private JButton startGameButton = createButton("Start Game");
    private JButton settingsButton = createButton("Settings");
    private JButton exitButton = createButton("Exit");
    private Container container = this.getContentPane();

    public MainMenuView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        addComponentToContainer(titleLabel);
        addComponentToContainer(subtitleLabel);
        addComponentToContainer(startGameButton);
        addComponentToContainer(settingsButton);
        addComponentToContainer(exitButton);

        pack();
        setLocationRelativeTo(null);
    }

    void addComponentToContainer(JComponent component) {
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(component);
    }

    JButton createButton(String buttonLabel) {
        JButton button = new JButton(buttonLabel);
        button.setPreferredSize(new Dimension(1000, 50));
        return button;
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
