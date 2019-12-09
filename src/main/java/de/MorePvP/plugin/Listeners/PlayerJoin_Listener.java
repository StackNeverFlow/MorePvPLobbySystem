package de.MorePvP.plugin.Listeners;

import de.MorePvP.plugin.API.LocationAPI;
import de.MorePvP.plugin.Inventory.Gadgets_setInventory;
import de.MorePvP.plugin.Lobby;
import de.dytanic.cloudnet.bridge.CloudServer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin_Listener implements Listener {

    private Lobby main;

    public PlayerJoin_Listener(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        event.setJoinMessage(null);

        event.getPlayer().getInventory().clear();
        event.getPlayer().setGameMode(GameMode.ADVENTURE);

        new Gadgets_setInventory(event.getPlayer()).setInventory();

        new LocationAPI().SpawnTeleport(event.getPlayer());
    }

}
