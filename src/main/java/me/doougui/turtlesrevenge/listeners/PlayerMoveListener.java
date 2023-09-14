package me.doougui.turtlesrevenge.listeners;

import me.doougui.turtlesrevenge.KillerSingleton;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;
import java.util.Objects;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        KillerSingleton singleton = KillerSingleton.getInstance();

        if (!Objects.equals(singleton.getName(), e.getPlayer().getName())) return;

        List<Entity> entities = e.getPlayer().getNearbyEntities(50, 50, 50);

        for (Entity entity : entities) {
            if (!entity.getName().equals("Turtle Guardian")) continue;

            if (entity.getLocation().getBlock().getType() == Material.WATER) {
                Location playerLocation = e.getPlayer().getLocation();
                entity.teleport(
                        new Location(
                                e.getPlayer().getWorld(),
                                playerLocation.getX() + 2,
                                playerLocation.getY(),
                                playerLocation.getZ()
                        )
                );
            }

            break;
        }
    }
}
