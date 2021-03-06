package de.MorePvP.plugin.Inventory;

import de.MorePvP.plugin.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Jumpboost_Gadget implements Listener {

    private Lobby main;

    public Jumpboost_Gadget(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onInteractFeather(final PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                if (event.getItem().getType() == Material.FEATHER) {

                event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(+2));

                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENDERDRAGON_WINGS, 3, 1);
                event.getPlayer().playEffect(event.getPlayer().getLocation(), Effect.LAVA_POP, 3);
            }
        }
    }

}
