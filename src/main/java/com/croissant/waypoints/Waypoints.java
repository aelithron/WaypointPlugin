package com.croissant.waypoints;

import org.bukkit.plugin.java.JavaPlugin;

public final class Waypoints extends JavaPlugin {
    // Files
    YamlConfiguration waypointStore;
    // Actual "File" objects (used for reloading)
    private File waypointStoreFile;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new WaypointListener(this), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Data Storage
        waypointStoreFile = new File(getDataFolder(), "waypoints.yml");
        if (!waypointStoreFile.exists()) {
            saveResource("waypoints.yml", false);
        }
        reloadDataStore();
        CoreTools.getInstance().setPlugin(this); // Extra initialization
        CoreTools.getInstance().checkForUpdates();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    
    public void reloadDataStore() {
        dataStore = YamlConfiguration.loadConfiguration(waypointStoreFile);
    }

    public void saveDataStore() {
        try {
            dataStore.save(new File(getDataFolder(), "waypoints.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
