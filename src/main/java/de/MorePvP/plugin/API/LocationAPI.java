package de.MorePvP.plugin.API;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationAPI {

    public void SpawnTeleport(final Player player) {
        Location location = player.getLocation();

        location.setWorld(Bukkit.getWorld("lobby"));
        location.setX(-1919.5);
        location.setY(122);
        location.setZ(-883.5);

        player.teleport(location);
    }

}
