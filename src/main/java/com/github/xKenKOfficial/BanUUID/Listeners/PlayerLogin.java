package com.github.xKenKOfficial.BanUUID.Listeners;

import com.github.xKenKOfficial.BanUUID.Basic.Main;
import com.github.xKenKOfficial.BanUUID.Utils.ChatUtil;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.File;
import java.util.List;

public class PlayerLogin implements Listener
{
    @EventHandler
    public void onLogin(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        final File file = new File("plugins/" + Main.getPlugin().getName() + "/Banned-UUIDs/" + p.getUniqueId().toString() + ".yml");
        if(file.exists()) {
            final YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
            if (yml.getString("banuuid_type").equals("unlimited")) {
                final List<String> list = (List<String>)Main.getPlugin().getConfig().getStringList("banuuid_kick");
                String msg = "";
                for (int i = 0; i < list.size(); ++i) {
                    msg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(msg)))))) + list.get(i);
                    if (i <= list.size() - 2) {
                        msg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(msg)))))) + "{N}";
                    }
                }
                msg = msg.replace("&", "§");
                msg = msg.replace("{N}", "\n");
                msg = msg.replace("{POWOD}", yml.getString("reason"));
                msg = msg.replace("{ADMIN}", yml.getString("admin"));
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatUtil.fixColor(msg));
            }
        }
    }
}
