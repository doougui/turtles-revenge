package me.doougui.turtlesrevenge.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Objects;

public class SkeletonDeathListener implements Listener {
    @EventHandler
    public void onSkeletonDeath(EntityDeathEvent e) {
        if (e.getEntityType() != EntityType.SKELETON) return;

        if (e.getEntity().getName().equals("Turtle Guardian")) {
            e.getDrops().clear();
            e.setDroppedExp(0);
        }
    }
}
