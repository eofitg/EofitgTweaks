package com.eofitg.eofitgtweaks.utils;

public class AntiAntiAFK {

    public static boolean isActive = false;
    private static int moveInterval = 5 * 1000;
    private static int keepTime = 500; // ms

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
