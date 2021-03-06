package me.Asrieldmr.ExtraAddons;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import me.Asrieldmr.ExtraAddons.Armors.HasteHelmet;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;


public class ExtraAddons extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        // Slimefun4 also already comes with a bundled version of bStats
        // You can use bStats to collect usage data about your plugin
        // More info: https://bstats.org/getting-started
        // Set bStatsId to the id of your plugin
        int bStatsId = -1;
        new Metrics(this, bStatsId);

        // Create a new Category
        // This Category will use this ItemStack
        ItemStack categoryItem = new CustomItem(Material.GOLD_BLOCK, "&eExtraAddons", "", "&a> Click to open");

        // Give your Category a unique id.
        NamespacedKey categoryId = new NamespacedKey(this, "ExtraAddons");
        Category category = new Category(categoryId, categoryItem);

        // Create a new Slimefun ItemStack
        // This class has many constructors, it is very important that you give each item a unique id.
        SlimefunItemStack hasteHelmet = new SlimefunItemStack("HASTE_HELMET", Material.GOLDEN_HELMET, "&eMiner's Helmet","&eGives Haste for the best mining expirince!");

        // The Recipe is an ItemStack Array with a length of 9.
        // It represents a Shaped Recipe in a 3x3 crafting grid
        // The machine in which this recipe is crafted in is specified further down
        ItemStack[] hastehelmetrecipe = { SlimefunItems.GOLD_16K, SlimefunItems.GOLD_16K, SlimefunItems.GOLD_16K, SlimefunItems.GOLD_16K, new ItemStack(Material.DIAMOND_HELMET), SlimefunItems.GOLD_16K, null, null, null };
        
        PotionEffect[] hastehelemeteffect = { new PotionEffect(PotionEffectType.FAST_DIGGING, 1000, 1)};
        
        // Now you just have to register the item
        // RecipeType.ENHANCED_CRAFTING_TABLE refers to the machine in which this item is crafted in.
        // Recipy Types from Slimefun itself will automatically add the recipe to that machine
        SlimefunItem HasteHelmet = new HasteHelmet(category, hasteHelmet, RecipeType.ENHANCED_CRAFTING_TABLE, hastehelmetrecipe, hastehelemeteffect);
        HasteHelmet.register(this);
    }

    

	@Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}
