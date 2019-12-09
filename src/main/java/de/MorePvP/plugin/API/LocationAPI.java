package de.MorePvP.plugin.API;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationAPI {

    public void SpawnTeleport(final Player player) {
        Location location = player.getLocation();

        location.setWorld(Bukkit.getWorld("lobby"));
        location.setX(-28.500);
        location.setY(21);
        location.setZ(22.5);

        player.teleport(location);
    }

}
