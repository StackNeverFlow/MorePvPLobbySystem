package de.MorePvP.plugin.Listeners;

import de.MorePvP.plugin.API.ItemAPI;
import de.MorePvP.plugin.Lobby;
import de.MorePvP.plugin.Utils.STATICS;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerHide_Listener implements Listener {
    public List<Player> hide = new ArrayList<>();

    //Braustand inv vip group perms

    private Lobby main;

    public PlayerHide_Listener(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() != null) {
            if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cSpieler verstecken")) {
                hide.add(event.getPlayer());
                Bukkit.getOnlinePlayers().forEach(p -> {
                    if (event.getPlayer() != p) {
                        event.getPlayer().hidePlayer(p);
                        event.getPlayer().playEffect(event.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 1);
                    }
                });
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.EXPLODE, 3, 1);
                event.getPlayer().getInventory().setItem(2, new ItemAPI("§8» §cSpieler verstecken", Material.BLAZE_ROD, (byte) 0, 1).build());
                event.getPlayer().updateInventory();
                event.getPlayer().sendMessage(STATICS.PREFIX + "Alle Spieler sind nun versteckt");
            } else if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSpieler anzeigen")) {
                hide.remove(event.getPlayer());
                Bukkit.getOnlinePlayers().forEach(p -> {
                    if (event.getPlayer() != p) {
                        event.getPlayer().showPlayer(p);
                        event.getPlayer().playEffect(event.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 1);
                    }
                });
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.EXPLODE, 3, 1);
                event.getPlayer().getInventory().setItem(2, new ItemAPI("§6§lSpieler verstecken", Material.STICK, (byte) 0, 1).build());
                event.getPlayer().updateInventory();
                event.getPlayer().sendMessage(STATICS.PREFIX + "Alle Spieler werden nun wieder angezeigt");

            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Bukkit.getOnlinePlayers().forEach(p -> {
            if (hide.contains(p)) {
                if (p != event.getPlayer()) {
                    p.hidePlayer(event.getPlayer());
                }
            }
        });
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (hide.contains(event.getPlayer())) {
            hide.remove(event.getPlayer());
        }
    }

}
