package me.v1nc3ntwastaken.dynmaplocationmap;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DynmapLocationMap extends JavaPlugin implements CommandExecutor, TabCompleter {
    static FileConfiguration config;
    DynmapLocationMap plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic

        saveDefaultConfig();

        getCommand("map").setExecutor(new MapCommand());
        getCommand("mapadmin").setExecutor(this);

        config = getConfig();
        plugin = this;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();

            List<String> tabComplete = new ArrayList<>();
            tabComplete.add("reload");

            StringUtil.copyPartialMatches(args[0], tabComplete, list);

            return list;
        }

        return Collections.emptyList();
    }

    public DynmapLocationMap getInstance() {
        return plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0)
            if (args[0].equalsIgnoreCase("reload")) {
                reloadConfiguration();
                sender.sendMessage(ChatColor.GRAY + " |" + ChatColor.DARK_GRAY + "--------------------");
                sender.sendMessage(ChatColor.GRAY + " |" + ChatColor.RED + "  Plugin reloaded!");
                sender.sendMessage(ChatColor.GRAY + " |" + ChatColor.DARK_GRAY + "--------------------");
                return true;
            }

        return false;
    }

    private void reloadConfiguration() {
        config = YamlConfiguration.loadConfiguration(new File(getDataFolder() + File.pathSeparator + "config.yml"));
    }

    public static FileConfiguration getConfiguration() {
        return config;
    }

    @Override
    public void onDisable() {

    }
}
