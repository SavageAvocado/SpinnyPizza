package net.savagedev.spinnypizza.tasks;

import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.util.Objects;

public class CheeseFallTask implements Runnable {
    private static final long DELAY = 1L;
    private static final int SPEED = 5;

    private final Handler handler = new Handler(Objects.requireNonNull(Looper.myLooper()));

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
        try {
            this.updateCheesePosition();
        } finally {
            if (this.running) {
                this.handler.postDelayed(this, DELAY);
            }
        }
    }

    private void updateCheesePosition() {
        if (!this.running) {
            this.running = true;
            this.y = 0;
        }

        for (ImageView cheese : this.cheese) {
            if (this.y >= this.displayHeight - (cheese.getHeight() * 1.5)) {
                this.reset();
                break;
            } else {
                cheese.setY(this.y);
            }
        }
        this.y += SPEED;
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
