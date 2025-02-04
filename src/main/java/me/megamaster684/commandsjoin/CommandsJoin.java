package me.megamaster684.commandsjoin;

import me.megamaster684.commandsjoin.command.CmdJoinCommand;
import me.megamaster684.commandsjoin.command.TabComplete;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandsJoin extends JavaPlugin implements Listener {

    private static CommandsJoin instance;

    // Включение сервера
    @Override
    public void onEnable()  {
        instance = this;

        saveDefaultConfig(); // При включении сервера, будет создаваться файл config.yml

        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        getCommand("cj").setExecutor(new CmdJoinCommand());
        getCommand("cj").setTabCompleter(new TabComplete());
    }

    // Выключение сервера
    @Override
    public void onDisable() {
        // Тут ничего нет
    }

    public static CommandsJoin getInstance() {
        return instance;
    }
}
