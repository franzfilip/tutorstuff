public abstract class SmartDevice implements Controllable{
    protected int deviceId;
    protected String deviceName;
    protected boolean isOn;

    public SmartDevice(String deviceName, boolean isOn) {
        setDeviceId();
        setDeviceName(deviceName);
        setOn(isOn);
    }

    public void setDeviceId() {
        this.deviceId = (int) (Math.random() * (10000 - 100 + 1) + 100 );
    }

    public void setDeviceName(String deviceName) {
        if (deviceName == null || deviceName.isBlank()) {
            System.out.println("Der Name darf nicht leer sein");
            this.deviceName = "unknownDevice";
        }else {
            this.deviceName = deviceName;
        }
    }

    public void setOn(boolean isOn) {
        if (isOn) {
            System.out.println("Das Gerät ist eingeschalten");
        }else {
            System.out.println("Das Gerät is ausgeschalten");
        }
    }

    // Bearbeitungs Methoden
    @Override
    public void turnOn () {
        this.isOn = true;
        System.out.println("Gerät eingeschaltet");
    }

    @Override
    public void turnOf () {
        this.isOn = false;
        System.out.println("Gerät ausgeschaltet");
    }

    public String toString () {
        return "Gerät Id: " + this.deviceId + " Gerät Name: " + this.deviceName + " An/Aus: " + this.isOn;
    }
}
