package me.doougui.turtlesrevenge.listeners;

import me.doougui.turtlesrevenge.KillerSingleton;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.Objects;

public class EntityTargetListener implements Listener {
    @EventHandler
    public void onEntityTarget(EntityTargetEvent e) {
        if (!e.getEntity().getName().equals("Turtle Guardian")) return;

        e.setCancelled(true);

        boolean isPlayer = e.getTarget() instanceof Player;

        if (!isPlayer) return;

        KillerSingleton singleton = KillerSingleton.getInstance();

        boolean isKiller = ((Player) e.getTarget()).getDisplayName().equals(singleton.getName());

        if (isKiller) e.setCancelled(false);
    }
}
