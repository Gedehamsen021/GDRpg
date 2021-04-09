package me.gdrpg.commands;

import me.gdcore.listeners.PlayerRpgData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teste implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        String playerName = args[0];
        Player playerTarget = Bukkit.getPlayer(playerName);

        PlayerRpgData.datas.get(playerTarget.getUniqueId()).setPlayerHP(Integer.parseInt(args[1]));

        return false;
    }
}
