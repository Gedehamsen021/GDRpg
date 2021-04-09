package me.gdrpg;

import me.gdcore.listeners.PlayerRpgData;
import me.gdrpg.commands.CreateItem;
import me.gdrpg.commands.Teste;
import me.gdrpg.events.PlayerEvents;
import me.gdrpg.utils.PvPTag;
import me.gdrpg.utils.VerifyArmor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class Main extends JavaPlugin {

    private static Main instance;
    public String pluginTag = "§9 GDESSENTIALS §f";
    public String pluginDeny = "§c ERRO §f";

    VerifyArmor ver = new VerifyArmor();

    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
        registerListeners();

        /*
        LIFECHECK
         */
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
            @Override
            public void run() {
                for (UUID p : PlayerRpgData.datas.keySet()) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        PlayerRpgData status = PlayerRpgData.datas.get(p);
                        if (PlayerRpgData.datas.get(p).isPlayerChanges()) {
                            player.setExp(status.getPlayerHP() / (float) status.getPlayerMAXHP());
                            player.setLevel(status.getPlayerHP());
                            if(status.getPlayerHP() > status.getPlayerMAXHP()) {
                                status.setPlayerHP(status.getPlayerMAXHP());
                            }
                        }
                    }
                }
            }
        }, 0, 5L);

        /*
        PVPTAGS
         */
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (PvPTag.tags.containsKey(p)) {
                        PvPTag.tags.replace(p, PvPTag.tags.get(p) - 1);
                        if (PvPTag.tags.get(p) == 0) {
                            PvPTag.tags.remove(p);
                        }
                    }
                }
            }
        }, 0, 20L);

        /*
        HPREGEN
         */
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!PvPTag.tags.containsKey(p)) {
                        if(PlayerRpgData.datas.get(p.getUniqueId()).getPlayerHP() < PlayerRpgData.datas.get(p.getUniqueId()).getPlayerMAXHP()) {
                                PlayerRpgData.datas.get(p.getUniqueId()).setPlayerHP(PlayerRpgData.datas.get(p.getUniqueId()).getPlayerHP() + PlayerRpgData.datas.get(p.getUniqueId()).getPlayerHPREGEN());
                        }
                    }
                }
            }
        }, 0, 20L);
    }

    public void registerCommands() {
        getCommand("create").setExecutor(new CreateItem());
        getCommand("teste").setExecutor(new Teste());
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getServer().getPluginManager().registerEvents(new VerifyArmor(), this);
    }

    public static Main getInstance() {
        return instance;
    }
}
