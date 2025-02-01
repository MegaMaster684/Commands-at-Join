package megamaster684.commandsjoin.command;

// Импорт классов

import megamaster684.commandsjoin.CommandsJoin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CmdJoinCommand implements CommandExecutor {

    List<String> ListSetupText = List.of(
            "&7[&e&lCommands at Join&7] Инструкция по настройке плагина:",
            "",
            "&a&lИнструкция настройки &f&l(RUS)",
            "&e&oС начало перейдите по пути 'plugins/Commands_at_Join/config.yml' и откройте конфиг.",
            " &8| &71. Поставьте 'enable: true', чтобы включить нужные вам события.",
            " &8| &72. Выберите тип команды 'type: console' или 'type: player'",
            " &8| &73. Введите команды в 'command: ...', которые будут выполняться.",
            "&7----- &e----- &7----- &e----- &7----- &e----- &7----- &e----- &7-----",
            "&a&lSetup instructions &f&l(ENG)",
            "&e&oFirst go to 'plugins/Commands_at_Join/config.yml' and open the config.",
            " &8| &71. Set 'enable: true' to enable the events you want.",
            " &8| &72. Choose command type 'type: console' or 'type: player'",
            " &8| &73. Enter the commands in the 'command: ...' that will be executed."
    );

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            String CmdUsage = CommandsJoin.getInstance().getConfig().getString("messages.Usage");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CmdUsage)); // Заполнение цветов, если в нем есть символ &
            return true;
        }

        switch(args[0].toLowerCase()) {

            // Команда /cj reload

            case "reload": {
                if (!sender.hasPermission("cj.admin")) /* Проверка, если у игрока разрешение: cj.admin */ {
                    String perm = CommandsJoin.getInstance().getConfig().getString("messages.noPermission");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', perm));
                    return true;
                }
                String rel = CommandsJoin.getInstance().getConfig().getString("messages.pluginReload");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', rel));

                CommandsJoin.getInstance().reloadConfig();

                String completer = CommandsJoin.getInstance().getConfig().getString("messages.pluginCompleteReload");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', completer));
                return true;
                }

            // Команда /cj setup

            case "setup": {
                if (!sender.hasPermission("cj.admin")) /* Проверка, есть ли у игрока разрешение: cj.admin */ {
                    String perm = CommandsJoin.getInstance().getConfig().getString("messages.noPermission");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', perm));
                    return true;
                }

                for (String message : ListSetupText) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
            }
        }
        return false;
    }
}
