public interface Controllable {
    public abstract String getDeviceName();
    public abstract int compareTo(Controllable other);
    public abstract boolean search(String term);
    public abstract void turnOn();
    public abstract void turnOf();
    public abstract void adjustSetting(String setting, int value);
}
