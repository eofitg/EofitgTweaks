package com.eofitg.eofitgtweaks.service;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;

public abstract class AbstractService {

    private boolean isActive;

    private final String serviceName;

    public AbstractService(String serviceName) {
        this.isActive = false;
        this.serviceName = serviceName;
    }

    protected void toggle() {
        this.isActive = !this.isActive;
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        player.addChatMessage(new ChatComponentText(this.serviceName + " toggled, now \"" + this.isActive + "\""));
    }

    protected boolean isActive() {
        return this.isActive;
    }

}
