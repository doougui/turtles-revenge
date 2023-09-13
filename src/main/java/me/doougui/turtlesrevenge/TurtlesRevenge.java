package me.doougui.turtlesrevenge;

import me.doougui.turtlesrevenge.listeners.EntityTargetListener;
import me.doougui.turtlesrevenge.listeners.SkeletonDeathListener;
import me.doougui.turtlesrevenge.listeners.TurtleDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TurtlesRevenge extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("The plugin has started!");

        getServer().getPluginManager().registerEvents(new TurtleDeathListener(), this);
        getServer().getPluginManager().registerEvents(new SkeletonDeathListener(), this);
        getServer().getPluginManager().registerEvents(new EntityTargetListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("The plugin has stopped!");
    }
}
