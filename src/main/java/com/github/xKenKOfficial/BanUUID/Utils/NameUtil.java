package com.github.xKenKOfficial.BanUUID.Utils;

public class NameUtil
{
    public static String fixColor(final String msg) {
        return msg.replaceAll("&", "§").replace(">>", "»").replace("<<", "«").replace("{N}", "\n").replace("_", " ");
    }
}
