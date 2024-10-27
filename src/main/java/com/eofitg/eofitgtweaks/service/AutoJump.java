package com.eofitg.eofitgtweaks.service;

import net.minecraft.client.Minecraft;

public class AutoJump extends AbstractService {

    private static final String serviceName = "Auto Jump";
    private static final int jumpInterval = 120 * 1000;
    private static final int holdTime = 100;

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
        pressKey(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode(), holdTime);
    }

}

