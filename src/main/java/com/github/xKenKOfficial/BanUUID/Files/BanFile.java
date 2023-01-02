package com.github.xKenKOfficial.BanUUID.Files;

import com.github.xKenKOfficial.BanUUID.Basic.Main;

import java.io.File;

public class BanFile
{
    private static BanFile banFile = new BanFile();

    public void setup() {
        final File file = new File("plugins/" + Main.getPlugin().getName() + "/Banned-UUIDs");
        if(!file.exists()) {
            file.mkdir();
        }
    }

    public static BanFile getDataFolder()
    {
        return banFile;
    }
}
