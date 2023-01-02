package com.github.xKenKOfficial.BanUUID.Basic;

import com.github.xKenKOfficial.BanUUID.Commands.BanUUIDCommand;
import com.github.xKenKOfficial.BanUUID.Commands.UnBanUUIDCommand;
import com.github.xKenKOfficial.BanUUID.Files.BanFile;
import com.github.xKenKOfficial.BanUUID.Listeners.PlayerJoin;
import com.github.xKenKOfficial.BanUUID.Listeners.PlayerLogin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin
{
    private static Main plugin;

    public void onEnable()
    {
        (plugin) = this;
        this.saveDefaultConfig();
        this.registerCommands();
        this.registerListeners();
        this.registerFiles();
        System.out.println("###########################################################");
        System.out.println(this.getName());
        System.out.println("Wersja: " + this.getDescription().getVersion());
        System.out.println("Wykryta wersja Bukkit: " + Bukkit.getBukkitVersion());
        System.out.println(this.isEnabled() ? "Aktywowany" : "Dezaktywowany");
        System.out.println("Jakiekolwiek edycje i naruszenie praw autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    public void onDisable()
    {
        this.saveDefaultConfig();
        this.saveFiles();
        System.out.println("###########################################################");
        System.out.println(this.getName());
        System.out.println("Wersja: " + this.getDescription().getVersion());
        System.out.println("Wykryta wersja Bukkit: " + Bukkit.getBukkitVersion());
        System.out.println(this.isEnabled() ? "Aktywowany" : "Dezaktywowany");
        System.out.println("Jakiekolwiek edycje i naruszenie praw autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    private void registerCommands()
    {
        this.getLogger().info("Ladowanie komend z pluginu: " + this.getName());
        this.getCommand("ban-uuid").setExecutor(new BanUUIDCommand());
        this.getCommand("unban-uuid").setExecutor(new UnBanUUIDCommand());
    }

    private void registerListeners()
    {
        this.getLogger().info("Ladowanie eventow z pluginu: " + this.getName());
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerJoin(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerLogin(), (Plugin)this);
    }

    private void registerFiles()
    {
        this.getLogger().info("Ladowanie plikow konfiguracyjnych z pluginu: " + this.getName());
        BanFile.getDataFolder().setup();
    }

    private void saveFiles()
    {
        this.getLogger().info("Zapisywanie plikow konfiguracyjnych z pluginu: " + this.getName());
    }

    public static Main getPlugin()
    {
        return plugin;
    }
}
