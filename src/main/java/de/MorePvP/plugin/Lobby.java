package de.MorePvP.plugin;

import de.MorePvP.plugin.Events.Inventory_Events;
import de.MorePvP.plugin.Inventory.*;
import de.MorePvP.plugin.Listeners.ChatFilter_Listener;
import de.MorePvP.plugin.Listeners.PlayerHide_Listener;
import de.MorePvP.plugin.Listeners.PlayerJoin_Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {

    public void onEnable() {

        new ChatFilter_Listener(this);
        new PlayerHide_Listener(this);
        new PlayerJoin_Listener(this);
        new de.StackNeverFlow.plugin.Events.Player_Events(this);
        new Inventory_Events(this);

        new Profil_Inventory(this);
        new Main_Gadgets(this);
        new Jumpboost_Gadget(this);
        new Firework_Gadget(this);
        new de.StackNeverFlow.plugin.Inventory.Enderpearl_Gadget(this);
        new Enterhaken_Gadget(this);
        new Navigator_Gadget(this);

    }

    @Override
    public void onDisable() {

    }
}
