package com.eofitg.eofitgtweaks.service;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractService {

    private boolean isActive;

    private final String serviceName;

    public AbstractService(String serviceName) {
        this.isActive = false;
        this.serviceName = serviceName;
    }

    // Toggle this service (true | false)
    protected void toggle() {
        this.isActive = !this.isActive;
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        player.addChatMessage(new ChatComponentText("\"" + this.serviceName + "\" toggled to \"" + this.isActive + "\""));
    }

    protected boolean isActive() {
        return this.isActive;
    }

    // Tap a button in the player's way
    // = Hold down a button for a while(hold) and then lift it up
    protected void pressKey(KeyBinding key, int hold) {

        Minecraft minecraft = Minecraft.getMinecraft();
        EntityPlayerSP player = minecraft.thePlayer;
        int keycode = key.getKeyCode();

        // Immediately set the forward key to pressed state
        minecraft.addScheduledTask(() -> {

            // Press key
            KeyBinding.setKeyBindState(keycode, true);

            // Schedule a task to release the forward key after keepTime
            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.schedule(() -> {

                minecraft.addScheduledTask(() -> {
                    // Release key
                    KeyBinding.setKeyBindState(keycode, false);
                });

            }, hold, TimeUnit.MILLISECONDS); // hold is the duration for which the player will move

            scheduler.shutdown();

        });

        player.addChatMessage(new ChatComponentText("\""+ serviceName + "\" triggered by \"" + this.isActive + "\""));

    }

}
