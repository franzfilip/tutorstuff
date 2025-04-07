public class Thermostat extends SmartDevice{
    protected double currentTemperature;

    public Thermostat(String deviceName, boolean isOn, double currentTemperature) {
        super(deviceName, isOn);
        this.currentTemperature = currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        if (currentTemperature < 0 || currentTemperature > 30 || !this.isOn) {
            System.out.println("Irgendwas ist falsch");
            this.currentTemperature = 22; // ca normale Raumtemperatur
        }else {
            this.currentTemperature = currentTemperature;
        }
    }


    @Override
    public void adjustSetting(String setting, int value) {
        if (value < 0 || value > 30) {
            System.out.println("Die Temperatur wird nicht verändert");
        }else {
            this.currentTemperature = value;
        }
    }

    @Override
    public String toString () {
        return super.toString() + " Temperatur: " + this.currentTemperature;
    }
}
