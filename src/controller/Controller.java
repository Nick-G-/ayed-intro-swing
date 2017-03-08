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

    private OnSettingsChangeListener onSettingsChangeListener;
    private OnMusicTurnedOn onMusicTurnedOn;
    private OnMusicTurnedOff onMusicTurnedOff;
    private OnSoundTurnedOn onSoundTurnedOn;
    private OnSoundTurnedOff onSoundTurnedOff;
    private OnAntialiasingTurnedOn onAntialiasingTurnedOn;
    private OnAntialiasingTurnedOff onAntialiasingTurnedOff;
    private OnShadowsTurnedOn onShadowsTurnedOn;
    private OnShadowsTurnedOff onShadowsTurnedOff;

    private CardLayout cardLayout;

    public Controller() {

        settings = new SettingsModel();

        frame = new JFrame();

        goToMainMenuListener = new GoToMainMenuListener();
        goToSettingsListener = new GoToSettingsListener();
        goToGameListener = new GoToGameListener();
        exitListener = new ExitListener();

        onSettingsChangeListener = new OnSettingsChangeListener();

        onMusicTurnedOn = new OnMusicTurnedOn();
        onMusicTurnedOff = new OnMusicTurnedOff();
        onSoundTurnedOn = new OnSoundTurnedOn();
        onSoundTurnedOff = new OnSoundTurnedOff();
        onAntialiasingTurnedOn = new OnAntialiasingTurnedOn();
        onAntialiasingTurnedOff = new OnAntialiasingTurnedOff();
        onShadowsTurnedOn = new OnShadowsTurnedOn();
        onShadowsTurnedOff = new OnShadowsTurnedOff();


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

    class OnSettingsChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println(settings.toText());
        }
    }

    class OnMusicTurnedOn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settings.setMusicEnabled(true);
            System.out.println("Music was turned on");
        }
    }

    class OnMusicTurnedOff implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settings.setMusicEnabled(false);
            System.out.println("Music was turned off");
        }
    }

    class OnSoundTurnedOn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settings.setSoundEnabled(true);
            System.out.println("Sound was turned on");
        }
    }

    class OnSoundTurnedOff implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settings.setSoundEnabled(false);
            System.out.println("Sound was turned off");
        }
    }

    class OnShadowsTurnedOn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settings.setShadowsEnabled(true);
            System.out.println("Shadows were turned on");
        }
    }

    class OnShadowsTurnedOff implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settings.setShadowsEnabled(false);
            System.out.println("Shadows were turned off");
        }
    }

    class OnAntialiasingTurnedOn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settings.setAntialiasingEnabled(true);
            System.out.println("Antiliasing was turned on");
        }
    }

    class OnAntialiasingTurnedOff implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            settings.setAntialiasingEnabled(false);
            System.out.println("Antiliasing was turned off");
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

    public OnSettingsChangeListener getOnSettingsChangeListener() {
        return onSettingsChangeListener;
    }

    public OnMusicTurnedOn getOnMusicTurnedOn() {
        return onMusicTurnedOn;
    }

    public OnMusicTurnedOff getOnMusicTurnedOff() {
        return onMusicTurnedOff;
    }

    public OnSoundTurnedOn getOnSoundTurnedOn() {
        return onSoundTurnedOn;
    }

    public OnSoundTurnedOff getOnSoundTurnedOff() {
        return onSoundTurnedOff;
    }

    public OnAntialiasingTurnedOn getOnAntialiasingTurnedOn() {
        return onAntialiasingTurnedOn;
    }

    public OnAntialiasingTurnedOff getOnAntialiasingTurnedOff() {
        return onAntialiasingTurnedOff;
    }

    public OnShadowsTurnedOn getOnShadowsTurnedOn() {
        return onShadowsTurnedOn;
    }

    public OnShadowsTurnedOff getOnShadowsTurnedOff() {
        return onShadowsTurnedOff;
    }
}
