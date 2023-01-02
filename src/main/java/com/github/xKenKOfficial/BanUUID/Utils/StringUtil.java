package com.github.xKenKOfficial.BanUUID.Utils;

public class StringUtil
{
    public static String stringBuilder(final String[] args, final int liczOdArgumentu) {
        String msg = "";
        for (int i = liczOdArgumentu; i < args.length; ++i) {
            msg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(msg))))))) + args[i];
            if (i <= args.length - 2) {
                msg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(msg))))))) + " ";
            }
        }
        return msg;
    }
}
