package me.v1nc3ntwastaken.dynmaplocationmap;

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
import java.util.Objects;

public final class DynmapLocationMap extends JavaPlugin implements CommandExecutor, TabCompleter {
    static FileConfiguration config;

    @Override
    public void onEnable() {
        // Plugin startup logic

        saveDefaultConfig();

        Objects.requireNonNull(getCommand("map")).setExecutor(new MapCommand());
        Objects.requireNonNull(getCommand("mapadmin")).setExecutor(this);

        config = getConfig();
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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0)
            if (args[0].equalsIgnoreCase("reload")) {
                saveDefaultConfig();
                reloadConfiguration();
                sender.sendMessage(Colors.getSecondaryColor() + " |" + Colors.getPrimaryColor() + "--------------------");
                sender.sendMessage(Colors.getSecondaryColor() + " |" + Colors.getTextColor() + "  Plugin reloaded!");
                sender.sendMessage(Colors.getSecondaryColor() + " |" + Colors.getPrimaryColor() + "--------------------");
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
