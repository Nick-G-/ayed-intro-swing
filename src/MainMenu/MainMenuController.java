package MainMenu;

import Settings.SettingsView;
import StartGame.StartGameView;

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
            System.out.println("Game Started");
            StartGameView openGame = new StartGameView();
            view.dispose();
        }
    }

    class SettingsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Settings clicked");
            SettingsView settingsView = new SettingsView();
            view.dispose();
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
