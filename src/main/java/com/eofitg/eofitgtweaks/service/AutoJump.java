package com.eofitg.eofitgtweaks.service;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;

public class AutoJump extends AbstractService{

    private static final String serviceName = "Auto Jump";

    private static final long jumpInterval = 60 * 1000;

    public AutoJump() {
        super(serviceName);
    }

    public static class RegularlyJumpThread extends Thread {

        public volatile boolean active = true;

        @Override
        public void run() {
            while(active) {
                if (isActive) {
                    playerJump();
                }
                try {
                    Thread.sleep(jumpInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    protected static void playerJump() {

        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

        player.jump();
        player.addChatMessage(new ChatComponentText("Jumped by \"" + AutoJump.isActive + "\""));

    }

}

