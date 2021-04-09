package me.gdrpg.events;

import me.gdcore.listeners.PlayerRpgData;
import me.gdrpg.utils.PvPTag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerEvents implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        PlayerRpgData status = PlayerRpgData.datas.get(e.getPlayer().getUniqueId());
        e.getPlayer().setLevel(status.getPlayerHP());
        e.getPlayer().setExp(status.getPlayerHP()/(float)status.getPlayerMAXHP());
    }
}
