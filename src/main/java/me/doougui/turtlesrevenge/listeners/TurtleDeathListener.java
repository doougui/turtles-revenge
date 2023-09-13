package me.doougui.turtlesrevenge.listeners;

import me.doougui.turtlesrevenge.KillerSingleton;
import me.doougui.turtlesrevenge.TurtlesRevenge;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class TurtleDeathListener implements Listener {
    Plugin plugin = TurtlesRevenge.getPlugin(TurtlesRevenge.class);

    @EventHandler
    public void onTurtleDeath(EntityDeathEvent e) {
        if (e.getEntityType() != EntityType.TURTLE) return;

        Player killer = e.getEntity().getKiller();

        if (killer == null) return;

        String player = killer.getDisplayName();

        KillerSingleton singleton = KillerSingleton.getInstance();
        singleton.setName(killer.getDisplayName());

        if (!player.equals(singleton.getName())) return;

        plugin.getServer().broadcastMessage(ChatColor.GREEN + "[Turtle Guardian]" +  ChatColor.YELLOW + " Você foi avisado...");
        plugin.getServer().broadcastMessage(ChatColor.GREEN + "[Turtle Guardian]" +  ChatColor.RED + " Nunca mexa com uma tartaruga.");
        Location turtleLocation =  e.getEntity().getLocation();
        World world = turtleLocation.getWorld();

        if (world == null) return;

        world.strikeLightningEffect(killer.getLocation());

        Skeleton skeleton = world.spawn(turtleLocation, Skeleton.class);

        world.setStorm(true);
        world.setThundering(true);

        if (skeleton.getEquipment() != null) {
            skeleton.getEquipment().clear();
        }

        skeleton.setRemoveWhenFarAway(false);

        ItemStack bow = new ItemStack(Material.BOW);

        bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
        bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 20);
        bow.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

        skeleton.getEquipment().setItemInMainHand(bow);

        ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
        helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 15);
        helmet.addUnsafeEnchantment(Enchantment.THORNS, 10);

        ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 15);
        chestplate.addUnsafeEnchantment(Enchantment.THORNS, 10);

        ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
        leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 15);
        leggings.addUnsafeEnchantment(Enchantment.THORNS, 10);

        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
        boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        boots.addUnsafeEnchantment(Enchantment.DURABILITY, 15);
        boots.addUnsafeEnchantment(Enchantment.THORNS, 10);

        skeleton.getEquipment().setHelmet(helmet);
        skeleton.getEquipment().setChestplate(chestplate);
        skeleton.getEquipment().setLeggings(leggings);
        skeleton.getEquipment().setBoots(boots);

        skeleton.setCustomName("Turtle Guardian");
        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 6));
        killer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 4));

        ItemStack killerChestplate = Objects.requireNonNull(killer.getEquipment()).getChestplate();

        if (killerChestplate == null) return;

        if (killerChestplate.getType() != Material.ELYTRA) return;

        world.dropItem(killer.getLocation(), killerChestplate);
//        killer.getInventory().addItem(killerChestplate);
        killer.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
    }
}
}
