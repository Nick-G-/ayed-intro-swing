package MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
    private MainMenuView view;

    public MainMenuController(MainMenuView mainMenuView) {
        this.view = mainMenuView;

        view.addStartGamelistener(new StartGameListener());
        view.addSettingsListener(new SettingsListener());
        view.addExitListener(new ExitListener());
    }

    class StartGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Start clicked");
        }
    }

    class SettingsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Settings clicked");
        }
    }

    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
}
