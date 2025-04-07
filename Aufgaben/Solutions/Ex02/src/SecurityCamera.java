public class SecurityCamera extends SmartDevice{
    protected boolean recording;
    protected int resulution;

    public SecurityCamera(String deviceName, boolean isOn, boolean recording, int resulution) {
        super(deviceName, isOn);
        this.recording = recording;
        this.resulution = resulution;
    }

    public void setRecording(boolean recording) {
        if (!recording || !this.isOn) {
            System.out.println("Die Kamera nimmt nicht auf");
        }else {
            System.out.println("Die Kamera nimmt auf");
        }
    }

    public void setResulution(int resulution) {
        if (resulution < 720 || resulution > 1080) {
            System.out.println("Die Auflösung kann nicht null sein");
            this.resulution = 1080;
        }else {
            this.resulution = resulution;
        }
    }

    @Override
    public void adjustSetting(String setting, int value) {
        if (resulution < 720 || resulution > 1080) {
            System.out.println("Die Auflösung wird nicht verändert");
        }else {
            this.resulution = value;
        }
    }
    @Override
    public String toString () {
        return super.toString() + " Auflösung: " + this.resulution + " recording " + this.recording;
    }
}
