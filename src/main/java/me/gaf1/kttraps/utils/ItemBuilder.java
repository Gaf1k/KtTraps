package me.gaf1.kttraps.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private final ItemStack itemStack;
    private final ItemMeta meta;

    public ItemBuilder(Material  material){
        itemStack = new ItemStack(material);
        meta = itemStack.getItemMeta();
    }

    public ItemBuilder setAmount(int amount){
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setName(String value){
        meta.displayName(ChatUtil.color(value));
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(List<String> value){
        List<Component> list = new ArrayList<>();
        for (String text: value){
            list.add(ChatUtil.color(text));
        }
        meta.lore(list);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment value, int level){
        meta.addEnchant(value,level,true);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder removeEnchant(Enchantment value){
        meta.removeEnchant(value);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addPersistent(String key, PersistentDataType persistentDataType, Object value){
        meta.getPersistentDataContainer().set(NamespacedKey.fromString(key),persistentDataType,value);
        itemStack.setItemMeta(meta);
        return this;
    }
    public ItemBuilder addPersistent(String key, PersistentDataType persistentDataType){
        meta.getPersistentDataContainer().remove(NamespacedKey.fromString(key));
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addFlag(ItemFlag value){
        meta.addItemFlags(value);
        return this;
    }
    public ItemBuilder addFlag(ItemFlag value1, ItemFlag value2){
        meta.addItemFlags(value1,value2);
        return this;
    }
    public ItemBuilder addFlag(ItemFlag value1, ItemFlag value2, ItemFlag value3){
        meta.addItemFlags(value1,value2,value3);
        return this;
    }
    public ItemBuilder addFlag(ItemFlag value1, ItemFlag value2, ItemFlag value3, ItemFlag value4){
        meta.addItemFlags(value1,value2,value3,value4);
        return this;
    }
    public ItemBuilder addFlag(ItemFlag value1, ItemFlag value2, ItemFlag value3, ItemFlag value4, ItemFlag value5){
        meta.addItemFlags(value1,value2,value3,value4,value5);
        return this;
    }
    public ItemBuilder addFlag(ItemFlag value1, ItemFlag value2, ItemFlag value3, ItemFlag value4, ItemFlag value5, ItemFlag value6){
        meta.addItemFlags(value1,value2,value3,value4,value5,value6);
        return this;
    }
    public ItemBuilder removeFlag(ItemFlag value){
        meta.removeItemFlags(value);
        return this;
    }
    public ItemBuilder removeFlag(ItemFlag value1, ItemFlag value2){
        meta.removeItemFlags(value1,value2);
        return this;
    }
    public ItemBuilder removeFlag(ItemFlag value1, ItemFlag value2, ItemFlag value3){
        meta.removeItemFlags(value1,value2,value3);
        return this;
    }
    public ItemBuilder removeFlag(ItemFlag value1, ItemFlag value2, ItemFlag value3, ItemFlag value4){
        meta.removeItemFlags(value1,value2,value3,value4);
        return this;
    }
    public ItemBuilder removeFlag(ItemFlag value1, ItemFlag value2, ItemFlag value3, ItemFlag value4, ItemFlag value5){
        meta.removeItemFlags(value1,value2,value3,value4,value5);
        return this;
    }
    public ItemBuilder removeFlag(ItemFlag value1, ItemFlag value2, ItemFlag value3, ItemFlag value4, ItemFlag value5, ItemFlag value6){
        meta.removeItemFlags(value1,value2,value3,value4,value5,value6);
        return this;
    }
    public ItemBuilder addOrRemoveAllFlags(Boolean value){
        if (value){
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS,ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_DESTROYS,ItemFlag.HIDE_DYE,ItemFlag.HIDE_POTION_EFFECTS,ItemFlag.HIDE_PLACED_ON,ItemFlag.HIDE_UNBREAKABLE);
        }
        else {
            meta.removeItemFlags(ItemFlag.HIDE_ENCHANTS,ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_DESTROYS,ItemFlag.HIDE_DYE,ItemFlag.HIDE_POTION_EFFECTS,ItemFlag.HIDE_PLACED_ON,ItemFlag.HIDE_UNBREAKABLE);
        }

        return this;
    }
    public ItemStack build(){
        return itemStack;
    }
}
