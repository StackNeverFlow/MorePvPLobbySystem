package de.StackNeverFlow.plugin.Inventory;

import de.MorePvP.plugin.API.ItemAPI;
import de.MorePvP.plugin.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

import java.util.HashMap;

public class Enderpearl_Gadget implements Listener {

    private Lobby main;
    private HashMap<Player, EnderPearl> enderpearls = new HashMap<>();

    public Enderpearl_Gadget(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onEnderpearlGadget(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getItem().getType() == Material.ENDER_PEARL) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                final Player player = (Player) event.getPlayer();
                event.setCancelled(true);

                player.getInventory().setItem(4, new ItemAPI("§7§lEnder Perle", Material.FIREWORK_CHARGE, (byte) 0, 1).build());
                player.updateInventory();

                EnderPearl enderPearl = player.launchProjectile(EnderPearl.class);
                enderPearl.setPassenger(player);
                enderpearls.put(player, enderPearl);

                Bukkit.getScheduler().runTaskLater(main, new Runnable() {
                    @Override
                    public void run() {
                        player.getInventory().setItem(4, new ItemAPI("§d§lEnder Perle", Material.ENDER_PEARL, (byte) 0, 1).build());
                        player.updateInventory();
                    }
                }, 20 * 5);
            }
        }
    }

    @EventHandler
    public void onVehicleLeave(VehicleExitEvent event) {
        if (event.getExited() instanceof Player) {
            if (enderpearls.containsKey(event.getExited())) {
                enderpearls.get(event.getExited()).remove();
            }
        }
    }
}
