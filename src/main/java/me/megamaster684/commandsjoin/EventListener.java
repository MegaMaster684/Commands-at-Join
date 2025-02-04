package me.megamaster684.commandsjoin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import me.clip.placeholderapi.PlaceholderAPI;

public class EventListener implements Listener {
    public boolean checkParamEnabled(String param) {
        return CommandsJoin.getInstance().getConfig().getBoolean("events." + param + ".enable");
    }

    public boolean checkParamType(String param) {
        return CommandsJoin.getInstance().getConfig().getString("events." + param + ".type").equals("console");
    }

    public boolean checkPlaceholderAPI() {
        return Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
    }

    public void dispatchCommand(String param, Player player) {
        if (checkParamEnabled(param)) {
            for (String Cmd : CommandsJoin.getInstance().getConfig().getStringList("events." + param + ".commands")) {
                if (checkParamType(param)) {
                    if (checkPlaceholderAPI()) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), PlaceholderAPI.setPlaceholders(player, Cmd));
                    } else {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), Cmd);
                    }
                } else {
                    if (checkPlaceholderAPI()) {
                        Bukkit.getServer().dispatchCommand(player, PlaceholderAPI.setPlaceholders(player, Cmd));
                    } else {
                        Bukkit.getServer().dispatchCommand(player, Cmd);
                    }
                }
            }
        }
    }


    // Событие "Заход игрока на сервер".
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        dispatchCommand("join", player);
    }


    // Событие "Выход игрока из сервера".
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        dispatchCommand("quit", player);
    }


    // Событие "Переход игрока в другой мир".
    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        dispatchCommand("change-world", player);
    }


    // Событие "Смерть игрока".
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        dispatchCommand("death", player);
    }


    // Событие "Ломание блока".
    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        dispatchCommand("break-block", player);
    }


    // Событие "Установка блока".
    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        dispatchCommand("place-block", player);
    }

    // Событие "Клик по другому игроку".
    @EventHandler
    public void onPlayerClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getRightClicked() instanceof Player) {
            if(event.getHand().equals(EquipmentSlot.HAND)) {
                dispatchCommand("player-click", player);
            }
        }
    }
}
