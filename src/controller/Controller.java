package controller;

import model.SettingsModel;
import views.GameView;
import views.MainMenuView;
import views.SettingsView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    /*
        A Controller is in charge of responding to user interaction and changing the model as necessary
    */
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
    private OnAntialiasingToggled onAntialiasingToggled;
    private OnShadowsToggled onShadowsToggled;

    private CardLayout cardLayout;

     /*
        Creates Controller and initializes its listeners and views within a JFrame
     */
    public Controller() {

        settings = new SettingsModel();

        frame = new JFrame();
        frame.setTitle("Main Menu");

        goToMainMenuListener = new GoToMainMenuListener();
        goToSettingsListener = new GoToSettingsListener();
        goToGameListener = new GoToGameListener();
        exitListener = new ExitListener();

        onSettingsChangeListener = new OnSettingsChangeListener();

        onMusicTurnedOn = new OnMusicTurnedOn();
        onMusicTurnedOff = new OnMusicTurnedOff();
        onSoundTurnedOn = new OnSoundTurnedOn();
        onSoundTurnedOff = new OnSoundTurnedOff();
        onAntialiasingToggled = new OnAntialiasingToggled();
        onShadowsToggled = new OnShadowsToggled();

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
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /*
        The following are the classes describing various listeners for screen transitions
     */
    class GoToMainMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.setTitle("Main Menu");
            cardLayout.show(cardsPanel, "mainMenu");
            System.out.println("Going to main menu...");
        }
    }

    class GoToGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.setTitle("Game");
            cardLayout.show(cardsPanel, "game");
            System.out.println("Going to game...");
        }
    }

    class GoToSettingsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.setTitle("Settings");
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

    /*
        The following are the classes describing various listeners for settings' changes
    */

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

    class OnShadowsToggled implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(settings.isShadowsEnabled()) {
                settings.setShadowsEnabled(false);
                System.out.println("Shadows were turned off");
            }
            else {
                settings.setShadowsEnabled(true);
                System.out.println("Shadows were turned on");
            }
        }
    }

    class OnAntialiasingToggled implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(settings.isAntialiasingEnabled()) {
                settings.setAntialiasingEnabled(false);
                System.out.println("Antialiasing was turned off");
            }
            else {
                settings.setAntialiasingEnabled(true);
                System.out.println("Antialiasing was turned on");
            }
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

    /*
        The following are the getters for the listeners
     */
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

    public OnAntialiasingToggled getOnAntialiasingToggled() {
        return onAntialiasingToggled;
    }

    public OnShadowsToggled getOnShadowsToggled() {
        return onShadowsToggled;
    }
}
