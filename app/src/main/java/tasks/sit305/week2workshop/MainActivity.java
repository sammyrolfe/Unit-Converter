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


        Spinner sourceSpinner = (Spinner) findViewById(R.id.source_unit_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> sourceAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.sourceUnitsArray,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        sourceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        sourceSpinner.setAdapter(sourceAdapter);
        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected Item:" + item, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner destSpinner = (Spinner) findViewById(R.id.destination_unit_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> destAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.destinationUnitsArray,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        destAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        destSpinner.setAdapter(destAdapter);
        destSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
            String sourceOption = sourceSpinner.getSelectedItem().toString();
            String destOption = destSpinner.getSelectedItem().toString();
            String selectedOption = sourceOption + " to " + destOption;
            handleButtonClick(selectedOption);
        });


    }

    // Function to handle button click based on spinner selection
    private void handleButtonClick(String option) {

        switch (option) {
            case "Celsius to Fahrenheit":
                celciusToFahrenheit();

                break;
            case "Fahrenheit to Celsius":
                fahrenheitToCelcius();
                break;
            case "Celsius to Kelvin":
                celciusToKelvin();
                break;
            case "Kelvin to Celsius":
                kelvinToCelcius();
                break;
            case "Fahrenheit to Kelvin":
                fahrenheitToKelvin();
                break;
            case "Kelvin to Fahrenheit":
                kelvinToFahrenheit();
                break;
            case "Lbs to Kgs":
                lbsToKgs();
                break;
            case "Kgs to Lbs":
                kgsToLbs();
                break;
            case "Ounces to Grams":
                ouncesToGrams();
                break;
            case "Grams to Ounces":
                gramsToOunces();
                break;
            case "Grams to Kgs":
                gramsToKgs();
                break;
            case "Grams to Lbs":
                gramsToLbs();
                break;
            case "Grams to Tons":
                gramsToTons();
                break;
            case "Lbs to Ounces":
                lbsToOunces();
                break;
            case "Lbs to Tons":
                lbsToTons();
                break;
            case "Ounces to Lbs":
                ouncesToLbs();
                break;
            case "Ounces to Kgs":
                ouncesToKgs();
                break;
            case "Ounces to Tons":
                ouncesToTons();
                break;
            case "Tons to Kgs":
                tonsToKgs();
                break;
            case "Tons to Lbs":
                tonsToLbs();
                break;
            case "Tons to Grams":
                tonsToGrams();
                break;
            case "Tons to Ounces":
                tonsToOunces();
                break;
            case "Kgs to Tons":
                kgsToTons();
                break;
            case "Kgs to Grams":
                kgsToGrams();
                break;
            case "Inches to Centimetres":
                inchesToCentimetres();
                break;
            case "Inches to Feet":
                inchesToFeet();
                break;
            case "Inches to Yards":
                inchesToYards();
                break;
            case "Inches to Miles":
                inchesToMiles();
                break;
            case "Inches to Kms":
                inchesToKms();
                break;
            case "Centimetres to Inches":
                centimetresToInches();
                break;
            case "Feet to Centimetres":
                feetToCentimetres();
                break;
            case "Feet to Inches":
                feetToInches();
                break;
            case "Feet to Yards":
                feetToYards();
                break;
            case "Feet to Miles":
                feetToMiles();
                break;
            case "Feet to Kms":
                feetToKms();
                break;
            case "Centimetres to Feet":
                centimetresToFeet();
                break;
            case "Centimetres to Miles":
                centimetresToMiles();
                break;
            case "Yards to Centimetres":
                yardsToCentimetres();
                break;
            case "Yards to Inches":
                yardsToInches();
                break;
            case "Yards to Feet":
                yardsToFeet();
                break;
            case "Yards to Miles":
                yardsToMiles();
                break;
            case "Yards to Kms":
                yardsToKms();
                break;
            case "Centimetres to Yards":
                centimetresToYards();
                break;
            case "Miles to Kms":
                milesToKms();
                break;
            case "Miles to Centimetres":
                milesToCentimetres();
                break;
            case "Miles to Inches":
                milesToInches();
                break;
            case "Miles to Feet":
                milesToFeet();
                break;
            case "Miles to Yards":
                milesToYards();
                break;
            case "Kms to Miles":
                kmsToMiles();
                break;
            case "Kms to Centimetres":
                kmsToCentimetres();
                break;
            case "Kms to Inches":
                kmsToInches();
                break;
            case "Kms to Feet":
                kmsToFeet();
                break;
            case "Kms to Yards":
                kmsToYards();
                break;
            default:
                Toast.makeText(this, "Please select compatible units", Toast.LENGTH_SHORT).show();
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

    private void fahrenheitToKelvin() {
        String inputString = unitInput.getText().toString();
        double fahrenheit = Double.parseDouble(inputString);
        double kelvin = (fahrenheit + 459.67) / 1.8;
        resultText.setText(String.format("Result: %.2f K", kelvin));
    }

    private void kelvinToFahrenheit() {
        String inputString = unitInput.getText().toString();
        double kelvin = Double.parseDouble(inputString);
        double fahrenheit = (kelvin * 1.8) - 459.67;
        resultText.setText(String.format("Result: %.2f F", fahrenheit));
    }

    private void lbsToKgs() {
        String inputString = unitInput.getText().toString();
        double lbs = Double.parseDouble(inputString);
        double kgs = (lbs * 0.453592);
        resultText.setText(String.format("Result: %.2f kgs", kgs));
    }

    private void lbsToTons() {
        String inputString = unitInput.getText().toString();
        double lbs = Double.parseDouble(inputString);
        double tons = (lbs * 0.0005);
        resultText.setText(String.format("Result: %.2f tons", tons));
    }

    private void lbsToOunces() {
        String inputString = unitInput.getText().toString();
        double lbs = Double.parseDouble(inputString);
        double ounces = (lbs * 16);
        resultText.setText(String.format("Result: %.2f lbs", ounces));
    }

    private void ouncesToLbs() {
        String inputString = unitInput.getText().toString();
        double ounces = Double.parseDouble(inputString);
        double lbs = (ounces * 0.0625);
        resultText.setText(String.format("Result: %.2f lbs", lbs));
    }

    private void ouncesToTons() {
        String inputString = unitInput.getText().toString();
        double ounces = Double.parseDouble(inputString);
        double tons = (ounces / 32000);
        resultText.setText(String.format("Result: %.2f tons", tons));
    }

    private void kgsToLbs() {
        String inputString = unitInput.getText().toString();
        double kgs = Double.parseDouble(inputString);
        double lbs = (kgs * 2.20462);
        resultText.setText(String.format("Result: %.2f lbs", lbs));
    }

    private void kgsToGrams() {
        String inputString = unitInput.getText().toString();
        double kgs = Double.parseDouble(inputString);
        double grams = (kgs * 1000);
        resultText.setText(String.format("Result: %.2f grams", grams));
    }

    private void ouncesToGrams() {
        String inputString = unitInput.getText().toString();
        double ounces = Double.parseDouble(inputString);
        double grams = (ounces * 28.3495);
        resultText.setText(String.format("Result: %.2f g", grams));
    }

    private void ouncesToKgs() {
        String inputString = unitInput.getText().toString();
        double ounces = Double.parseDouble(inputString);
        double kgs = (ounces * 0.0283);
        resultText.setText(String.format("Result: %.2f kgs", kgs));
    }

    private void gramsToOunces() {
        String inputString = unitInput.getText().toString();
        double grams = Double.parseDouble(inputString);
        double ounces = (grams * 0.035274);
        resultText.setText(String.format("Result: %.2f ounces", ounces));
    }

    private void gramsToTons() {
        String inputString = unitInput.getText().toString();
        double grams = Double.parseDouble(inputString);
        double tons = (grams / 907200);
        resultText.setText(String.format("Result: %.2f tons", tons));
    }
    private void gramsToLbs() {
        String inputString = unitInput.getText().toString();
        double grams = Double.parseDouble(inputString);
        double lbs = (grams * 0.00220462);
        resultText.setText(String.format("Result: %.2f lbs", lbs));
    }

    private void gramsToKgs() {
        String inputString = unitInput.getText().toString();
        double grams = Double.parseDouble(inputString);
        double kgs = (grams * 0.001);
        resultText.setText(String.format("Result: %.2f kgs", kgs));
    }

    private void tonsToKgs() {
        String inputString = unitInput.getText().toString();
        double tons = Double.parseDouble(inputString);
        double kgs = (tons * 907.185);
        resultText.setText(String.format("Result: %.2f kgs", kgs));
    }

    private void tonsToGrams() {
        String inputString = unitInput.getText().toString();
        double tons = Double.parseDouble(inputString);
        double grams = (tons * 907185);
        resultText.setText(String.format("Result: %.2f grams", grams));
    }

    private void tonsToLbs() {
        String inputString = unitInput.getText().toString();
        double tons = Double.parseDouble(inputString);
        double lbs = (tons * 2000);
        resultText.setText(String.format("Result: %.2f lbs", lbs));
    }

    private void tonsToOunces() {
        String inputString = unitInput.getText().toString();
        double tons = Double.parseDouble(inputString);
        double ounces = (tons * 32000);
        resultText.setText(String.format("Result: %.2f ounces", ounces));
    }

    private void kgsToTons() {
        String inputString = unitInput.getText().toString();
        double kgs = Double.parseDouble(inputString);
        double tons = (kgs * 0.0110231);
        resultText.setText(String.format("Result: %.2f tons", tons));
    }

    private void inchesToCentimetres() {
        String inputString = unitInput.getText().toString();
        double inches = Double.parseDouble(inputString);
        double cms = (inches * 2.54);
        resultText.setText(String.format("Result: %.2f cm", cms));
    }

    private void inchesToFeet() {
        String inputString = unitInput.getText().toString();
        double inches = Double.parseDouble(inputString);
        double feet = (inches / 12);
        resultText.setText(String.format("Result: %.2f feet", feet));
    }

    private void inchesToYards() {
        String inputString = unitInput.getText().toString();
        double inches = Double.parseDouble(inputString);
        double yards = (inches / 36);
        resultText.setText(String.format("Result: %.2f yards", yards));
    }

    private void inchesToMiles() {
        String inputString = unitInput.getText().toString();
        double inches = Double.parseDouble(inputString);
        double miles = (inches / 63360);
        resultText.setText(String.format("Result: %.2f miles", miles));
    }

    private void inchesToKms() {
        String inputString = unitInput.getText().toString();
        double inches = Double.parseDouble(inputString);
        double kms = (inches / 39370);
        resultText.setText(String.format("Result: %.2f kms", kms));
    }

    private void centimetresToInches() {
        String inputString = unitInput.getText().toString();
        double cms = Double.parseDouble(inputString);
        double inches = (cms * 0.393701);
        resultText.setText(String.format("Result: %.2f inches", inches));
    }

    private void centimetresToMiles() {
        String inputString = unitInput.getText().toString();
        double cms = Double.parseDouble(inputString);
        double miles = (cms / 160900);
        resultText.setText(String.format("Result: %.2f miles", miles));
    }

    private void feetToCentimetres() {
        String inputString = unitInput.getText().toString();
        double feet = Double.parseDouble(inputString);
        double cms = (feet * 30.48);
        resultText.setText(String.format("Result: %.2f cm", cms));
    }

    private void feetToInches() {
        String inputString = unitInput.getText().toString();
        double feet = Double.parseDouble(inputString);
        double inches = (feet * 12);
        resultText.setText(String.format("Result: %.2f inches", inches));
    }

    private void feetToYards() {
        String inputString = unitInput.getText().toString();
        double feet = Double.parseDouble(inputString);
        double yards = (feet / 3);
        resultText.setText(String.format("Result: %.2f yards", yards));
    }

    private void feetToMiles() {
        String inputString = unitInput.getText().toString();
        double feet = Double.parseDouble(inputString);
        double miles = (feet / 5280);
        resultText.setText(String.format("Result: %.2f miles", miles));
    }

    private void feetToKms() {
        String inputString = unitInput.getText().toString();
        double feet = Double.parseDouble(inputString);
        double kms = (feet / 3281);
        resultText.setText(String.format("Result: %.2f kms", kms));
    }

    private void centimetresToFeet() {
        String inputString = unitInput.getText().toString();
        double cms = Double.parseDouble(inputString);
        double feet = (cms * 0.0328084);
        resultText.setText(String.format("Result: %.2f feet", feet));
    }

    private void yardsToCentimetres() {
        String inputString = unitInput.getText().toString();
        double yards = Double.parseDouble(inputString);
        double cms = (yards * 91.44);
        resultText.setText(String.format("Result: %.2f cm", cms));
    }

    private void yardsToInches() {
        String inputString = unitInput.getText().toString();
        double yards = Double.parseDouble(inputString);
        double inches = (yards / 39370);
        resultText.setText(String.format("Result: %.2f inches", inches));
    }

    private void yardsToFeet() {
        String inputString = unitInput.getText().toString();
        double yards = Double.parseDouble(inputString);
        double feet = (yards / 3);
        resultText.setText(String.format("Result: %.2f feet", feet));
    }

    private void yardsToMiles() {
        String inputString = unitInput.getText().toString();
        double yards = Double.parseDouble(inputString);
        double miles = (yards / 1760);
        resultText.setText(String.format("Result: %.2f miles", miles));
    }

    private void yardsToKms() {
        String inputString = unitInput.getText().toString();
        double yards = Double.parseDouble(inputString);
        double kms = (yards / 1094);
        resultText.setText(String.format("Result: %.2f kms", kms));
    }

    private void centimetresToYards() {
        String inputString = unitInput.getText().toString();
        double cms = Double.parseDouble(inputString);
        double yards = (cms * 0.0109361);
        resultText.setText(String.format("Result: %.2f yards", yards));
    }

    private void milesToKms() {
        String inputString = unitInput.getText().toString();
        double miles = Double.parseDouble(inputString);
        double kms = (miles * 1.60934);
        resultText.setText(String.format("Result: %.2f kms", kms));
    }

    private void milesToCentimetres() {
        String inputString = unitInput.getText().toString();
        double miles = Double.parseDouble(inputString);
        double cms = (miles * 160934);
        resultText.setText(String.format("Result: %.2f cms", cms));
    }

    private void milesToInches() {
        String inputString = unitInput.getText().toString();
        double miles = Double.parseDouble(inputString);
        double inches = (miles * 63360);
        resultText.setText(String.format("Result: %.2f inches", inches));
    }

    private void milesToFeet() {
        String inputString = unitInput.getText().toString();
        double miles = Double.parseDouble(inputString);
        double feet = (miles * 5280);
        resultText.setText(String.format("Result: %.2f feet", feet));
    }

    private void milesToYards() {
        String inputString = unitInput.getText().toString();
        double miles = Double.parseDouble(inputString);
        double yards = (miles * 1760);
        resultText.setText(String.format("Result: %.2f yards", yards));
    }

    private void kmsToMiles() {
        String inputString = unitInput.getText().toString();
        double kms = Double.parseDouble(inputString);
        double miles = (kms * 0.621371);
        resultText.setText(String.format("Result: %.2f miles", miles));
    }

    private void kmsToCentimetres() {
        String inputString = unitInput.getText().toString();
        double kms = Double.parseDouble(inputString);
        double cms = (kms * 100000);
        resultText.setText(String.format("Result: %.2f cms", cms));
    }

    private void kmsToInches() {
        String inputString = unitInput.getText().toString();
        double kms = Double.parseDouble(inputString);
        double inches = (kms * 39370.1);
        resultText.setText(String.format("Result: %.2f inches", inches));
    }

    private void kmsToFeet() {
        String inputString = unitInput.getText().toString();
        double kms = Double.parseDouble(inputString);
        double feet = (kms * 3280.84);
        resultText.setText(String.format("Result: %.2f feet", feet));
    }

    private void kmsToYards() {
        String inputString = unitInput.getText().toString();
        double kms = Double.parseDouble(inputString);
        double yards = (kms * 1093.61);
        resultText.setText(String.format("Result: %.2f yards", yards));
    }


}