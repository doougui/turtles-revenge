package me.doougui.turtlesrevenge;
public final class KillerSingleton {
    private static KillerSingleton instance;
    private String name;

    public static KillerSingleton getInstance() {
        if (instance == null) {
            instance = new KillerSingleton();
        }
        return instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
