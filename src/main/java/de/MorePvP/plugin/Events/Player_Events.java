package de.StackNeverFlow.plugin.Events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Player_Events implements Listener {

    @EventHandler
    public void onFoodLevel(FoodLevelChangeEvent event) {
        event.setFoodLevel(20);
        event.setCancelled(true);
    }

    @EventHandler
    public void onHerz(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER || event.getEntityType() == EntityType.ITEM_FRAME || event.getEntityType() == EntityType.ARMOR_STAND) {
            event.setDamage(0);
            event.setCancelled(true);
        }
    }

}
