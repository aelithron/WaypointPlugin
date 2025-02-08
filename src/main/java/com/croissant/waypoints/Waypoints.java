package com.croissant.waypoints;

import org.bukkit.plugin.java.JavaPlugin;

public final class Waypoints extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new WaypointListener(this), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        CoreTools.getInstance().setPlugin(this); // Extra initialization
        CoreTools.getInstance().checkForUpdates();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
