package megamaster684.commandsjoin;

// Импорт классов

import megamaster684.commandsjoin.command.CmdJoinCommand;
import megamaster684.commandsjoin.command.TabComplete;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandsJoin extends JavaPlugin implements Listener {

    private static CommandsJoin instance;

    @Override
    public void onEnable() /* Включение сервера */ {
        instance = this;

        saveDefaultConfig(); // При включении сервера, будет создаваться файл config.yml
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        getCommand("cj").setExecutor(new CmdJoinCommand());
        getCommand("cj").setTabCompleter(new TabComplete());
    }

    @Override
    public void onDisable() /* Выключение сервера */{
        // Тут ничего нет
    }

    public static CommandsJoin getInstance() {
        return instance;
    }
}
