package de.MorePvP.plugin.Inventory;

import de.MorePvP.plugin.API.ItemAPI;
import de.MorePvP.plugin.Lobby;
import de.MorePvP.plugin.Utils.STATICS;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Main_Gadgets implements Listener {

    private Lobby main;
    private Inventory inventory;

    public Main_Gadgets(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);

        inventory = Bukkit.createInventory(null, 9, "§6§lGadgets");
        inventory.setItem(0, new ItemAPI("§d§lEnder Perle", Material.ENDER_PEARL, (byte) 0, 1).build());
        inventory.setItem(1, new ItemAPI("§a§lJumpBoost", Material.FEATHER, (byte) 0, 1).build());
        inventory.setItem(8, new ItemAPI("§c§lKein Gadget", Material.BARRIER, (byte) 0, 1).build());
    }

    @EventHandler
    public void onGadgets(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getItem().getType() == Material.CHEST) {
            event.getPlayer().openInventory(inventory);
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.CHEST_OPEN, 3, 1);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getClickedInventory() != null && event.getClickedInventory().getName().equalsIgnoreCase("§6§lGadgets")) {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory() != null && event.getCurrentItem().getType() != Material.AIR) {
                Material material = event.getCurrentItem().getType();
                if (material == Material.ENDER_PEARL) {
                    player.getInventory().setItem(4, new ItemAPI("§d§lEnder Perle", Material.ENDER_PEARL, (byte) 0, 1).build());
                } else if (material == Material.FIREWORK) {
                    player.getInventory().setItem(4, new ItemAPI("§f§lFire§c§lWork", Material.FIREWORK, (byte) 0, 1).build());
                } else if (material == Material.FISHING_ROD) {
                    player.getInventory().setItem(4, new ItemAPI("§b§lEnterhaken", Material.FISHING_ROD, (byte) 0, 1).build());
                } else if (material == Material.BARRIER) {
                    player.getInventory().setItem(4, new ItemAPI("§c§lKein Gadget ausgewählt", Material.BARRIER, (byte) 0, 1).build());
                } else if (material == Material.FEATHER) {
                player.getInventory().setItem(4, new ItemAPI("§a§lJumpBoost", Material.FEATHER, (byte) 0, 1).build());
            } else {
                    player.sendMessage(STATICS.PREFIX + "Unser Entwicklungsteam arbeitet daran, das dieses Gadget bald funktioniert!");
                }
                player.closeInventory();
                player.updateInventory();
                player.playSound(player.getLocation(), Sound.ITEM_BREAK, 3, 1);
            }
        }
    }

}
