package me.v1nc3ntwastaken.dynmaplocationmap.config;

import java.util.ArrayList;

public enum ConfigNodes {
    // Version:
    VERSION_HEADER("version", ""),
    VERSION(
            "version.version",
            "",
            "# This is the current config version. Please do not edit."),
    LAST_RUN_VERSION(
            "version.last_run_version",
            "",
            "# This is the last version the config was run with, it's used to show changelogs! Please do not edit."),
    // Link:
    LINK(
            "link",
            "https://LINK/",
            "# Dynmap link in the following format:",
            "# https://LINK/"),

    // Locations:
    LOCATIONS("locations", "", ""),
    LOCATIONS_DEFAULT_MAP(
            "locations.default_map",
            "flat",
            "# Default map to use with location links.",
            "# Use flat, cave, surface"),
    LOCATIONS_DEFAULT_WORLD_MAPS(
            "locations.default_world_maps",
            "world:flat,nether:flat,the_end:flat",
            "",
            "# Map types to use in location links. Non-included worlds will use locations.default_map",
            "# Use flat, cave, surface"),
    LOCATIONS_DEFAULT_ZOOM(
            "locations.default_zoom",
            "4",
            "",
            "# Default zoom to use with location maps."),
    LOCATIONS_DEFAULT_WORLD_ZOOMS(
            "locations.default_world_zooms",
            "worldname:5,worldname2:3",
            "",
            "# Zoom levels to use in location maps. Non-included worlds will use locations.default_zoom",
            "# Use any integer above 0"),
    LOCATIONS_DISABLED_WORLDS(
            "locations.disabled_worlds",
            "disabledworld,disabledworld2",
            "",
            "# Worlds to not show map location links in. Ex. Worlds with dynmap disabled"),
    // Worlds:
    WORLDS("worlds", "", ""),
    WORLDS_DEFAULT_MAP(
            "worlds.default_map",
            "flat",
            "# Default map to use with world maps.",
            "# Use flat, cave, surface"),
    WORLDS_DEFAULT_WORLD_MAPS(
            "worlds.default_world_maps",
            "world:flat,nether:flat,the_end:flat",
            "",
            "# Map types to use in world links. Non-included worlds will use worlds.default_map",
            "# Use flat, cave, surface"),
    WORLDS_DEFAULT_ZOOM(
            "worlds.default_zoom",
            "4",
            "",
            "# Default zoom to use with world maps."),
    WORLDS_DEFAULT_WORLD_ZOOMS(
            "worlds.default_world_zooms",
            "worldname:5,worldname2:3",
            "",
            "# Zoom levels to use in world maps. Non-included worlds will use worlds.default_zoom",
            "# Use any integer above 0"),
    WORLDS_DISABLED_WORLDS(
            "worlds.disabled_worlds",
            "disabledworld,disabledworld2",
            "",
            "# Worlds to not show map world links in."),
    // Flat:
    FLAT("flat", "", ""),
    FLAT_DEFAULT_ZOOM(
            "flat.default_zoom",
            "4",
            "",
            "# Default zoom to use with flat maps."),
    FLAT_DEFAULT_WORLD_ZOOMS(
            "flat.default_world_zooms",
            "worldname:5,worldname2:3",
            "",
            "# Zoom levels to use in flat maps. Non-included worlds will use flat.default_zoom",
            "# Use any integer above 0"),
    FLAT_DISABLED_WORLDS(
            "flat.disabled_worlds",
            "disabledworld,disabledworld2",
            "",
            "# Worlds to not show map flat links in."),
    // Cave:
    CAVE("cave", "", ""),
    CAVE_DEFAULT_ZOOM(
            "cave.default_zoom",
            "4",
            "",
            "# Default zoom to use with cave maps."),
    CAVE_DEFAULT_WORLD_ZOOMS(
            "cave.default_world_zooms",
            "worldname:5,worldname2:3",
            "",
            "# Zoom levels to use in cave maps. Non-included worlds will use cave.default_zoom",
            "# Use any integer above 0"),
    CAVE_DISABLED_WORLDS(
            "cave.disabled_worlds",
            "disabledworld,disabledworld2",
            "",
            "# Worlds to not show map cave links in."),
    // Surface:
    SURFACE("surface", "", ""),
    SURFACE_DEFAULT_ZOOM(
            "surface.default_zoom",
            "4",
            "",
            "# Default zoom to use with surface maps."),
    SURFACE_DEFAULT_WORLD_ZOOMS(
            "surface.default_world_zooms",
            "worldname:5,worldname2:3",
            "",
            "# Zoom levels to use in surface maps. Non-included worlds will use surface.default_zoom",
            "# Use any integer above 0"),
    SURFACE_DISABLED_WORLDS(
            "surface.disabled_worlds",
            "disabledworld,disabledworld2",
            "",
            "# Worlds to not show map surface links in."),
    // Colors:
    COLORS("colors", "", ""),
    COLORS_PRIMARY("colors.primary", "8", "", "# Primary color character"),
    COLORS_SECONDARY("colors.secondary", "7", "# Secondary color character"),
    COLORS_TEXT("colors.text", "c", "# Text color character"),
    COLORS_LINK("colors.link", "b", "# Link color character"),
    COLORS_HOVER("colors.hover", "a", "# Hover color character");


    private final String Root;
    private final String Default;
    private String[] comments;

    ConfigNodes(String root, String def, String... comments) {

        this.Root = root;
        this.Default = def;
        this.comments = comments;
    }

    /**
     * Retrieves the root for a config option
     *
     * @return The root for a config option
     */
    public String getRoot() {

        return Root;
    }

    /**
     * Retrieves the default value for a config path
     *
     * @return The default value for a config path
     */
    public String getDefault() {

        return Default;
    }

    /**
     * Retrieves the comment for a config path
     *
     * @return The comments for a config path
     */
    public String[] getComments() {

        if (comments != null) {
            return comments;
        }

        String[] comments = new String[1];
        comments[0] = "";
        return comments;
    }
}