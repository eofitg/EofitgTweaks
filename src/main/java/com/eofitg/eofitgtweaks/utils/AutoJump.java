package com.eofitg.eofitgtweaks.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoJump {

    public static boolean isActive = false;
    public static long jumpInterval = 60 * 1000;

    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {

        if (!isActive) {
            return;
        }

        playerJump();

    }

    public static class RegularlyJumpThread extends Thread {

        @Override
        public void run() {

            while(true) {
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

