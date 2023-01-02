package com.github.xKenKOfficial.BanUUID.Commands;

import com.github.xKenKOfficial.BanUUID.Apis.API;
import com.github.xKenKOfficial.BanUUID.Basic.Main;
import com.github.xKenKOfficial.BanUUID.Utils.ChatUtil;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnBanUUIDCommand implements CommandExecutor
{
    private static final String NO_PERMISSION = Main.getPlugin().getConfig().getString("no_permission");
    private static final String WRONG_ARGS = Main.getPlugin().getConfig().getString("wrong_args");

    private static final String COMMAND_USAGE = Main.getPlugin().getConfig().getString("unbanuuid_command_usage");
    private static final String REMOVE_PLAYER = Main.getPlugin().getConfig().getString("unbanuuid_remove_player");

    @Override
    public boolean onCommand(final CommandSender Sender, final Command c, final String l, final String[] args) {
        if(!Sender.hasPermission("xkenbanuuid.admin.unbanuuid")) {
            Sender.sendMessage(ChatUtil.fixColor(NO_PERMISSION));
            return false;
        }
        if(args.length < 1) {
            Sender.sendMessage(ChatUtil.fixColor(COMMAND_USAGE));
            return false;
        } else if(args.length == 1) {
            final String nick = args[0];
            final OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(nick);
            API.removeUser(offlinePlayer.getUniqueId().toString());
            Sender.sendMessage(ChatUtil.fixColor(REMOVE_PLAYER.replace("{GRACZ}", offlinePlayer.getName())));
            return false;
        } else {
            Sender.sendMessage(ChatUtil.fixColor(WRONG_ARGS));
        }
        return false;
    }
}
