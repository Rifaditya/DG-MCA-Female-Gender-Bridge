package net.conczin.mca;

import net.minecraft.resources.Identifier;

public class MCA {
    public static boolean isBlankString(String str) {
        return str == null || str.isBlank();
    }

    public static Identifier locate(String path) {
        return Identifier.fromNamespaceAndPath("mca", path);
    }
}
