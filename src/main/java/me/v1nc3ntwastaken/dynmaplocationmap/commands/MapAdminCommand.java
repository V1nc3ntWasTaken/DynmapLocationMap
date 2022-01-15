package me.v1nc3ntwastaken.dynmaplocationmap.commands;

import me.v1nc3ntwastaken.dynmaplocationmap.utils.Colors;
import me.v1nc3ntwastaken.dynmaplocationmap.config.ConfigurationHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapAdminCommand implements CommandExecutor, TabCompleter {
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
                ConfigurationHandler.loadSettings();
                sender.sendMessage(Colors.SECONDARY.getColor() + " |" + Colors.PRIMARY.getColor() + "--------------------");
                sender.sendMessage(Colors.SECONDARY.getColor() + " |" + Colors.TEXT.getColor() + "  Plugin reloaded!");
                sender.sendMessage(Colors.SECONDARY.getColor() + " |" + Colors.PRIMARY.getColor() + "--------------------");
                return true;
            }

        return false;
    }
}
