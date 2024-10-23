package com.eofitg.eofitgtweaks.service;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;

public abstract class AbstractService {

    protected static boolean isActive;

    private static String ServiceName;

    public AbstractService(String serviceName) {
        isActive = false;
        ServiceName = serviceName;
    }

    public static void toggle() {
        isActive = !isActive;
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        player.addChatMessage(new ChatComponentText(ServiceName + " toggled, now \"" + isActive + "\""));
    }

}
