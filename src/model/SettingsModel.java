package model;

public class SettingsModel {
    private boolean soundEnabled;
    private boolean musicEnabled;
    private boolean shadowsEnabled;
    private boolean antialiasingEnabled;

    public SettingsModel(boolean soundEnabled, boolean musicEnabled, boolean shadowsEnabled, boolean antialiasingEnabled) {
        this.soundEnabled = soundEnabled;
        this.musicEnabled = musicEnabled;
        this.shadowsEnabled = shadowsEnabled;
        this.antialiasingEnabled = antialiasingEnabled;
    }

    public SettingsModel() {
        this(true, true, true, true);
    }

    public String toText() {
        return  "\n------------------- \n" +
                "Current Settings \n" +
                "------------------- \n" +
                "Sound:\t\t\t" + (soundEnabled ? "On":"Off") + "\n" +
                "Music:\t\t\t" + (musicEnabled ? "On":"Off") + "\n" +
                "Shadows:\t\t" + (shadowsEnabled ? "On":"Off") + "\n" +
                "Antialiasing:\t" + (antialiasingEnabled ? "On":"Off") + "\n" +
                "------------------- \n";
    }

    /*public model.SettingsModel saveView(views.SettingsView views.SettingsView){
        //TODO

    }*/

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }

    public boolean isMusicEnabled() {
        return musicEnabled;
    }

    public void setMusicEnabled(boolean musicEnabled) {
        this.musicEnabled = musicEnabled;
    }

    public boolean isShadowsEnabled() {
        return shadowsEnabled;
    }

    public void setShadowsEnabled(boolean shadowsEnabled) {
        this.shadowsEnabled = shadowsEnabled;
    }

    public boolean isAntialiasingEnabled() {
        return antialiasingEnabled;
    }

    public void setAntialiasingEnabled(boolean antialiasingEnabled) {
        this.antialiasingEnabled = antialiasingEnabled;
    }

}
