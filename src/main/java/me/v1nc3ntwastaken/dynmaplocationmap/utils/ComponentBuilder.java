package me.v1nc3ntwastaken.dynmaplocationmap.utils;

import me.v1nc3ntwastaken.dynmaplocationmap.config.ConfigurationHandler;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;

public class ComponentBuilder {
    public static String buildUpDownSpacer(int len) {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i <= len; i++) {
            string.append("-");
        }

        return string.toString();
    }

    public static TextComponent buildUpDownSpacerComponent(int len) {
        TextComponent component = new TextComponent(buildUpDownSpacer(len));
        component.setColor(Colors.PRIMARY.getColor());

        return component;
    }

    public static String buildBeginningSpacer() {
        return " |";
    }

    public static TextComponent buildBeginningSpacerComponent() {
        TextComponent component = new TextComponent(buildBeginningSpacer());
        component.setColor(Colors.SECONDARY.getColor());

        return component;
    }

    public static String buildTextSpacer() {
        return "   ";
    }

    public static TextComponent buildTextSpacerComponent() {
        TextComponent component = new TextComponent(buildTextSpacer());

        return component;
    }

    public static String buildAvailableLinksText() {
        return "Available Map Links: ";
    }

    public static TextComponent buildAvailableLinksTextComponent() {
        TextComponent component = new TextComponent(buildAvailableLinksText());
        component.setColor(Colors.TEXT.getColor());

        return component;
    }

    public static String buildMapLinkHereText() {
        return " Map Link: ";
    }

    public static TextComponent buildMapLinkHereTextComponent() {
        TextComponent component = new TextComponent(buildMapLinkHereText());
        component.setColor(Colors.TEXT.getColor());

        return component;
    }

    public static String buildBaseLink() {
        return ConfigurationHandler.getLink();
    }

    public static TextComponent buildBaseLinkComponent(String title) {
        TextComponent component = new TextComponent(title);
        component.setColor(Colors.LINK.getColor());
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, buildHoverText(buildBaseLink())));
        component.setUnderlined(true);
        component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, buildBaseLink()));

        return component;
    }

    public static String buildLocationLink(Location location) {
        String mapName;
        int zoom;

        if (ConfigurationHandler.getLocationWorldMapDefaults().containsKey(location.getWorld().getName()))
            mapName = ConfigurationHandler.getLocationWorldMapDefaults().get(location.getWorld().getName());
        else
            mapName = ConfigurationHandler.getDefaultLocationMap();

        if (ConfigurationHandler.getLocationWorldZoomDefaults().containsKey(location.getWorld().getName()))
            zoom = ConfigurationHandler.getLocationWorldZoomDefaults().get(location.getWorld().getName());
        else
            zoom = ConfigurationHandler.getDefaultLocationZoom();

        return ConfigurationHandler.getLink() + "?" +
                "worldname=" + location.getWorld().getName() + "&" +
                "mapname=" + mapName + "&" +
                "zoom=" + zoom + "&" +
                "x=" + location.getBlockX() + "&" +
                "y=" + location.getBlockY() + "&" +
                "z=" + location.getBlockZ();
    }

    public static TextComponent buildLocationLinkComponent(String title, Location location) {
        TextComponent component = new TextComponent(title);
        component.setColor(Colors.LINK.getColor());
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, buildHoverText(buildLocationLink(location))));
        component.setUnderlined(true);
        component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, buildLocationLink(location)));

        return component;
    }

    public static String buildWorldLink(Location location) {
        String mapName;
        int zoom;

        if (ConfigurationHandler.getWorldMapDefaults().containsKey(location.getWorld().getName()))
            mapName = ConfigurationHandler.getWorldMapDefaults().get(location.getWorld().getName());
        else
            mapName = ConfigurationHandler.getDefaultWorldMap();

        if (ConfigurationHandler.getWorldZoomDefaults().containsKey(location.getWorld().getName()))
            zoom = ConfigurationHandler.getWorldZoomDefaults().get(location.getWorld().getName());
        else
            zoom = ConfigurationHandler.getDefaultWorldZoom();

        return ConfigurationHandler.getLink() + "?" +
                "worldname=" + location.getWorld().getName() + "&" +
                "mapname=" + mapName + "&" +
                "zoom=" + zoom;
    }

    public static TextComponent buildWorldLinkComponent(String title, Location location) {
        TextComponent component = new TextComponent(title);
        component.setColor(Colors.LINK.getColor());
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, buildHoverText(buildWorldLink(location))));
        component.setUnderlined(true);
        component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, buildWorldLink(location)));

        return component;
    }

    public static String buildFlatLink(Location location) {
        int zoom;

        if (ConfigurationHandler.getFlatWorldZoomDefaults().containsKey(location.getWorld().getName()))
            zoom = ConfigurationHandler.getFlatWorldZoomDefaults().get(location.getWorld().getName());
        else
            zoom = ConfigurationHandler.getDefaultFlatZoom();

        return ConfigurationHandler.getLink() + "?" +
                "worldname=" + location.getWorld().getName() + "&" +
                "mapname=flat" + "&" +
                "zoom=" + zoom;
    }

    public static TextComponent buildFlatLinkComponent(String title, Location location) {
        TextComponent component = new TextComponent(title);
        component.setColor(Colors.LINK.getColor());
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, buildHoverText(buildFlatLink(location))));
        component.setUnderlined(true);
        component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, buildFlatLink(location)));

        return component;
    }

    public static String buildSurfaceLink(Location location) {
        int zoom;

        if (ConfigurationHandler.getSurfaceWorldZoomDefaults().containsKey(location.getWorld().getName()))
            zoom = ConfigurationHandler.getSurfaceWorldZoomDefaults().get(location.getWorld().getName());
        else
            zoom = ConfigurationHandler.getDefaultSurfaceZoom();

        return ConfigurationHandler.getLink() + "?" +
                "worldname=" + location.getWorld().getName() + "&" +
                "mapname=surface" + "&" +
                "zoom=" + zoom;
    }

    public static TextComponent buildSurfaceLinkComponent(String title, Location location) {
        TextComponent component = new TextComponent(title);
        component.setColor(Colors.LINK.getColor());
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, buildHoverText(buildSurfaceLink(location))));
        component.setUnderlined(true);
        component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, buildSurfaceLink(location)));

        return component;
    }

    public static String buildCaveLink(Location location) {
        int zoom;

        if (ConfigurationHandler.getCaveWorldZoomDefaults().containsKey(location.getWorld().getName()))
            zoom = ConfigurationHandler.getCaveWorldZoomDefaults().get(location.getWorld().getName());
        else
            zoom = ConfigurationHandler.getDefaultCaveZoom();

        return ConfigurationHandler.getLink() + "?" +
                "worldname=" + location.getWorld().getName() + "&" +
                "mapname=cave" + "&" +
                "zoom=" + zoom;
    }

    public static TextComponent buildCaveLinkComponent(String title, Location location) {
        TextComponent component = new TextComponent(title);
        component.setColor(Colors.LINK.getColor());
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, buildHoverText(buildCaveLink(location))));
        component.setUnderlined(true);
        component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, buildCaveLink(location)));

        return component;
    }

    public static BaseComponent[] buildHoverText(String link) {
        net.md_5.bungee.api.chat.ComponentBuilder componentBuilder = new net.md_5.bungee.api.chat.ComponentBuilder(Colors.TEXT.getColor() + "Link: \n" + Colors.LINK.getColor() + link);
        return componentBuilder.create();
    }
}
