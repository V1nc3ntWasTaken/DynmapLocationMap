package me.v1nc3ntwastaken.dynmaplocationmap;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;

public class MapCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String link = DynmapLocationMap.getConfiguration().getString("dynmap-link", "https://localhost:8080/");

        TextComponent beginningSpace = new TextComponent(" |");
        beginningSpace.setColor(ChatColor.GRAY);

        TextComponent textSpacer = new TextComponent("   ");

        if (sender instanceof ConsoleCommandSender) {
            TextComponent mapLinkText = new TextComponent("Map Link: ");
            mapLinkText.setColor(ChatColor.RED);

            TextComponent mapLink = new TextComponent();
            mapLink.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link));
            mapLink.setColor(ChatColor.AQUA);

            sender.sendMessage(ChatColor.GRAY + " |" + ChatColor.DARK_GRAY + "--------------------");
            sender.sendMessage(ChatColor.GRAY + " |" + ChatColor.RED + "  Available map links:");
            sender.spigot().sendMessage(beginningSpace, textSpacer, mapLinkText, mapLinkText);
            sender.sendMessage(ChatColor.GRAY + " |" + ChatColor.DARK_GRAY + "--------------------");

            return true;
        } else {
            Entity entity = (Entity) sender;

            String locationLink = link + "?" +
                    "worldname=" + entity.getWorld().getName() + "&" +
                    "mapname=flat" + "&" +
                    "zoom=4" + "&" +
                    "x=" + entity.getLocation().getBlockX() + "&" +
                    "y=64" + "&" +
                    "z=" + entity.getLocation().getBlockZ();

            TextComponent mapLinkText = new TextComponent("Map Link");
            mapLinkText.setColor(ChatColor.AQUA);
            mapLinkText.setUnderlined(true);
            mapLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link));

            TextComponent locationLinkText = new TextComponent("Location Link");
            locationLinkText.setColor(ChatColor.AQUA);
            locationLinkText.setUnderlined(true);
            locationLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, locationLink));

            sender.sendMessage(ChatColor.GRAY + " |" + ChatColor.DARK_GRAY + "--------------------");
            sender.sendMessage(ChatColor.GRAY + " |" + ChatColor.RED + "  Available map links:");
            sender.spigot().sendMessage(beginningSpace, textSpacer, mapLinkText);
            sender.spigot().sendMessage(beginningSpace, textSpacer, locationLinkText);
            sender.sendMessage(ChatColor.GRAY + " |" + ChatColor.DARK_GRAY + "--------------------");

            return true;
        }
    }
}
