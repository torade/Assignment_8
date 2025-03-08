package com.example.assignment8;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText firstNo, secondNo;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        firstNo = findViewById(R.id.firstNumberField);
        secondNo = findViewById(R.id.secondNumberField);
        result = findViewById(R.id.resultField);
    }


    // addition
    public void add(View view)
    {
        double x = Double.parseDouble(firstNo.getText().toString());
        double y = Double.parseDouble(secondNo.getText().toString());
        double sum = x + y;
        result.setText(String.format(Locale.US,"%.2f", sum));
    }
    // difference
    public void subtract(View view)
    {
        double x = Double.parseDouble(firstNo.getText().toString());
        double y = Double.parseDouble(secondNo.getText().toString());
        double difference = x - y;
        result.setText(String.format(Locale.US,"%.2f", difference));
    }
// multiplication
    public void multiply(View view)
    {
        double x = Double.parseDouble(firstNo.getText().toString());
        double y = Double.parseDouble(secondNo.getText().toString());
        double multiplication = x * y;
        result.setText(String.format(Locale.US, "%.2f", multiplication));
    }
    // division
    public void divide(View view)
    {
        double x = Double.parseDouble(firstNo.getText().toString());
        double y = Double.parseDouble(secondNo.getText().toString());
        if (y == 0)
            // TOAST!!!
            Toast.makeText(this, "Error: Cannot divide by 0.", Toast.LENGTH_SHORT).show();
        else
        {
            double division = x / y;
            result.setText(String.format(Locale.US, "%.2f", division));
        }
    }

    public void clearFields (View view)
    {
        firstNo.setText(null);
        secondNo.setText(null);
        result.setText(null);
    }

}