package megamaster684.commandsjoin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import me.clip.placeholderapi.PlaceholderAPI;

// Импорт классов

public class EventListener implements Listener {


    // Событие "Заход игрока на сервер".
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (CommandsJoin.getInstance().getConfig().getBoolean("settings.cmd-join.enable")) { // Если "enable: true", то будет выполняться следующий код:
            if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-join.type").equals("console")) { // Если "type: console", то команда будет выполняться от стороны консоли.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-join.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды в консоль.
                }
            } else if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-join.type").equals("player")) { // Если "type: player", то команда будет выполняться от стороны игрока.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-join.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(e.getPlayer(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды от игрока.
                }
            }
        }
    }


    // Событие "Выход игрока из сервера".
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (CommandsJoin.getInstance().getConfig().getBoolean("settings.cmd-quit.enable")) { // Если "enable: true", то будет выполняться следующий код:
            if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-quit.type").equals("console")) { // Если "type: console", то команда будет выполняться от стороны консоли.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-quit.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды в консоль.
                }
            } else if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-quit.type").equals("player")) { // Если "type: player", то команда будет выполняться от стороны игрока.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-quit.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(e.getPlayer(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды от игрока.
                }
            }
        }
    }


    // Событие "Переход игрока в другой мир".
    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent e) {
        if (CommandsJoin.getInstance().getConfig().getBoolean("settings.cmd-change-world.enable")) { // Если "enable: true", то будет выполняться следующий код:
            if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-change-world.type").equals("console")) { // Если "type: console", то команда будет выполняться от стороны консоли.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-change-world.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды в консоль.
                }
            } else if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-change-world.type").equals("player")) { // Если "type: player", то команда будет выполняться от стороны игрока.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-change-world.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(e.getPlayer(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды от игрока.
                }
            }
        }
    }


    // Событие "Смерть игрока".
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (CommandsJoin.getInstance().getConfig().getBoolean("settings.cmd-death.enable")) { // Если "enable: true", то будет выполняться следующий код:
            if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-death.type").equals("console")) { // Если "type: console", то команда будет выполняться от стороны консоли.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-death.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), PlaceholderAPI.setPlaceholders(e.getEntity().getPlayer(), CmdJoin)); // Отправка полученной команды в консоль.
                }
            } else if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-death.type").equals("player")) { // Если "type: player", то команда будет выполняться от стороны игрока.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-death.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(e.getEntity().getPlayer(), PlaceholderAPI.setPlaceholders(e.getEntity().getPlayer(), CmdJoin)); // Отправка полученной команды от игрока.
                }
            }
        }
    }


    // Событие "Ломание блока".
    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        if (CommandsJoin.getInstance().getConfig().getBoolean("settings.cmd-break-block.enable")) { // Если "enable: true", то будет выполняться следующий код:
            if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-break-block.type").equals("console")) { // Если "type: console", то команда будет выполняться от стороны консоли.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-break-block.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды в консоль.
                }
            } else if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-break-block.type").equals("player")) { // Если "type: player", то команда будет выполняться от стороны игрока.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-break-block.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(e.getPlayer(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды от игрока.
                }
            }
        }
    }


    // Событие "Установка блока".
    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent e) {
        if (CommandsJoin.getInstance().getConfig().getBoolean("settings.cmd-place-block.enable")) { // Если "enable: true", то будет выполняться следующий код:
            if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-place-block.type").equals("console")) { // Если "type: console", то команда будет выполняться от стороны консоли.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-place-block.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды в консоль.
                }
            } else if (CommandsJoin.getInstance().getConfig().getString("settings.cmd-place-block.type").equals("player")) { // Если "type: player", то команда будет выполняться от стороны игрока.
                for (String CmdJoin : CommandsJoin.getInstance().getConfig().getStringList("settings.cmd-place-block.commands")) { // Импорт команды из config.yml
                    Bukkit.getServer().dispatchCommand(e.getPlayer(), PlaceholderAPI.setPlaceholders(e.getPlayer(), CmdJoin)); // Отправка полученной команды от игрока.
                }
            }
        }
    }
}
