package Settings;

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

    String toText() {
        return "Sound: " + (soundEnabled ? "On":"Off") +
                "Music: " + (musicEnabled ? "On":"Off") +
                "Shadows: " + (shadowsEnabled ? "On":"Off") +
                "Antialiasing: " + (antialiasingEnabled ? "On":"Off");
    }

    /*public SettingsModel saveView(SettingsView settingsView){
        //TODO

    }*/
}
