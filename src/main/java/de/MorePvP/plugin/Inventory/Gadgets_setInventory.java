package de.MorePvP.plugin.Inventory;

import de.MorePvP.plugin.API.ItemAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Gadgets_setInventory {

    Player player;

    public Gadgets_setInventory(Player player) {
        this.player = player;
    }

    public void setInventory() {
        player.getInventory().setItem(1, new ItemAPI("§6§lTeleporter", Material.COMPASS, (byte) 0, 1).build());
        player.getInventory().setItem(2, new ItemAPI("§6§lSpieler verstecken", Material.STICK, (byte) 0, 1).build());
        player.getInventory().setItem(4, new ItemAPI("§c§lKein Gadget ausgewählt", Material.BARRIER, (byte) 0, 1).build());
        player.getInventory().setItem(6, new ItemAPI("§6§lGadgets", Material.CHEST, (byte) 0, 1).build());
        player.getInventory().setItem(7, new ItemAPI("§6§lDein Profil", player.getName(), 1).buildSkull());
        player.updateInventory();
    }

}
