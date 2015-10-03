package net.androidbootcamp.triathlonregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costPerAthlete=725.00;
    int numOfAthletes;
    double totalCost;
    String locationChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText athletes = (EditText)findViewById(R.id.txtNumberOfAthletes);
        final Spinner location = (Spinner)findViewById(R.id.txtLocation);
        Button cost = (Button)findViewById(R.id.btnCompute);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView)findViewById(R.id.txtResult);

            @Override
            public void onClick(View v) {
                numOfAthletes = Integer.parseInt(athletes.getText().toString());
                totalCost = costPerAthlete * numOfAthletes;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                locationChoice = location.getSelectedItem().toString();
                result.setText(locationChoice +" race team fee is: "+ currency.format(totalCost));

            }
        });
    }


}
