package net.savagedev.spinnypizza.listeners;

import android.view.View;

import net.savagedev.spinnypizza.tasks.CheeseFallTask;

public class PizzaClickListener implements View.OnClickListener {
    private final CheeseFallTask cheeseFallTask;

    public PizzaClickListener(CheeseFallTask cheeseFallTask) {
        this.cheeseFallTask = cheeseFallTask;
    }

    @Override
    public void onClick(View v) {
        if (!this.cheeseFallTask.isRunning()) {
            this.cheeseFallTask.run();
        }
    }
}
