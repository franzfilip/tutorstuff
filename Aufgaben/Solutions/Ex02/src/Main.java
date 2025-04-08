public class Main {
    public static void main (String[] args) {

        HomeAutomationManager manager = new HomeAutomationManager();

        Controllable light1 = new Light("LightLivingRoom", true, 60, "white");
        Controllable thermostat1 = new Thermostat("ThermostatLivingRoom", true, 22.3);
        Controllable camera1 = new SecurityCamera("CamGarage", true, true, 1080);
        Controllable light2 = new Light("LightKitchen", true, 70, "white");
        Controllable thermostat2 = new Thermostat("ThermostatNursery", true, 30);
        Controllable camera2 = new SecurityCamera("CamNursery", true, true, 720);
        Controllable camera3 = new SecurityCamera("CamGarden", true, false, 1080);
        Controllable light3 = new Light("LightPool", true, 100, "red");

        // Die Daten der Verarbeitungs Klasse geben
        manager.addDevice(light1);
        manager.addDevice(light2);
        manager.addDevice(light3);
        manager.addDevice(thermostat1);
        manager.addDevice(thermostat2);
        manager.addDevice(camera1);
        manager.addDevice(camera2);
        manager.addDevice(camera3);

        //unsortierte Ausgabe
        System.out.println("Unsortierte Ausgabe");
        manager.printDevices();

        // sortierte Ausgabe
        System.out.println("Sortierte Ausgabe");
        Controllable[] result = manager.sortArr();
        printArr(result);

        System.out.println("Suche");
        manager.searchDevice();

        //Steuerung simulieren
        System.out.println("Steuerung simulieren");

        System.out.println("Alles ein");
        manager.allOn();

        System.out.println("Alles aus");
        manager.allOf();

        System.out.println("Einstellungen ändern");
        manager.setting(light1, "brigthness", 100);

    }
    public static void printArr (Controllable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i].toString());
            }
        }
    }
}