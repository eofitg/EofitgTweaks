package com.eofitg.eofitgtweaks.utils;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoJump {

    public static boolean isActive = false;
    public static long jumpInterval = 60;

    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        if (!isActive) {
            return;
        }
        Minecraft.getMinecraft().thePlayer.jump();
    }

}
