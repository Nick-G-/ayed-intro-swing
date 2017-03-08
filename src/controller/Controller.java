package controller;

import model.SettingsModel;
import views.GameView;
import views.MainMenuView;
import views.SettingsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private SettingsModel settings;

    private JFrame frame;
    private JPanel cardsPanel;

    private JPanel mainMenuView;
    private JPanel gameView;
    private JPanel settingsView;

    private GoToMainMenuListener goToMainMenuListener;
    private GoToSettingsListener goToSettingsListener;
    private GoToGameListener goToGameListener;
    private ExitListener exitListener;

    private OnChangePrint onSettingsChangeListener;
    private ShadowToggleListener shadowToggleListener;

    private CardLayout cardLayout;

    public Controller() {


        goToMainMenuListener = new GoToMainMenuListener();
        goToSettingsListener = new GoToSettingsListener();
        goToGameListener = new GoToGameListener();
        exitListener = new ExitListener();

        settings = new SettingsModel();
        frame = new JFrame();

        settingsView = new SettingsView(this, settings);
        mainMenuView = new MainMenuView(this);
        gameView = new GameView(this);

        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        cardsPanel.add(mainMenuView, "mainMenu");
        cardsPanel.add(settingsView, "settings");
        cardsPanel.add(gameView, "game");

        frame.getContentPane().add(cardsPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void initialize() {
    }

    class GoToMainMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            cardLayout.show(cardsPanel, "mainMenu");
            System.out.println("Going to main menu...");
        }
    }

    class GoToGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            cardLayout.show(cardsPanel, "game");
            System.out.println("Going to game...");
        }
    }

    class GoToSettingsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            cardLayout.show(cardsPanel, "settings");
            System.out.println("Going to settings...");
        }
    }

    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    class OnChangePrint implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            actionEvent.getActionCommand();
            System.out.println(settings.toText());
        }
    }

    class ShadowToggleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(settings.isShadowsEnabled());
        }
    }

    public GoToMainMenuListener getGoToMainMenuListener() {

        return goToMainMenuListener;
    }

    public GoToSettingsListener getGoToSettingsListener() {

        return goToSettingsListener;
    }

    public GoToGameListener getGoToGameListener() {

        return goToGameListener;
    }

    public ExitListener getExitListener() {
        return exitListener;
    }

    public OnChangePrint getOnSettingsChangeListener() {
        return onSettingsChangeListener;
    }

    public ShadowToggleListener getShadowToggleListener() {
        return shadowToggleListener;
    }
}
