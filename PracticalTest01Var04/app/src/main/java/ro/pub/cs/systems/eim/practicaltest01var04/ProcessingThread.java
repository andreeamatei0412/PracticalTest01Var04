package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Context;
import android.content.Intent;

public class ProcessingThread extends Thread{
    private boolean isRunning = true;
    private Context context = null;

    public ProcessingThread() {
    }

    @Override
    public void run() {
    }

    private void sendMessage() {
        Intent intent = new Intent();
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
