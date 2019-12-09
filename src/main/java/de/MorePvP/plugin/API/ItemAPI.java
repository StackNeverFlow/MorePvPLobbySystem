package de.MorePvP.plugin.API;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemAPI {

    ItemStack itemStack;
    ItemMeta itemMeta;
    SkullMeta skullMeta;

    public ItemAPI(String displayname, Material material, byte subid, int amount) {

        itemStack = new ItemStack(material, amount, subid);
        itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(displayname);
    }

    public ItemAPI(String displayname, Material material, byte subid, int amount, Enchantment enchantment) {

        itemStack = new ItemStack(material, amount, subid);
        itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(displayname);
        itemMeta.addEnchant(enchantment, 10, true);
    }

    public ItemAPI(String displayname, String skullowner, int amount) {
        itemStack = new ItemStack(Material.SKULL_ITEM, 1 , (byte) 3);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setDisplayName(displayname);
        skullMeta.setOwner(skullowner);
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack buildSkull() {
        itemStack.setItemMeta(skullMeta);
        return itemStack;
    }

}
