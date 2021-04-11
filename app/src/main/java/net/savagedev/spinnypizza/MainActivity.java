package net.savagedev.spinnypizza;

import android.graphics.Point;
import android.os.Bundle;
import android.widget.ImageView;

import net.savagedev.spinnypizza.listeners.PizzaClickListener;
import net.savagedev.spinnypizza.tasks.CheeseFallTask;
import net.savagedev.spinnypizza.tasks.PizzaSpinTask;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        final ImageView pizzaImage = this.findViewById(R.id.pizza);

        final Point point = new Point();
        super.getWindowManager().getDefaultDisplay().getSize(point);

        pizzaImage.setOnClickListener(new PizzaClickListener(new CheeseFallTask(new ImageView[]{this.findViewById(R.id.cheese1), this.findViewById(R.id.cheese2), this.findViewById(R.id.cheese3)}, point.y)));

        final PizzaSpinTask spinTask = new PizzaSpinTask(pizzaImage);
        spinTask.start();
    }
}
