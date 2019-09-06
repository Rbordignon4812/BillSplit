package com.example.split_the_bill3_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class calculationPage extends AppCompatActivity {
    double splitResult;
    int numPeople;
    double tipTotal;
    double billTotal;
    double tip18 = 0.18;
    String ratingStars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_page);
        final EditText people = (EditText)findViewById(R.id.peopleTxt);
        final EditText bill = (EditText)findViewById(R.id.billTxt);
        final Spinner group = (Spinner)findViewById(R.id.ratingSpinner);
        final TextView resultPeople = ((TextView)findViewById(R.id.resultPeople));
        final TextView resultTip = ((TextView)findViewById(R.id.resultTips));
        final TextView resultSplit = ((TextView)findViewById(R.id.splitResult));
        Button button2 = (Button)findViewById(R.id.calculateButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numPeople = Integer.parseInt(people.getText().toString());
                billTotal = Double.parseDouble(bill.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                tipTotal = tip18 * billTotal;
                splitResult = (double)(tipTotal + billTotal) / numPeople;
                ratingStars = group.getSelectedItem().toString();
                resultPeople.setText(Integer.toString(numPeople) );
                resultTip.setText(currency.format(tipTotal));
                resultSplit.setText(currency.format(splitResult));
            }
        });
    }
}
