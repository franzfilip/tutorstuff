public class HomeAutomationManager{
    private Controllable[] devices = new Controllable[20];
    private int addIndex;

    public void addDevice (Controllable controllable) {
        boolean isAdded = false;
            if (controllable != null && !isAdded && devices[devices.length-1] == null) {
                this.devices[this.addIndex] = controllable;
                isAdded = true;
                addIndex++;
            }
    }

    public void printDevices () {
        for (int i = 0; i < this.devices.length; i++) {
            if (this.devices[i] != null) {
                System.out.println(this.devices[i].toString());
            }
        }
    }

    public void searchDevice () {
        String term = "Light";
        for (int i = 0; i < this.devices.length; i++) {
            if (this.devices[i] != null && this.devices[i].search(term)) {
                System.out.println(this.devices[i].toString());
            }
        }
    }

    public Controllable[] sortArr () {
        Controllable[] light = new Controllable[20];
        Controllable[] camera = new Controllable[20];
        Controllable[] thermostat = new Controllable[20];

        //gruppieren
        groop(light,camera,thermostat);

        //Gruppe Sortieren
        sortGroop(light);
        sortGroop(camera);
        sortGroop(thermostat);

        //in ein großes Arr sortieren
        Controllable[] result = new Controllable[20];
        fillArr(result, light);
        fillArr(result, thermostat);
        fillArr(result, camera);

        return result;
    }

    public void groop (Controllable[] light, Controllable[] camera, Controllable[] thermo) {
        int lightIndex = 0;
        int camIndex = 0;
        int thermoIndex = 0;

        for (int i = 0; i < this.devices.length; i++) {
            if (this.devices[i] instanceof Light && this.devices[i] != null) {
                light[lightIndex] = devices[i];
                lightIndex++;
            }
            if (this.devices[i] instanceof SecurityCamera && this.devices[i] != null) {
                camera[camIndex] = devices[i];
                camIndex++;
            }
            if (this.devices[i] instanceof Thermostat && this.devices[i] != null) {
                thermo[thermoIndex] = devices[i];
                thermoIndex++;
            }
        }
    }
    public void sortGroop (Controllable[] groop) {
        for (int i = 0; i < groop.length; i++) {
            for (int j = 0; j < groop.length - 1; j++) {
                if (groop[j] != null && groop[j+1] != null) {
                    if (groop[j].compareTo(groop[j + 1]) < 1) {
                        Controllable temp = groop[j];
                        groop[j] = groop[j + 1];
                        groop[j + 1] = temp;
                    }
                }
            }
        }
    }
    public void fillArr (Controllable[] result,Controllable[] groop) {
        for (int i = 0; i < result.length; i++) {
            result[getNextIndex(result)] = groop[i];
        }
    }

    public int getNextIndex (Controllable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return i;
            }
        }
        return 0;
    }

    public void allOn () {
        for (int i = 0; i < this.devices.length; i++) {
            if (this.devices[i] != null) {
                this.devices[i].turnOn();
            }
        }
        System.out.println("Status Check");
        printDevices();
    }

    public void allOf () {
        for (int i = 0; i < this.devices.length; i++) {
            if (this.devices[i] != null) {
                this.devices[i].turnOf();
            }
        }
        System.out.println("Status Check");
        printDevices();
    }

    public void setting (Controllable controllable, String setting, int value) {
        controllable.adjustSetting(setting, value);
        System.out.println(controllable.toString());
    }
}
