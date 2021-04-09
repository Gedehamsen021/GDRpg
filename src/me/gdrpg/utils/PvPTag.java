package me.gdrpg.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class PvPTag implements Listener {

    public static HashMap<Player,Integer> tags = new HashMap<>();

    @EventHandler
    public void tag(EntityDamageByEntityEvent e) {
        Player p = (Player) e.getEntity();
        Player v = (Player) e.getDamager();

        if(!tags.containsKey(p) || !tags.containsKey(v)) {
            tags.put(p,10);
            tags.put(v,10);
        } else {
            tags.replace(p,10);
            tags.replace(p,10);
        }
    }
}
