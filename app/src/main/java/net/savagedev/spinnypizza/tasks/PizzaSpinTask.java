package net.savagedev.spinnypizza.tasks;

import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.util.Objects;

public class PizzaSpinTask extends Thread {
    private static final long DELAY = 1L;
    private static final float SPEED = 0.75f;

    private final Handler handler = new Handler(Objects.requireNonNull(Looper.myLooper()));
    private final ImageView pizzaImage;

    private float currentRotation = 0;

    public PizzaSpinTask(ImageView pizzaImage) {
        this.pizzaImage = pizzaImage;
    }

    @Override
    public void run() {
        try {
            this.updatePizzaRotation();
        } finally {
            this.handler.postDelayed(this, DELAY);
        }
    }

    private void updatePizzaRotation() {
        this.currentRotation += SPEED;
        if (this.currentRotation > 360) {
            this.currentRotation = 0;
        }
        this.pizzaImage.setRotation(this.currentRotation);
    }
}
