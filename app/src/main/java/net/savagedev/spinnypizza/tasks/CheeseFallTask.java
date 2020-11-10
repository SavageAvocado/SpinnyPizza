package net.savagedev.spinnypizza.tasks;

import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

public class CheeseFallTask implements Runnable {
    private static final long DELAY = 1L;

    private final Handler handler = new Handler(Looper.myLooper());

    private final ImageView[] cheese;
    private final int displayHeight;

    private boolean running = false;

    private int y;

    public CheeseFallTask(ImageView[] cheese, int displayHeight) {
        this.displayHeight = displayHeight;
        this.cheese = cheese;
    }

    @Override
    public void run() {
        if (!this.running) {
            this.running = true;
            this.y = 0;
        }

        boolean run = false;

        try {
            run = this.cheeseFall();
        } finally {
            if (run) {
                this.handler.postDelayed(this, DELAY);
            }
        }
    }

    private boolean cheeseFall() {
        for (ImageView cheese : this.cheese) {
            if (this.y >= this.displayHeight - (cheese.getHeight() * 1.5)) {
                this.reset();
                return false;
            } else {
                cheese.setY(this.y);
            }
        }
        this.y += 3;
        return true;
    }

    private void reset() {
        for (ImageView cheese : this.cheese) {
            cheese.setY(0);
        }
        this.running = false;
    }

    public boolean isRunning() {
        return this.running;
    }
}
