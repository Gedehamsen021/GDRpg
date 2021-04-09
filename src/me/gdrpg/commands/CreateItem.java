package me.gdrpg.commands;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import me.gdcore.utils.PlayerPermissions;
import me.gdcore.utils.Utils;
import me.gdrpg.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateItem implements CommandExecutor {

    PlayerPermissions perms = new PlayerPermissions();


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (perms.getPerms(p.getPlayer()) < 60) {
                p.sendMessage(Main.getInstance().pluginDeny + "Seu cargo não permite executar este comando");
                return false;
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("sword")) {
                    if (Utils.isInt(args[1], sender)) {
                        ItemStack sword = new ItemStack(Material.DIAMOND_HELMET, 1);
                        NBTItem nbti = new NBTItem(sword);
                        nbti.setInteger("MAXHP", Integer.parseInt(args[1]));
                        nbti.setInteger("HPREGEN", Integer.parseInt(args[2]));
                        NBTCompound disp = nbti.addCompound("display");
                        if (nbti.getInteger("MAXHP") > 100) {
                            disp.setString("Name", "LENDARIO" + sword.getData().getItemType().name());
                        }
                        List<String> l = disp.getStringList("Lore");
                        l.add("MAXHP: " + nbti.getInteger("MAXHP"));
                        l.add("HPREGEN: " + nbti.getInteger("HPREGEN"));
                        sword = nbti.getItem();
                        ((Player) sender).getInventory().addItem(sword);
                        System.out.println(nbti);
                    }
                } else if (args[0].equalsIgnoreCase("armor")) {
                    ItemStack sword = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                    NBTItem nbti = new NBTItem(sword);
                    nbti.setInteger("MAXHP", Integer.parseInt(args[1]));
                    nbti.setInteger("HPREGEN", Integer.parseInt(args[2]));
                    NBTCompound disp = nbti.addCompound("display");
                    if (nbti.getInteger("MAXHP") > 100) {
                        disp.setString("Name", "LENDARIO" + sword.getData().getItemType().name());
                    }
                    List<String> l = disp.getStringList("Lore");
                    l.add("MAXHP: " + nbti.getInteger("MAXHP"));
                    l.add("HPREGEN: " + nbti.getInteger("HPREGEN"));
                    sword = nbti.getItem();
                    ((Player) sender).getInventory().addItem(sword);
                    System.out.println(nbti);
                } else if (args[0].equalsIgnoreCase("calca")) {
                    ItemStack sword = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
                    NBTItem nbti = new NBTItem(sword);
                    nbti.setInteger("MAXHP", Integer.parseInt(args[1]));
                    nbti.setInteger("HPREGEN", Integer.parseInt(args[2]));
                    NBTCompound disp = nbti.addCompound("display");
                    if (nbti.getInteger("MAXHP") > 100) {
                        disp.setString("Name", "LENDARIO" + sword.getData().getItemType().name());
                    }
                    List<String> l = disp.getStringList("Lore");
                    l.add("MAXHP: " + nbti.getInteger("MAXHP"));
                    l.add("HPREGEN: " + nbti.getInteger("HPREGEN"));
                    sword = nbti.getItem();
                    ((Player) sender).getInventory().addItem(sword);
                    System.out.println(nbti);
                } else if (args[0].equalsIgnoreCase("botas")) {
                    ItemStack sword = new ItemStack(Material.DIAMOND_BOOTS, 1);
                    NBTItem nbti = new NBTItem(sword);
                    nbti.setInteger("MAXHP", Integer.parseInt(args[1]));
                    nbti.setInteger("HPREGEN", Integer.parseInt(args[2]));
                    NBTCompound disp = nbti.addCompound("display");
                    if (nbti.getInteger("MAXHP") > 100) {
                        disp.setString("Name", "LENDARIO" + sword.getData().getItemType().name());
                    }
                    List<String> l = disp.getStringList("Lore");
                    l.add("MAXHP: " + nbti.getInteger("MAXHP"));
                    l.add("HPREGEN: " + nbti.getInteger("HPREGEN"));
                    sword = nbti.getItem();
                    ((Player) sender).getInventory().addItem(sword);
                    System.out.println(nbti);
                }
            }
        } else {
            sender.sendMessage(Main.getInstance().pluginDeny + "Comando apenas para jogadores");
        }
        return false;
    }
}
