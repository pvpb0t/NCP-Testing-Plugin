package me.pvpb0t.brogle;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public class PlayerEventListener implements Listener {
    // Detta är en fältvariabel för plugin-instansen.
    private final JavaPlugin plugin;
    // Konstruktorn tar emot en Brogle-instans som argument.
    public PlayerEventListener(Brogle plugin) {
        this.plugin = plugin;
    }

    // Denna metod körs när en spelare rör sig.
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // Spara spelaren som en fältvariabel.
        Player player = event.getPlayer();
        // Typomvandla plugin-instansen till Brogle.
        Brogle brogle = (Brogle) plugin;
        // Kontrollera om spelaren inte finns i listan över autentiserade spelare.
        if (!brogle.getAuthPlayers().contains(player)) {
            double x = brogle.getConfig().getDouble("x", 0);
            double y = brogle.getConfig().getDouble("y", 0);
            double z = brogle.getConfig().getDouble("z", 0);
            // Avbryt händelsen.

            Location lockpos = new Location(player.getWorld(), x, y, z);
            player.teleport(lockpos);
            event.setCancelled(true);
        }
    }
}


