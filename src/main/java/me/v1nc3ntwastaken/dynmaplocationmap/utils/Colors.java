package me.v1nc3ntwastaken.dynmaplocationmap.utils;

import me.v1nc3ntwastaken.dynmaplocationmap.config.ConfigNodes;
import me.v1nc3ntwastaken.dynmaplocationmap.config.ConfigurationHandler;
import net.md_5.bungee.api.ChatColor;

public enum Colors {
    PRIMARY(ChatColor.getByChar(ConfigurationHandler.getPrimaryColor().charAt(0)) == null ?
            ChatColor.getByChar(ConfigNodes.COLORS_PRIMARY.getDefault().charAt(0)) :
            ChatColor.getByChar(ConfigurationHandler.getPrimaryColor().charAt(0))),
    SECONDARY(ChatColor.getByChar(ConfigurationHandler.getSecondaryColor().charAt(0)) == null ?
            ChatColor.getByChar(ConfigNodes.COLORS_SECONDARY.getDefault().charAt(0)) :
            ChatColor.getByChar(ConfigurationHandler.getSecondaryColor().charAt(0))),
    LINK(ChatColor.getByChar(ConfigurationHandler.getLinkColor().charAt(0)) == null ?
            ChatColor.getByChar(ConfigNodes.COLORS_LINK.getDefault().charAt(0)) :
            ChatColor.getByChar(ConfigurationHandler.getLinkColor().charAt(0))),
    TEXT(ChatColor.getByChar(ConfigurationHandler.getTextColor().charAt(0)) == null ?
            ChatColor.getByChar(ConfigNodes.COLORS_TEXT.getDefault().charAt(0)) :
            ChatColor.getByChar(ConfigurationHandler.getTextColor().charAt(0))),
    HOVER(ChatColor.getByChar(ConfigurationHandler.getHoverColor().charAt(0)) == null ?
            ChatColor.getByChar(ConfigNodes.COLORS_HOVER.getDefault().charAt(0)) :
            ChatColor.getByChar(ConfigurationHandler.getHoverColor().charAt(0)));

    private ChatColor color;

    Colors(net.md_5.bungee.api.ChatColor color) {
        this.color = color;
    }

    public ChatColor getColor() {
        return color;
    }
/*
    public static ChatColor getPrimaryColor() {
        String color = ConfigurationHandler.getPrimaryColor();
        char def = ConfigNodes.COLORS_PRIMARY.getDefault().charAt(0);

        return ChatColor.getByChar(ConfigurationHandler.getPrimaryColor().charAt(0)) == null ?
                ChatColor.getByChar(ConfigNodes.COLORS_PRIMARY.getDefault().charAt(0)) :
                ChatColor.getByChar(ConfigurationHandler.getPrimaryColor().charAt(0));
    }

    public static ChatColor getSecondaryColor() {
        String color = ConfigurationHandler.getSecondaryColor();
        char def = ConfigNodes.COLORS_SECONDARY.getDefault().charAt(0);

        return ChatColor.getByChar(color.charAt(0)) == null ?
                ChatColor.getByChar(def) :
                ChatColor.getByChar(color.charAt(0));
    }

    public static ChatColor getLinkColor() {
        String color = ConfigurationHandler.getLinkColor();
        char def = ConfigNodes.COLORS_LINK.getDefault().charAt(0);

        return ChatColor.getByChar(color.charAt(0)) == null ?
                ChatColor.getByChar(def) :
                ChatColor.getByChar(color.charAt(0));
    }

    public static ChatColor getTextColor() {
        String color = ConfigurationHandler.getTextColor();
        char def = ConfigNodes.COLORS_TEXT.getDefault().charAt(0);

        return ChatColor.getByChar(color.charAt(0)) == null ?
                ChatColor.getByChar(def) :
                ChatColor.getByChar(color.charAt(0));
    }*/
}
