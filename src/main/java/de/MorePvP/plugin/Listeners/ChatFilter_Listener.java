package de.MorePvP.plugin.Listeners;

import de.MorePvP.plugin.Lobby;
import de.MorePvP.plugin.Utils.STATICS;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFilter_Listener implements Listener {

    private Lobby main;

    public ChatFilter_Listener(Lobby main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        final String message = event.getMessage().trim();
        float uppercaseLatter = 0;

        if (message.equalsIgnoreCase("dies das ananas")) {
            event.getPlayer().sendMessage("§b§lDie Devs sind da ( ͡° ͜ʖ ͡°)");
        }

        for (int i = 0; i < message.length(); i++) {
            if (Character.isUpperCase(message.charAt(i)) && Character.isLetter(message.charAt(i))) {
                uppercaseLatter++;
            }
        }

        if (uppercaseLatter / (float) message.length() > 0.3F) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(STATICS.PREFIX + "Bitte benutze nicht so viele Großbuchstaben");
        }

    }

}
