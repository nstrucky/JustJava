package com.netjob.justjava;

import android.app.Activity;
import java.text.NumberFormat;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {


    private int quantity = 0;
    private double price = 0.0;

    private final double THE_COST = 5.25;


    private Button addButton;
    private Button subtractButton;
    private Button orderButton;
    private TextView priceTextView;
    private TextView quantityTextView;
    private TextView finalPriceTextView;

    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.button_add);
        subtractButton = (Button) findViewById(R.id.button_subtract);
        orderButton = (Button) findViewById(R.id.button_order);

        priceTextView = (TextView) findViewById(R.id.textView_price);
        quantityTextView = (TextView) findViewById(R.id.textView_qtyNumber);
        finalPriceTextView = (TextView) findViewById(R.id.textView_finalPrice);

        addButton.setOnClickListener(buttonListener);
        subtractButton.setOnClickListener(buttonListener);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message;

                if (price > 0) {
                    message = String.format("%d %s of coffee coming up!%nTotal: %s%nThank you!",
                            quantity,
                            quantity > 1 ? "cups" : "cup",
                            priceTextView.getText());

                } else {
                    message = "Your order is Free!";

                }

                finalPriceTextView.setText(message);

            }
        });

    }

    OnClickListener buttonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.button_add) {
                quantity++;

            } else {

                if (quantity < 1) {
                    Toast.makeText(getApplicationContext(),
                            "Quantity = 0",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                quantity--;

            }

            price = quantity * THE_COST;
            quantityTextView.setText("" + quantity);
            priceTextView.setText(numberFormat.format(price));

        }
    };

}
