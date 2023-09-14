package me.doougui.turtlesrevenge;

import me.doougui.turtlesrevenge.listeners.EntityTargetListener;
import me.doougui.turtlesrevenge.listeners.PlayerMoveListener;
import me.doougui.turtlesrevenge.listeners.SkeletonDeathListener;
import me.doougui.turtlesrevenge.listeners.TurtleDeathListener;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class TurtlesRevenge extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("The plugin has started!");

        getServer().getPluginManager().registerEvents(new TurtleDeathListener(), this);
        getServer().getPluginManager().registerEvents(new SkeletonDeathListener(), this);
        getServer().getPluginManager().registerEvents(new EntityTargetListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("The plugin has stopped!");
    }
}
