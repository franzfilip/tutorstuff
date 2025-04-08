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
        if (!isOn) {
            System.out.println("Das Gerät ist ausgeschalten");
            this.isOn = false;
        }else {
            System.out.println("Das Gerät ist eingeschalten");
            this.isOn = true;
        }
    }

    public int getDeviceId() {
        return this.deviceId;
    }

    @Override
    public String getDeviceName() {
        return this.deviceName;
    }

    public boolean isOn() {
        return this.isOn;
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

    @Override
    public boolean search (String term) {
        if (this.deviceName.contains(term)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo (Controllable other) {
        return other.getDeviceName().compareTo(this.getDeviceName());
    }
}
