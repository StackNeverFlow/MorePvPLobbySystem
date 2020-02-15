package de.MorePvP.plugin.Events;

import de.MorePvP.plugin.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

import java.util.Arrays;

public class Player_Events implements Listener {

    private Lobby main;

    public Player_Events(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onFoodLevel(FoodLevelChangeEvent event) {
        event.setCancelled(true);
        event.setFoodLevel(20);
    }

    @EventHandler
    public void onHerz(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER || event.getEntityType() == EntityType.ITEM_FRAME || event.getEntityType() == EntityType.ARMOR_STAND) {
            event.setDamage(0);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTab(PlayerChatTabCompleteEvent event) {
        event.getTabCompletions().clear();
        event.getTabCompletions().addAll(Arrays.asList("ts", "friend", "clan", "party"));
    }

}
