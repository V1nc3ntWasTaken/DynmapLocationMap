package me.v1nc3ntwastaken.dynmaplocationmap;

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
        beginningSpace.setColor(Colors.getSecondaryColor());

        TextComponent textSpacer = new TextComponent("   ");

        if (sender instanceof ConsoleCommandSender) {
            TextComponent mapLinkText = new TextComponent("Map Link: ");
            mapLinkText.setColor(Colors.getTextColor());

            TextComponent mapLink = new TextComponent();
            mapLink.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link));
            mapLink.setColor(Colors.getLinkColor());

            sender.sendMessage(Colors.getSecondaryColor() + " |" + Colors.getPrimaryColor() + "--------------------");
            sender.sendMessage(Colors.getSecondaryColor() + " |" + Colors.getTextColor() + "  Available map links:");
            sender.spigot().sendMessage(beginningSpace, textSpacer, mapLinkText, mapLinkText);

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
            mapLinkText.setColor(Colors.getLinkColor());
            mapLinkText.setUnderlined(true);
            mapLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link));

            TextComponent locationLinkText = new TextComponent("Location Link");
            locationLinkText.setColor(Colors.getLinkColor());
            locationLinkText.setUnderlined(true);
            locationLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, locationLink));

            sender.sendMessage(Colors.getSecondaryColor() + " |" + Colors.getPrimaryColor() + "--------------------");
            sender.sendMessage(Colors.getSecondaryColor() + " |" + Colors.getTextColor() + "  Available map links:");
            sender.spigot().sendMessage(beginningSpace, textSpacer, mapLinkText);
            sender.spigot().sendMessage(beginningSpace, textSpacer, locationLinkText);

        }
        sender.sendMessage(Colors.getSecondaryColor() + " |" + Colors.getPrimaryColor() + "--------------------");
        return true;
    }
}
