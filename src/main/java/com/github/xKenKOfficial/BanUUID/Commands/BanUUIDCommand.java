package com.github.xKenKOfficial.BanUUID.Commands;

import com.github.xKenKOfficial.BanUUID.Apis.API;
import com.github.xKenKOfficial.BanUUID.Basic.Main;
import com.github.xKenKOfficial.BanUUID.Utils.ChatUtil;
import com.github.xKenKOfficial.BanUUID.Utils.StringUtil;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class BanUUIDCommand implements CommandExecutor
{
    private static final String NO_PERMISSION = Main.getPlugin().getConfig().getString("no_permission");

    private static final String COMMAND_USAGE = Main.getPlugin().getConfig().getString("banuuid_command_usage");
    private static final String ADD_PLAYER_BLACKLIST = Main.getPlugin().getConfig().getString("banuuid_add_player");

    @Override
    public boolean onCommand(final CommandSender Sender, final Command c, final String l, final String[] args) {
        if(!Sender.hasPermission("xkenbanuuid.admin.banuuid")) {
            Sender.sendMessage(ChatUtil.fixColor(NO_PERMISSION));
            return false;
        }
        if(args.length >= 2) {
            final String nick = args[0];
            final OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(nick);
            final String reason = StringUtil.stringBuilder(args, 1);
            API.addUserPerm(offlinePlayer.getUniqueId().toString(), Sender.getName(), reason);
            if(offlinePlayer.isOnline()) {
                final List<String> kickReason = Main.getPlugin().getConfig().getStringList("banuuid_kick");
                String msg = "";
                for (int i = 0; i < kickReason.size(); ++i) {
                    msg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(msg)))))) + kickReason.get(i);
                    if (i <= kickReason.size() - 2) {
                        msg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(msg)))))) + "{N}";
                    }
                }
                msg = msg.replace("&", "§");
                msg = msg.replace("{N}", "\n");
                msg = msg.replace("{POWOD}", reason);
                msg = msg.replace("{GRACZ}", offlinePlayer.getName());
                msg = msg.replace("{ADMIN}", Sender.getName());
                //((Player)offlinePlayer).kickPlayer(ChatUtil.fixColor(msg));
                offlinePlayer.getPlayer().kickPlayer(ChatUtil.fixColor(msg));
            }
            Sender.sendMessage(ChatUtil.fixColor(ADD_PLAYER_BLACKLIST.replace("{GRACZ}", offlinePlayer.getName())));
        } else {
            Sender.sendMessage(ChatUtil.fixColor(COMMAND_USAGE));
        }
        return false;
    }
}
