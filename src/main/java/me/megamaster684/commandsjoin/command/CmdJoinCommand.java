package me.megamaster684.commandsjoin.command;

import me.megamaster684.commandsjoin.CommandsJoin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.util.Arrays;
import java.util.List;

public class CmdJoinCommand implements CommandExecutor {

    List<String> ListSetupText = Arrays.asList(
            "&e&lИнструкция настройки &f(RUS)",
            " 1. Перейдите по пути&b plugins/Commands-at-Join/config.yml&f и откройте конфиг",
            " 2. Поставьте&b enable: true&f, чтобы включить нужные вам события",
            " 3. Выберите тип команды&b type: console&f или&b type: player",
            " 4. Введите команды в&b commands: ...&f, которые будут выполняться",
            " 5. Используйте команду &b/cj reload&f чтобы изменения вступили в силу",
            "&7----- &e----- &7----- &e----- &7----- &e----- &7----- &e----- &7-----",
            "&e&lSetup instructions &f(ENG)",
            " 1. Go to&b plugins/Commands-at-Join/config.yml&f and open the config",
            " 2. Set&b enable: true&f to enable the events you want",
            " 3. Choose command type&b type: console&f or&b type: player",
            " 4. Enter the commands in the&b commands: ...&f that will be executed",
            " 5. Use the &b/cj reload&f command to make the changes take effect"
    );

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            String CmdUsage = CommandsJoin.getInstance().getConfig().getString("messages.commandsList");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CmdUsage)); // Заполнение цветов, если в нем есть символ &
            return true;
        }

        switch(args[0].toLowerCase()) {

            // Команда /cj reload
            case "reload": {
                // Проверка, если у игрока разрешение: cj.admin
                if (!sender.hasPermission("cj.admin")) {
                    String perm = CommandsJoin.getInstance().getConfig().getString("messages.noPermission");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', perm));
                    return true;
                }
                CommandsJoin.getInstance().reloadConfig();

                String completer = CommandsJoin.getInstance().getConfig().getString("messages.reloadPlugin");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', completer));
                return true;
                }

            // Команда /cj setup
            case "setup": {
                // Проверка, есть ли у игрока разрешение: cj.admin
                if (!sender.hasPermission("cj.admin")) {
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
