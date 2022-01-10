package me.v1nc3ntwastaken.dynmaplocationmap;

import net.md_5.bungee.api.ChatColor;

public class Colors {
    public static ChatColor getPrimaryColor() {
        return ChatColor.getByChar(DynmapLocationMap.getConfiguration().getString("primary", "8").charAt(0)) == null ?
                ChatColor.getByChar('8') :
                ChatColor.getByChar(DynmapLocationMap.getConfiguration().getString("primary", "8").charAt(0));
    }

    public static ChatColor getSecondaryColor() {
        return ChatColor.getByChar(DynmapLocationMap.getConfiguration().getString("secondary", "7").charAt(0)) == null ?
                ChatColor.getByChar('7') :
                ChatColor.getByChar(DynmapLocationMap.getConfiguration().getString("secondary", "7").charAt(0));
    }

    public static ChatColor getLinkColor() {
        return ChatColor.getByChar(DynmapLocationMap.getConfiguration().getString("link", "b").charAt(0)) == null ?
                ChatColor.getByChar('b') :
                ChatColor.getByChar(DynmapLocationMap.getConfiguration().getString("link", "b").charAt(0));
    }

    public static ChatColor getTextColor() {
        return ChatColor.getByChar(DynmapLocationMap.getConfiguration().getString("text", "c").charAt(0)) == null ?
                ChatColor.getByChar('c') :
                ChatColor.getByChar(DynmapLocationMap.getConfiguration().getString("text", "c").charAt(0));
    }
}
