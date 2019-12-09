package de.MorePvP.plugin.Listeners;

import de.MorePvP.plugin.API.LocationAPI;
import de.MorePvP.plugin.Inventory.Gadgets_setInventory;
import de.dytanic.cloudnet.bridge.CloudServer;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin_Listener implements Listener {

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        event.setJoinMessage(null);

        event.getPlayer().getInventory().clear();
        event.getPlayer().setGameMode(GameMode.ADVENTURE);

        new Gadgets_setInventory(event.getPlayer()).setInventory();

        new LocationAPI().SpawnTeleport(event.getPlayer());
    }

}
