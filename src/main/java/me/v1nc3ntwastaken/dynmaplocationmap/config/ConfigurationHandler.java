package me.v1nc3ntwastaken.dynmaplocationmap.config;

import me.v1nc3ntwastaken.dynmaplocationmap.DynmapLocationMap;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public class ConfigurationHandler {
    private static DynmapLocationMap main;
    private static CommentedConfiguration config, newConfig;

    public static void initialize(DynmapLocationMap main) {
        ConfigurationHandler.main = main;
    }

    public static boolean loadSettings() {
        FileMgmt.checkFolders(new String[]{
                main.getRootFolder(),
                main.getRootFolder() + FileMgmt.fileSeparator() + "settings"});

        return ConfigurationHandler.loadConfig();
    }

    private static boolean loadConfig() {
        String filepath = main.getRootFolder() + FileMgmt.fileSeparator() + "settings" + FileMgmt.fileSeparator() + "config.yml";

        File file = FileMgmt.CheckYMLExists(new File(filepath));
        if (file != null) {

            // read the config.yml into memory
            config = new CommentedConfiguration(file);
            if (!config.load()) {
                main.getLogger().log(Level.SEVERE, "Failed to load config.yml");
                return false;
            }

            setDefaults(file);

            config.save();
        }
        return true;
    }

    /**
     * Builds a new config reading old config data.
     */
    private static void setDefaults(File file) {

        newConfig = new CommentedConfiguration(file);
        newConfig.load();

        for (ConfigNodes root : ConfigNodes.values()) {
            if (root.getComments().length > 0) {
                addComment(root.getRoot(), root.getComments());
            }
            if (root.getRoot().equals(ConfigNodes.VERSION.getRoot())) {
                setNewProperty(root.getRoot(), main.getVersion());
            } else
                setNewProperty(root.getRoot(), (config.get(root.getRoot().toLowerCase()) != null) ? config.get(root.getRoot().toLowerCase()) : root.getDefault());

        }

        config = newConfig;
        newConfig = null;
    }

    private static void addComment(String root, String... comments) {

        newConfig.addComment(root.toLowerCase(), comments);
    }

    private static void setProperty(String root, Object value) {

        config.set(root.toLowerCase(), value.toString());
    }

    private static void setNewProperty(String root, Object value) {

        if (value == null) {
            // System.out.print("value is null for " + root.toLowerCase());
            value = "";
        }
        newConfig.set(root.toLowerCase(), value.toString());
    }


    /**
     * Get's a value for a ConfigNode
     *
     * @param node - ConfigNode
     * @return - Value for node
     */
    private static String getString(ConfigNodes node) {

        return config.getString(node.getRoot().toLowerCase(), node.getDefault());

    }

    /**
     * Get's a value for a ConfigNode
     *
     * @param node - ConfigNode
     * @return - Value for node (specifically boolean)
     */
    private static boolean getBoolean(ConfigNodes node) {

        return Boolean.parseBoolean(config.getString(node.getRoot().toLowerCase(), node.getDefault()));
    }

    /**
     * Get's a value for a ConfigNode
     *
     * @param node - ConfigNode
     * @return - Value for node (specifically double)
     */
    private static double getDouble(ConfigNodes node) {

        try {
            return Double.parseDouble(config.getString(node.getRoot().toLowerCase(), node.getDefault()).trim());
        } catch (NumberFormatException e) {
            main.getLogger().log(Level.SEVERE, "Could not get/read double for value: " + node.getRoot().toLowerCase());
            return 0.0;
        }
    }

    /**
     * Get's a value for a ConfigNode
     *
     * @param node - ConfigNode
     * @return - Value for node (specifically int)
     */
    private static int getInt(ConfigNodes node) {

        try {
            return Integer.parseInt(config.getString(node.getRoot().toLowerCase(), node.getDefault()).trim());
        } catch (NumberFormatException e) {
            main.getLogger().log(Level.SEVERE, "Could not get/read int for value: " + node.getRoot().toLowerCase());
            return 0;
        }
    }

    // Link

    public static String getLink() {
        return getString(ConfigNodes.LINK);
    }

    // Location

    public static String getDefaultLocationMap() {
        return getString(ConfigNodes.LOCATIONS_DEFAULT_MAP);
    }

    public static Integer getDefaultLocationZoom() {
        return getInt(ConfigNodes.LOCATIONS_DEFAULT_ZOOM);
    }

    public static List<String> getDisabledLocationWorlds() {
        String temp = getString(ConfigNodes.LOCATIONS_DISABLED_WORLDS);

        if (temp.contains(",")) {
            String[] tempStrings = temp.split(",");
            List<String> finalList = new ArrayList<>();
            Collections.addAll(finalList, tempStrings);

            return finalList;
        } else {
            return Collections.singletonList(temp);
        }
    }

    public static HashMap<String, String> getLocationWorldMapDefaults() {
        String temp = getString(ConfigNodes.LOCATIONS_DEFAULT_WORLD_MAPS);
        HashMap<String, String> finalMap = new HashMap<>();

        if (temp.contains(",")) {
            for (String group : temp.split(",")) {
                String[] values = group.split(":");
                finalMap.put(values[0], values[1]);
            }
        } else {
            String[] values = temp.split(":");
            finalMap.put(values[0], values[1]);
        }

        return finalMap;
    }

    public static HashMap<String, Integer> getLocationWorldZoomDefaults() {
        String temp = getString(ConfigNodes.LOCATIONS_DEFAULT_WORLD_ZOOMS);
        HashMap<String, Integer> finalMap = new HashMap<>();

        if (temp.contains(",")) {
            for (String group : temp.split(",")) {
                String[] values = group.split(":");
                finalMap.put(values[0], Integer.valueOf(values[1]));
            }
        } else {
            String[] values = temp.split(":");
            finalMap.put(values[0], Integer.valueOf(values[1]));
        }

        return finalMap;
    }

    // Worlds

    public static String getDefaultWorldMap() {
        return getString(ConfigNodes.WORLDS_DEFAULT_MAP);
    }

    public static Integer getDefaultWorldZoom() {
        return getInt(ConfigNodes.WORLDS_DEFAULT_ZOOM);
    }

    public static List<String> getDisabledWorldWorlds() {
        String temp = getString(ConfigNodes.WORLDS_DISABLED_WORLDS);

        if (temp.contains(",")) {
            String[] tempStrings = temp.split(",");
            List<String> finalList = new ArrayList<>();
            Collections.addAll(finalList, tempStrings);

            return finalList;
        } else {
            return Collections.singletonList(temp);
        }
    }

    public static HashMap<String, String> getWorldMapDefaults() {
        String temp = getString(ConfigNodes.WORLDS_DEFAULT_WORLD_MAPS);
        HashMap<String, String> finalMap = new HashMap<>();

        if (temp.contains(",")) {
            for (String group : temp.split(",")) {
                String[] values = group.split(":");
                finalMap.put(values[0], values[1]);
            }
        } else {
            String[] values = temp.split(":");
            finalMap.put(values[0], values[1]);
        }

        return finalMap;
    }

    public static HashMap<String, Integer> getWorldZoomDefaults() {
        String temp = getString(ConfigNodes.WORLDS_DEFAULT_WORLD_ZOOMS);
        HashMap<String, Integer> finalMap = new HashMap<>();

        if (temp.contains(",")) {
            for (String group : temp.split(",")) {
                String[] values = group.split(":");
                finalMap.put(values[0], Integer.valueOf(values[1]));
            }
        } else {
            String[] values = temp.split(":");
            finalMap.put(values[0], Integer.valueOf(values[1]));
        }

        return finalMap;
    }

    // Flat

    public static Integer getDefaultFlatZoom() {
        return getInt(ConfigNodes.FLAT_DEFAULT_ZOOM);
    }

    public static List<String> getDisabledFlatWorlds() {
        String temp = getString(ConfigNodes.FLAT_DISABLED_WORLDS);

        if (temp.contains(",")) {
            String[] tempStrings = temp.split(",");
            List<String> finalList = new ArrayList<>();
            Collections.addAll(finalList, tempStrings);

            return finalList;
        } else {
            return Collections.singletonList(temp);
        }
    }

    public static HashMap<String, Integer> getFlatWorldZoomDefaults() {
        String temp = getString(ConfigNodes.FLAT_DEFAULT_WORLD_ZOOMS);
        HashMap<String, Integer> finalMap = new HashMap<>();

        if (temp.contains(",")) {
            for (String group : temp.split(",")) {
                String[] values = group.split(":");
                finalMap.put(values[0], Integer.valueOf(values[1]));
            }
        } else {
            String[] values = temp.split(":");
            finalMap.put(values[0], Integer.valueOf(values[1]));
        }

        return finalMap;
    }

    // Surface

    public static Integer getDefaultSurfaceZoom() {
        return getInt(ConfigNodes.SURFACE_DEFAULT_ZOOM);
    }

    public static List<String> getDisabledSurfaceWorlds() {
        String temp = getString(ConfigNodes.SURFACE_DISABLED_WORLDS);

        if (temp.contains(",")) {
            String[] tempStrings = temp.split(",");
            List<String> finalList = new ArrayList<>();
            Collections.addAll(finalList, tempStrings);

            return finalList;
        } else {
            return Collections.singletonList(temp);
        }
    }

    public static HashMap<String, Integer> getSurfaceWorldZoomDefaults() {
        String temp = getString(ConfigNodes.SURFACE_DEFAULT_WORLD_ZOOMS);
        HashMap<String, Integer> finalMap = new HashMap<>();

        if (temp.contains(",")) {
            for (String group : temp.split(",")) {
                String[] values = group.split(":");
                finalMap.put(values[0], Integer.valueOf(values[1]));
            }
        } else {
            String[] values = temp.split(":");
            finalMap.put(values[0], Integer.valueOf(values[1]));
        }

        return finalMap;
    }

    // Cave

    public static Integer getDefaultCaveZoom() {
        return getInt(ConfigNodes.CAVE_DEFAULT_ZOOM);
    }

    public static List<String> getDisabledCaveWorlds() {
        String temp = getString(ConfigNodes.CAVE_DISABLED_WORLDS);

        if (temp.contains(",")) {
            String[] tempStrings = temp.split(",");
            List<String> finalList = new ArrayList<>();
            Collections.addAll(finalList, tempStrings);

            return finalList;
        } else {
            return Collections.singletonList(temp);
        }
    }

    public static HashMap<String, Integer> getCaveWorldZoomDefaults() {
        String temp = getString(ConfigNodes.CAVE_DEFAULT_WORLD_ZOOMS);
        HashMap<String, Integer> finalMap = new HashMap<>();

        if (temp.contains(",")) {
            for (String group : temp.split(",")) {
                String[] values = group.split(":");
                finalMap.put(values[0], Integer.valueOf(values[1]));
            }
        } else {
            String[] values = temp.split(":");
            finalMap.put(values[0], Integer.valueOf(values[1]));
        }

        return finalMap;
    }

    public static String getPrimaryColor() {
        return getString(ConfigNodes.COLORS_PRIMARY);
    }

    public static String getSecondaryColor() {
        return getString(ConfigNodes.COLORS_SECONDARY);
    }

    public static String getTextColor() {
        return getString(ConfigNodes.COLORS_TEXT);
    }

    public static String getLinkColor() {
        return getString(ConfigNodes.COLORS_LINK);
    }

    public static String getHoverColor() {
        return getString(ConfigNodes.COLORS_HOVER);
    }

    /*public static String getDBTablePrefix() {
        return getString(ConfigNodes.DATABASE_TABLE_PREFIX);
    }

    public static String getLoadDBType() {
        return getString(ConfigNodes.DATABASE_LOAD_TYPE).toLowerCase();
    }

    public static String getLoadDBHostname() {
        return getString(ConfigNodes.DATABASE_LOAD_HOSTNAME);
    }

    public static String getLoadDBPort() {
        return getString(ConfigNodes.DATABASE_LOAD_PORT);
    }

    public static String getLoadDBSchemaName() {
        return getString(ConfigNodes.DATABASE_LOAD_SCHEMA_NAME);
    }

    public static String getLoadDBUsername() {
        return getString(ConfigNodes.DATABASE_LOAD_USERNAME);
    }

    public static String getLoadDBPassword() {
        return getString(ConfigNodes.DATABASE_LOAD_PASSWORD);
    }

    public static String getSaveDBType() {
        return getString(ConfigNodes.DATABASE_SAVE_TYPE).toLowerCase();
    }

    public static String getSaveDBHostname() {
        return getString(ConfigNodes.DATABASE_SAVE_HOSTNAME);
    }

    public static String getSaveDBPort() {
        return getString(ConfigNodes.DATABASE_SAVE_PORT);
    }

    public static String getSaveDBSchemaName() {
        return getString(ConfigNodes.DATABASE_SAVE_SCHEMA_NAME);
    }

    public static String getSaveDBUsername() {
        return getString(ConfigNodes.DATABASE_SAVE_USERNAME);
    }

    public static String getSaveDBPassword() {
        return getString(ConfigNodes.DATABASE_SAVE_PASSWORD);
    }*/
}