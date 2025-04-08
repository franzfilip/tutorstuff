public class Light extends SmartDevice{
    protected int brightness;
    protected String color;

    public Light(String deviceName, boolean isOn, int brightness, String color) {
        super(deviceName, isOn);
        setBrightness(brightness);
        setColor(color);
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100 || this.isOn == false) {
            System.out.println("Die Helligkeit kann nicht kleiner als null sein");
            this.brightness = 0;
        }else {
            this.brightness = brightness;
        }
    }

    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            System.out.println("Du musst eine Farbe angeben");
            this.color = "unknownColor";
        }else {
            this.color = color;
        }
    }

    @Override
    public void adjustSetting(String setting, int value) {
        if (brightness < 0 || brightness > 100) {
            System.out.println("Die Helligkeit wird nicht verändert");
        }else {
            this.brightness = value;
        }

        }

    @Override
    public String toString () {
        return super.toString() + " Helligkeit: " + this.brightness + " Farbe: " + this.color;
    }
}
