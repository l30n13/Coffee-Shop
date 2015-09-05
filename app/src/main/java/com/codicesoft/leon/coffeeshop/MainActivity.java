package com.codicesoft.leon.coffeeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button order, plus, minus;
    CheckBox hot_coffee, cold_coffee;
    TextView quantity, price;

    final int hotCoffee = 15, coldCoffee = 10;
    int Quantity = 0;
    boolean hot = false, cold = true;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        order = (Button) findViewById(R.id.order);

        hot_coffee = (CheckBox) findViewById(R.id.hot_coffee);
        cold_coffee = (CheckBox) findViewById(R.id.cold_coffee);

        quantity = (TextView) findViewById(R.id.quantity);
        price = (TextView) findViewById(R.id.price);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCoffeeItem();

                if (hot && !cold) {
                    Quantity++;
                    quantity.setText(" " + String.valueOf(Quantity) + " ");
                    price.setText(String.valueOf(Quantity * hotCoffee));
                } else if (!hot && cold) {
                    Quantity++;
                    quantity.setText(" " + String.valueOf(Quantity) + " ");
                    price.setText(String.valueOf(Quantity * coldCoffee));
                } else {
                    Toast.makeText(getApplicationContext(), "Please select only one item first!!!", Toast.LENGTH_SHORT).show();
                    Quantity = 0;
                    quantity.setText(" " + String.valueOf(Quantity) + " ");
                    price.setText(String.valueOf(0));
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Quantity <= 0) {
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    Quantity = 0;
                    quantity.setText(" " + String.valueOf(Quantity) + " ");

                } else {
                    if (hot && !cold) {
                        Quantity--;
                        quantity.setText(" " + String.valueOf(Quantity) + " ");
                        price.setText(String.valueOf(Quantity * hotCoffee));
                    } else if (!hot && cold) {
                        Quantity--;
                        quantity.setText(" " + String.valueOf(Quantity) + " ");
                        price.setText(String.valueOf(Quantity * coldCoffee));
                    } else {
                        Quantity = 0;
                        quantity.setText(" " + String.valueOf(Quantity) + " ");
                        price.setText(String.valueOf(0));
                        Toast.makeText(getApplicationContext(), "Please select one item first!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hot && !cold) {
                    Toast.makeText(getApplicationContext(), String.valueOf(Quantity) + " Hot Coffee has been ordered \nTotal price is $" + String.valueOf(Quantity * hotCoffee), Toast.LENGTH_SHORT).show();
                } else if (!hot && cold) {
                    Toast.makeText(getApplicationContext(), String.valueOf(Quantity) + " Cold Coffee has been ordered \nTotal price is $" + String.valueOf(Quantity * coldCoffee), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "There is no order", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkCoffeeItem() {
        if (hot_coffee.isChecked() && !cold_coffee.isChecked()) {
            if (!hot) {
                hot = true;
                cold = false;
                Quantity = 0;
                quantity.setText(" 0 ");
                price.setText("0");
            } else {
                hot = true;
                cold = false;
            }
        } else if (!hot_coffee.isChecked() && cold_coffee.isChecked()) {
            if (!cold) {
                hot = false;
                cold = true;
                Quantity = 0;
                quantity.setText(" 0 ");
                price.setText("0");
            } else {
                hot = false;
                cold = true;
            }
        } else {
            hot = false;
            cold = false;
            Quantity = 0;
            quantity.setText(" 0 ");
            price.setText("0");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
