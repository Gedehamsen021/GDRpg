package me.gdrpg.utils;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import de.tr7zw.nbtapi.NBTItem;
import me.gdcore.listeners.PlayerRpgData;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class VerifyArmor implements Listener {

    @EventHandler
    public void verifyPlayer(ArmorEquipEvent e) {
        if (!PvPTag.tags.containsKey(e.getPlayer())) {
            if (e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR) {
                PlayerRpgData status = PlayerRpgData.datas.get(e.getPlayer().getUniqueId());
                NBTItem chest = new NBTItem(e.getNewArmorPiece());
                int hp = chest.getInteger("MAXHP");
                int regen = chest.getInteger("HPREGEN");
                status.setPlayerHPREGEN(status.getPlayerHPREGEN() + regen);
                status.setPlayerMAXHP(status.getPlayerMAXHP() + hp);
            }
            if (e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR) {
                PlayerRpgData status = PlayerRpgData.datas.get(e.getPlayer().getUniqueId());
                NBTItem chest = new NBTItem(e.getOldArmorPiece());
                int hp = chest.getInteger("MAXHP");
                int regen = chest.getInteger("HPREGEN");
                status.setPlayerHPREGEN(status.getPlayerHPREGEN() - regen);
                status.setPlayerMAXHP(status.getPlayerMAXHP() - hp);
            }
        } else {
            e.setCancelled(true);
        }
    }
}


