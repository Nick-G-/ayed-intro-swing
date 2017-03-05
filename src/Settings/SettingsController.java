package Settings;

import MainMenu.MainMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsController {
    private SettingsView view;
    private SettingsModel model;

    public SettingsController(SettingsView settingsView) {
        this.view = settingsView;
    }

    class OnChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println(model.toText());
        }
    }
}