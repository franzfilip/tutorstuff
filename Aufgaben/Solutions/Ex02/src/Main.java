public class Main {
    public static void main(String[] args) {

        SmartDevice[] smartDevices = new SmartDevice[20];
        smartDevices[0] = new Light("LightLivingRoom", true, 60, "white");
        smartDevices[3] = new Thermostat("ThermostatLivingRoom", true, 22.3);
        smartDevices[5] = new SecurityCamera("CamGarage", true, true, 1080);
        smartDevices[8] = new Light("LightKitchen", true, 70, "white");
    }
}