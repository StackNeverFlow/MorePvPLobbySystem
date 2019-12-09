package de.MorePvP.plugin.Inventory;

import de.MorePvP.plugin.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class Enterhaken_Gadget implements Listener {

    private Lobby main;

    public Enterhaken_Gadget(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onFishing(PlayerFishEvent event) {
        Player player = event.getPlayer();
        FishHook hook = event.getHook();

        if (hook.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
            Location playerLocation = player.getLocation();
            Location hookLocation = hook.getLocation();

            Vector vector = player.getVelocity();
            double distance = playerLocation.distance(hookLocation);

            vector.setX((1.08D * distance) * (hookLocation.getX() - playerLocation.getX()) / distance);
            vector.setY((1.08D * distance) * (hookLocation.getY() - playerLocation.getY()) / distance - -0.5D * distance);
            vector.setZ((1.08D * distance) * (hookLocation.getZ() - playerLocation.getZ()) / distance);

            player.setVelocity(vector);
            player.getInventory().getItemInHand().setDurability((short) 0);
            player.updateInventory();
        }
    }

}
