package tasks.sit305.week2workshop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText unitInput;
    Button convertButton;
    TextView resultText;

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

        unitInput = findViewById(R.id.unitInput);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);


        Spinner spinner = (Spinner) findViewById(R.id.unit_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.unitsArray,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected Item:" + item, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convertButton.setOnClickListener(v -> {
            String selectedOption = spinner.getSelectedItem().toString();
            handleButtonClick(selectedOption);
        });


    }

    // Function to handle button click based on spinner selection
    private void handleButtonClick(String option) {
        switch (option) {
            case "Celcius to Fahrenheit":
                celciusToFahrenheit();
                break;
            case "Fahrenheit to Celcius":
                fahrenheitToCelcius();
                break;
            case "Celcius to Kelvin":
                celciusToKelvin();
                break;
            case "Kelvin to Celcius":
                kelvinToCelcius();
                break;
            case "Lbs to Kgs":
                lbsToKgs();
                break;
            case "Ounces to grams":
                ouncesToGrams();
                break;
            case "Tons to Kgs":
                tonsToKgs();
                break;
            case "Inches to centimetres":
                inchesToCentimetres();
                break;
            case "Feet to centimetres":
                feetToCentimetres();
                break;
            case "Yards to centimetres":
                yardsToCentimetres();
                break;
            case "Miles to Kms":
                milesToKms();
                break;
            default:
                Toast.makeText(this, "No action defined", Toast.LENGTH_SHORT).show();
        }
    }

    private void celciusToFahrenheit() {
        String inputString = unitInput.getText().toString();
        double celcius = Double.parseDouble(inputString);
        double fahrenheit = (celcius * 1.8) + 32;
        resultText.setText(String.format("Result: %.2f F", fahrenheit));
        }

    private void fahrenheitToCelcius() {
        String inputString = unitInput.getText().toString();
        double fahrenheit = Double.parseDouble(inputString);
        double celcius = (fahrenheit - 32) / 1.8;
        resultText.setText(String.format("Result: %.2f C", celcius));
    }

    private void celciusToKelvin() {
        String inputString = unitInput.getText().toString();
        double celcius = Double.parseDouble(inputString);
        double kelvin = (celcius + 273.15);
        resultText.setText(String.format("Result: %.2f K", kelvin));
    }

    private void kelvinToCelcius() {
        String inputString = unitInput.getText().toString();
        double kelvin = Double.parseDouble(inputString);
        double celcius = (kelvin - 273.15);
        resultText.setText(String.format("Result: %.2f C", celcius));
    }

    private void lbsToKgs() {
        String inputString = unitInput.getText().toString();
        double lbs = Double.parseDouble(inputString);
        double kgs = (lbs * .453592);
        resultText.setText(String.format("Result: %.2f kgs", kgs));
    }

    private void ouncesToGrams() {
        String inputString = unitInput.getText().toString();
        double ounces = Double.parseDouble(inputString);
        double grams = (ounces * 28.3495);
        resultText.setText(String.format("Result: %.2f g", grams));
    }

    private void tonsToKgs() {
        String inputString = unitInput.getText().toString();
        double tons = Double.parseDouble(inputString);
        double kgs = (tons * 907.185);
        resultText.setText(String.format("Result: %.2f kgs", kgs));
    }

    private void inchesToCentimetres() {
        String inputString = unitInput.getText().toString();
        double inches = Double.parseDouble(inputString);
        double cms = (inches * 2.54);
        resultText.setText(String.format("Result: %.2f cm", cms));
    }

    private void feetToCentimetres() {
        String inputString = unitInput.getText().toString();
        double feet = Double.parseDouble(inputString);
        double cms = (feet * 30.48);
        resultText.setText(String.format("Result: %.2f cm", cms));
    }

    private void yardsToCentimetres() {
        String inputString = unitInput.getText().toString();
        double yards = Double.parseDouble(inputString);
        double cms = (yards * 91.44);
        resultText.setText(String.format("Result: %.2f cm", cms));
    }

    private void milesToKms() {
        String inputString = unitInput.getText().toString();
        double miles = Double.parseDouble(inputString);
        double kms = (miles * 1.60934);
        resultText.setText(String.format("Result: %.2f kms", kms));
    }


}