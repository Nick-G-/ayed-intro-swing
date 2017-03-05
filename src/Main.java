import MainMenu.MainMenuController;
import MainMenu.MainMenuView;
import Settings.SettingsView;

public class Main {

    public static void main(String[] args) {
        MainMenuView mainMenuView = new MainMenuView();
        MainMenuController mainMenuController = new MainMenuController(mainMenuView);

        SettingsView settingsView = new SettingsView();

        mainMenuView.setVisible(true);
//        settingsView.setVisible(true);
    }
}
