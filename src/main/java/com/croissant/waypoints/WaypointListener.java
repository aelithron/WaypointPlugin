package com.croissant.waypoints;

import org.bukkit.event.Listener;

public class WaypointListener implements Listener {
    private Waypoints plugin;
    public WaypointListener(Waypoints plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void waypointsPlace(BlockPlaceEvent e) {
    e.getPlayer().sendMessage("Block place successful :)");
    plugin.waypointStore.set()
    
    }
}
