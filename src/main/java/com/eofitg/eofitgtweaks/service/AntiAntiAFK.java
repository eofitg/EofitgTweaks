package com.eofitg.eofitgtweaks.service;

import net.minecraft.client.Minecraft;

import java.security.SecureRandom;

public class AntiAntiAFK extends AbstractService {

    private static final String serviceName = "Anti Anti-AFK";
    private static final int moveInterval = 5 * 1000;
    private static final int holdTime = 500;

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

        Minecraft minecraft = Minecraft.getMinecraft();

        int[] keycodes = {
                minecraft.gameSettings.keyBindLeft.getKeyCode(),
                minecraft.gameSettings.keyBindRight.getKeyCode(),
                minecraft.gameSettings.keyBindBack.getKeyCode(),
                minecraft.gameSettings.keyBindForward.getKeyCode()
        };

        SecureRandom secureRandom = new SecureRandom();
        int index = secureRandom.nextInt(keycodes.length);

        pressKey(keycodes[index], holdTime);

    }

}
