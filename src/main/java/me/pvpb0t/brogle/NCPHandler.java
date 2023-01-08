package me.pvpb0t.brogle;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.checks.access.IViolationInfo;
import fr.neatmonster.nocheatplus.hooks.NCPHook;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

// Detta är en klass som implementerar NCPHook-gränssnittet. 😎
public class NCPHandler implements NCPHook {
    // Konstruktorn tar emot en JavaPlugin-instans som argument. 🤔
    public NCPHandler(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    // Denna metod returnerar namnet på hooken. 🌟
    @Override
    public String getHookName() {
        return "BrogleHook";
    }
    // Detta är en fältvariabel för plugin-instansen. 😎
    private final JavaPlugin plugin;

    // Denna metod returnerar versionen av hooken. 🌟
    @Override
    public String getHookVersion() {
        return "1.0";
    }

    // Denna metod körs när en kontroll misslyckas. 😢
    @Override
    public boolean onCheckFailure(CheckType checkType, Player player, IViolationInfo iViolationInfo) {
        // Skapa ett felmeddelande med spelarens namn och typen av kontroll som misslyckades. 😵
        String message = String.format("%s failed check %s", player.getName(), checkType);
        // Typomvandla plugin-instansen till Brogle. 🤔
        Brogle brogle = (Brogle) plugin;
        // Kontrollera om spelaren finns i listan över autentiserade spelare. 😎
        if (brogle.getAuthPlayers().contains(player)) {
            // Skicka felmeddelandet till spelaren. 😬
            player.sendMessage(message);
        }
        // Returnera false för att indikera att kontrollen misslyckades. 💔
        return false;
    }
}


