package views;

import controller.Controller;

import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel{


    /*
        Creates a view with a picture of the game and a button that directs to the main menu
     */
    public GameView(Controller controller){
        setLayout(new BorderLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(controller.getGoToMainMenuListener());

        JLabel gameImage = new JLabel(new ImageIcon(Resources.class.getResource("/assets/game.png")));
        add(gameImage, BorderLayout.CENTER);
        add(backButton,BorderLayout.PAGE_END);

    }
}
