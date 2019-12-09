package de.MorePvP.plugin.Inventory;

import de.MorePvP.plugin.API.ItemAPI;
import de.MorePvP.plugin.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Profil_Inventory implements Listener {

    private Lobby main;

    public Inventory profileInventory;
    public Inventory hatsInventory;

    public Profil_Inventory(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);

        profileInventory = Bukkit.createInventory(null, 9, "§6§lDein Profil");

        profileInventory.setItem(1, new ItemAPI("§6§lHüte", Material.CHAINMAIL_HELMET, (byte) 0, 1).build());

        hatsInventory = Bukkit.createInventory(null, 27, "§6§lHüte");
        hatsInventory.addItem(new ItemAPI("§f§lKettenhelm", Material.CHAINMAIL_HELMET, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§d§lDiamanthelm", Material.DIAMOND_HELMET, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§e§lGlas", Material.GLASS, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§2§lTruhe", Material.CHEST, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§c§lTNT", Material.TNT, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§a§lKaktus", Material.CACTUS, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§9§lCommandblock", Material.COMMAND, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§5§lBücherregal", Material.BOOKSHELF, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§9§lZiegel", Material.BRICK, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§f§lSchnee§b§lBlock", Material.SNOW_BLOCK, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§7§lBedrock", Material.BEDROCK, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§6§lSchwamm", Material.SPONGE, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§a§lEmerald§f§lErz", Material.EMERALD_ORE, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§d§lEnder§5§lStein", Material.ENDER_STONE, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§5§lObsid§d§lian", Material.OBSIDIAN, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§c§lNetherrack", Material.NETHERRACK, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§c§lRote§4§lSand§c§lStufe", Material.RED_SANDSTONE_STAIRS, (byte) 0, 1).build());
        hatsInventory.addItem(new ItemAPI("§7§lErde", Material.DIRT, (byte) 0, 1).build());

        hatsInventory.setItem(26, new ItemAPI("§c§lHelme ablegen", Material.BARRIER, (byte) 0, 1).build());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() != null && event.getItem().getType() == Material.SKULL_ITEM) {
            event.getPlayer().openInventory(profileInventory);
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.CHEST_OPEN, 3 ,1);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory().getName().equalsIgnoreCase("§6§lDein Profil")) {
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR) {
                Material material = event.getCurrentItem().getType();
                if (material == Material.CHAINMAIL_HELMET) {
                    player.openInventory(hatsInventory);
                    player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 3, 1);
                    event.setCancelled(true);
                }
            }
        }

        if (event.getClickedInventory().getName().equalsIgnoreCase("§6§lHüte")) {
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR) {
                Material material = event.getCurrentItem().getType();
                if (material != Material.BARRIER) {
                    player.getInventory().setHelmet(event.getCurrentItem());
                    player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 3, 1);
                    player.closeInventory();
                    player.updateInventory();
                    event.setCancelled(true);
                } else {
                    player.getInventory().setHelmet(null);
                }
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 3, 1);
                player.closeInventory();
                player.updateInventory();
                event.setCancelled(true);
            }
        }

    }

}
