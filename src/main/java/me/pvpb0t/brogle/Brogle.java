package me.pvpb0t.brogle;

import fr.neatmonster.nocheatplus.NCPAPIProvider;
import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.components.NoCheatPlusAPI;
import fr.neatmonster.nocheatplus.hooks.NCPHookManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public final class Brogle extends JavaPlugin implements CommandExecutor {
        @Override
        public void onEnable() {
            // Plugin-startlogik
            System.out.println("Started brogle");
            getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
            getServer().getPluginManager().registerEvents(new PlayerEventListener(this), this);
            // Registrera lösenordkommandot
            PluginCommand passwordCommand = getCommand("password");
            passwordCommand.setExecutor(this);
            passwordCommand.setTabCompleter(this);

            PluginCommand LockPos = getCommand("setLockPos");
            LockPos.setExecutor(this);
            LockPos.setTabCompleter(this);

            NoCheatPlusAPI api = NCPAPIProvider.getNoCheatPlusAPI();
            NCPHookManager.addHook(CheckType.ALL,new NCPHandler(this));
            // Skapa pluginens data-mapp om den inte redan finns
            if (!getDataFolder().exists()) {
                getDataFolder().mkdir();
            }
            // Skapa konfigurationsfilen om den inte redan finns
            File configFile = new File(getDataFolder(), "config.yml");
            if (!configFile.exists()) {
                saveDefaultConfig();
            }
        }
        // Denna metod ger tillgång till en lista med autentiserade spelare.
        public Set<Player> getAuthPlayers() {
            return authPlayers;
        }
        // Detta är en lista över autentiserade spelare.
        private Set<Player> authPlayers = new HashSet<>();
        // Denna metod hanterar kommandon som skickas till pluginen.
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            }
            Player player = (Player) sender;
            // Om kommandot är "password"
            if (command.getName().equalsIgnoreCase("password")) {
                // Kontrollera om avsändaren är en spelare.
                    // Kontrollera om spelaren finns i listan över spelare som måste autentisera.
                    if (!authPlayers.contains(player)) {
                        String configPassword = this.getConfig().getString("password", "1234");
                        // Kontrollera om lösenordet är korrekt.
                        if (args.length > 0 && args[0].equals(configPassword)) {
                            // Ta bort spelaren från listan över spelare som måste autentisera.
                            authPlayers.add(player);
                            // Skicka ett meddelande till spelaren som bekräftar att autentiseringen lyckades.
                        player.sendMessage("You have authenticated successfully.");
                    } else {
                        // Send an error message to the player
                        player.sendMessage("Incorrect password. Please try again.");
                    }
                } else {
                    // Send an error message to the player
                    player.sendMessage("You do not need to authenticate.");
                }
            return true;
        }else if(command.getName().equalsIgnoreCase("setLockPos")){
                if(player.isOp()){
                    Location playerLocation = player.getLocation();
                    double x = playerLocation.getX();
                    double y = playerLocation.getY();
                    double z = playerLocation.getZ();

                    // Store the position in the configuration file
                    this.getConfig().set("x", x);
                    this.getConfig().set("y", y);
                    this.getConfig().set("z", z);
                    this.saveConfig();
                    player.sendMessage("Location has been saved to the configuration file");

                }else{
                    player.sendMessage("You do not have the required permissions to use this command");

                }
            }
        return false;
    }

    // Denna metod lägger till en spelare i listan över autentiserade spelare.
    public void addAuthPlayers(Player player) {
        authPlayers.add(player);
    }

    // När pluginen stängs av körs den här metoden.
    @Override
    public void onDisable() {
// Plugin-avstängningslogik
    }
}
