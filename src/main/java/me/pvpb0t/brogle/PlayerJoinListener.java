package me.pvpb0t.brogle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // This method will be called every time a player joins the server
        event.getPlayer().sendMessage("Please enter a password using the '/password <password>' command.");
    }
}
