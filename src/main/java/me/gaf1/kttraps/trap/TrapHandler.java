package me.gaf1.kttraps.trap;

import me.gaf1.kttraps.Plugin;
import me.gaf1.kttraps.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class TrapHandler {
    public static ItemStack getStack(){
        Material material = null;
        String nameMaterial = Plugin.getInstance().getConfig().getString("trap-item.material","NETHERITE_SCRAP").toUpperCase();
        if (nameMaterial.contains("basehead-")){
            material = Material.PLAYER_HEAD;
        }
        else {
            material = Material.matchMaterial(nameMaterial);
        }

        ItemStack itemStack = new ItemBuilder(material)
                .addPersistent("kttrap", PersistentDataType.STRING,"trap")
                .build();
        ItemMeta meta = itemStack.getItemMeta();

        List<String> itemflags = Plugin.getInstance().getConfig().getStringList("trap-item.itemflags");
        for (String flag: itemflags){
            meta.addItemFlags(ItemFlag.valueOf(flag.toUpperCase()));
        }
        if (Plugin.getInstance().getConfig().getBoolean("trap-item")){
            meta.addEnchant(Enchantment.DURABILITY,1,true);
        }


        return itemStack;
    }
}
