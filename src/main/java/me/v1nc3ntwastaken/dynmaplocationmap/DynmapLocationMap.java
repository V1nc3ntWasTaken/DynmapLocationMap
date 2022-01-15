package me.v1nc3ntwastaken.dynmaplocationmap;

import me.v1nc3ntwastaken.dynmaplocationmap.commands.MapAdminCommand;
import me.v1nc3ntwastaken.dynmaplocationmap.commands.MapCommand;
import me.v1nc3ntwastaken.dynmaplocationmap.config.ConfigurationHandler;
import me.v1nc3ntwastaken.dynmaplocationmap.config.FileMgmt;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

public final class DynmapLocationMap extends JavaPlugin {
    private String version;

    @Override
    public void onEnable() {
        // Plugin startup logic

        Objects.requireNonNull(getCommand("map")).setExecutor(new MapCommand());
        Objects.requireNonNull(getCommand("mapadmin")).setExecutor(new MapAdminCommand());

        version = this.getDescription().getVersion();
        FileMgmt.initialize(this);
        ConfigurationHandler.initialize(this);
        // We need a configuration
        if (!ConfigurationHandler.loadSettings()) {
            getLogger().log(Level.SEVERE, "Configuration could not be loaded, disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
    }

    public String getRootFolder() {
        return this.getDataFolder().getPath();
    }

    public String getVersion() {
        return version;
    }

    @Override
    public void onDisable() {

    }
}
