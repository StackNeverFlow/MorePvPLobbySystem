package de.MorePvP.plugin.Inventory;

import de.MorePvP.plugin.API.ItemAPI;
import de.MorePvP.plugin.Lobby;
import de.MorePvP.plugin.Utils.STATICS;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class Firework_Gadget implements Listener {

    private Lobby main;

    public Firework_Gadget(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    public void onFireworkListener(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getItem().getType() == Material.FIREWORK) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                final Player player = (Player) event.getPlayer();
                event.setCancelled(true);

                player.getInventory().setItem(4, new ItemAPI("§f§lFire§c§lWork", Material.FIREWORK, (byte) 0, 1).build());
                player.updateInventory();

                Location location = player.getLocation();
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    location = event.getClickedBlock().getRelative(BlockFace.UP).getLocation();
                }

                FireworkMeta fireworkMeta = (FireworkMeta) event.getItem().getItemMeta();
                fireworkMeta.setPower(1);
                fireworkMeta.addEffect(FireworkEffect.builder().withFade(Color.ORANGE).withColor(Color.BLUE).trail(true).build());

                Firework firework = location.getWorld().spawn(location, Firework.class);
                firework.setFireworkMeta(fireworkMeta);

                Bukkit.getScheduler().runTaskLater(main, new Runnable() {
                    @Override
                    public void run() {
                        player.getInventory().setItem(4, new ItemAPI("§f§lFire§c§lWork", Material.FIREWORK, (byte) 0, 1).build());
                        player.updateInventory();
                        player.sendMessage(STATICS.NOPERMS);
                    }
                }, 20 * 3);
            }
        }
    }

}
