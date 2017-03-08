package views;

import controller.Controller;

import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Lautaro Paskevicius (lautaro.paskevicius@ing.austral.edu.ar)
 * on 06/03/2017.
 */

public class GameView extends JPanel{


    private JLabel gameImage = new JLabel(new ImageIcon(Resources.class.getResource("/assets/game.png")));

    public GameView(Controller controller){
        setLayout(new BorderLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(controller.getGoToMainMenuListener());


        add(gameImage, BorderLayout.CENTER);
        add(backButton,BorderLayout.PAGE_END);

        //add back button

    }
}
