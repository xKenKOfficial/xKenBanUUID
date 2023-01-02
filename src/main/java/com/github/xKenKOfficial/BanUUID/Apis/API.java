package com.github.xKenKOfficial.BanUUID.Apis;

import com.github.xKenKOfficial.BanUUID.Basic.Main;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class API
{
    public static void addUserPerm(String uuid, String admin, String reason) {
        final File file = new File("plugins/" + Main.getPlugin().getName() + "/Banned-UUIDs/" + uuid + ".yml");
        final YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        yamlConfiguration.set("banuuid_type", "unlimited");
        yamlConfiguration.set("admin", admin);
        yamlConfiguration.set("reason", reason);
        try {
            yamlConfiguration.save(file);
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void addUserTime(String uuid, String admin, String reason, long time) {
        final File file = new File("plugins/" + Main.getPlugin().getName() + "/Banned-UUIDs/" + uuid + ".yml");
        final YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        yamlConfiguration.set("banuuid_type", "timer");
        yamlConfiguration.set("admin", admin);
        yamlConfiguration.set("reason", reason);
        yamlConfiguration.set("time", time);
        try {
            yamlConfiguration.save(file);
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void removeUser(String uuid) {
        final File file = new File("plugins/" + Main.getPlugin().getName() + "/Banned-UUIDs/" + uuid + ".yml");
        file.delete();
    }

    public static String getBlacklistUser(String uuid) {
        final File file = new File("plugins/" + Main.getPlugin().getName() + "/Banned-UUIDs/" + uuid + ".yml");
        if(file.exists()) {
            final YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
            String msg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(yamlConfiguration.getString("banuuid_type"))))))) + ";" + yamlConfiguration.getString("admin") + ";" + yamlConfiguration.getString("reason") + ";" + yamlConfiguration.getLong("time");
        }
        return null;
    }
}
