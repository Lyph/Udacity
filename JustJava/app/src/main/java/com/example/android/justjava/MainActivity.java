package com.example.android.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import static com.example.android.justjava.R.id.price_text_view;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 0;
    boolean hasWhippedCream;
    boolean hasChocolate;
    int whippedCream;
    int chocolate;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        name = nameEditText.getText().toString();

        String priceMessage = createOrderSummary();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);

        startActivity(Intent.createChooser(intent, "Send Email"));

    }

    public void setWhippedCream(View view){
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whip_cream_checkbox);
        hasWhippedCream = whippedCreamCheckBox.isChecked();
        whippedCream = hasWhippedCream? 1:0;
        displayPrice();
    }

    public void setChocolate(View view){
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        hasChocolate = chocolateCheckBox.isChecked();
        chocolate = hasChocolate? 1:0;
        displayPrice();
    }

    public void increment(View view) {
        quantity++;
        displayQuantity();
        displayPrice();
    }

    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
            displayQuantity();
            displayPrice();
        }
    }

    private String createOrderSummary(){
        return "Name: " + name +
                "\nTotal amount ordered: " + quantity +
                "\nAdd Whip Cream? " + hasWhippedCream +
                "\nAdd Chocolate? " + hasChocolate +
                "\nTotal Price: $" + price +
                "\nThank you!";
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the given price on the screen.
     */


    private void displayPrice() {
        price = quantity*(5 + 1* whippedCream + 3 * chocolate);
        TextView priceTextView = (TextView) findViewById(price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(price));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


}