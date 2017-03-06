package StartGame;

import MainMenu.MainMenuView;

import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Lautaro Paskevicius (lautaro.paskevicius@ing.austral.edu.ar)
 * on 06/03/2017.
 */

public class StartGameView extends JFrame{

    JButton backButton = new JButton("Back");
    JLabel gameImage = new JLabel(new ImageIcon(Resources.class.getResource("/images/game.png")));

    public StartGameView(){
        setLayout(new BorderLayout());

        add(gameImage, BorderLayout.CENTER);
        add(backButton,BorderLayout.PAGE_END);

        backButton.addActionListener(actionListener -> {
            this.dispose();
            MainMenuView backToMenu = new MainMenuView();
            backToMenu.setVisible(true);
        });

        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
