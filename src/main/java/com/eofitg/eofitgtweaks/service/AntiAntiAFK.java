package com.eofitg.eofitgtweaks.service;

public class AntiAntiAFK extends AbstractService{

    private static final String serviceName = "Anti Anti-AFK";

    private static final int moveInterval = 5 * 1000;
    private static final int keepTime = 500;

    public AntiAntiAFK() {
        super(serviceName);
    }

    public static class AntiAntiAFKThread extends Thread {

        @Override
        public void run() {

            while (true) {
                if (isActive) {

                }
                try {
                    Thread.sleep(moveInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
