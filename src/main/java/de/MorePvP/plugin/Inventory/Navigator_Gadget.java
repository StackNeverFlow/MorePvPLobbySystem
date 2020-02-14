package de.MorePvP.plugin.Inventory;

import de.MorePvP.plugin.API.ItemAPI;
import de.MorePvP.plugin.API.LocationAPI;
import de.MorePvP.plugin.Lobby;
import de.MorePvP.plugin.Utils.STATICS;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Navigator_Gadget implements Listener {

    private Lobby main;

    public Inventory NavigatorInventory;

    public Navigator_Gadget(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);

        NavigatorInventory = Bukkit.createInventory(null, 27, "§6§lCompass");
        NavigatorInventory.setItem(0, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(1, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(2, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(3, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(4, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(5, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(6, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(7, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(8, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(9, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(10, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(12, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(14, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(16, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(17, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(18, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(19, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(20, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(21, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(22, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(24, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(25, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());
        NavigatorInventory.setItem(26, new ItemAPI("§9", Material.STAINED_GLASS_PANE, (byte) 15, 1).build());

        NavigatorInventory.setItem(11, new ItemAPI("§8» §6Knock Out", Material.STICK, (byte) 0, 1).build());
        NavigatorInventory.setItem(13, new ItemAPI("§8» §6BedWars", Material.BED, (byte) 0, 1).build());
        NavigatorInventory.setItem(15, new ItemAPI("§8» §6BuildFFA", Material.SANDSTONE, (byte) 0, 1).build());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getItem().getType() == Material.COMPASS) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                event.getPlayer().openInventory(NavigatorInventory);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            Material material = event.getCurrentItem().getType();

            if (material == Material.STICK) {
                player.sendMessage(STATICS.PREFIX + "Dieser Spielmodus ist noch in Entwicklung");
            } else if (material == Material.BED) {
                new LocationAPI().BedWarsTeleport(player);
            } else if (material == Material.SANDSTONE) {
                new LocationAPI().BuildFFATeleport(player);
            }
        }
    }

}
