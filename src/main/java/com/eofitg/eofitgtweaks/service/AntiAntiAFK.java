package com.eofitg.eofitgtweaks.service;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;

public class AntiAntiAFK extends AbstractService {

    private static final String serviceName = "Anti Anti-AFK";
    private static final int moveInterval = 5 * 1000;
    private static final int keepTime = 500;

    private AntiAntiAFKThread thread;

    public AntiAntiAFK() {
        super(serviceName);
        thread = new AntiAntiAFKThread();
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
            thread = new AntiAntiAFKThread();
            thread.start();
        }
    }

    public class AntiAntiAFKThread extends Thread {

        private volatile boolean active = true;

        @Override
        public void run() {
            while (active) {
                if (isActive()) {
                    playerMove();
                }
                try {
                    Thread.sleep(moveInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void kill() {
            active = false;
        }

    }

    protected void playerMove() {

        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

        player.moveEntity(1, 0, 0);
        player.addChatMessage(new ChatComponentText("Moved by \"" + isActive() + "\""));

    }

}
