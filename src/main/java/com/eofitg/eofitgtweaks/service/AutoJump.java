package com.eofitg.eofitgtweaks.service;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;

public class AutoJump extends AbstractService {

    private static final String serviceName = "Auto Jump";
    private static final int jumpInterval = 10 * 1000;

    private RegularlyJumpThread thread;

    public AutoJump() {
        super(serviceName);
        thread = new RegularlyJumpThread();
    }

    public void killThread() {
        if (thread == null) {
            return;
        }

        thread.kill();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread = null;
    }

    @Override
    public void toggle() {
        super.toggle();

        if (isActive() && !thread.isAlive()) {
            thread = new RegularlyJumpThread();
            thread.start();
        }
    }

    public class RegularlyJumpThread extends Thread {

        private volatile boolean active = true;

        @Override
        public void run() {
            while(active) {
                if (isActive()) {
                    playerJump();
                }
                try {
                    Thread.sleep(jumpInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void kill() {
            active = false;
        }

    }

    protected void playerJump() {

        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

        player.jump();
        player.addChatMessage(new ChatComponentText("Jumped by \"" + isActive() + "\""));

    }

}

