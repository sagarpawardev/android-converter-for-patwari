package dev.sagar.areaconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static org.apache.commons.lang.StringUtils.isNotEmpty;

public class MainActivity extends AppCompatActivity {

    EditText etAcre = null;
    EditText etHectare = null;
    EditText etSqMeterArea = null;
    EditText etSqFeetArea = null;
    EditText etSqFeetA = null;
    EditText etSqMeterA = null;
    TextView textSqFeetBVal = null;
    TextView textSqMeterBVal = null;

    private static DecimalFormat df3 = new DecimalFormat("0.000");
    private static DecimalFormat df2 = new DecimalFormat("0.00");

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_clear){
            clearAll();
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAcre = findViewById(R.id.etAcre);
        etAcre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etAcre.hasFocus() && charSequence.length()>0) {
                    double d = Double.parseDouble(charSequence.toString());
                    populateAcre(d);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        // Hectare
        etHectare = findViewById(R.id.etHectare);
        etHectare.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etHectare.hasFocus() && charSequence.length()>0) {
                    double d = Double.parseDouble(charSequence.toString());
                    populateHectare(d);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Square Meter
        etSqMeterArea = findViewById(R.id.etSqMeter);
        etSqMeterArea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etSqMeterArea.hasFocus() && charSequence.length()>0) {
                    double d = Double.parseDouble(charSequence.toString());
                    populateSqMeter(d);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Square Feet
        etSqFeetArea = findViewById(R.id.etSqFeet);
        etSqFeetArea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etSqFeetArea.hasFocus() && charSequence.length()>0) {
                    double d = Double.parseDouble(charSequence.toString());
                    populateSqFeet(d);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Square Feet A and B
        etSqFeetA = findViewById(R.id.etSqFeetA);
        textSqFeetBVal = findViewById(R.id.textSqFeetBVal);
        etSqFeetA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etSqFeetA.hasFocus() && charSequence.length()>0){
                    double d = Double.parseDouble(charSequence.toString());
                    populateFeetB(d);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Square Meter A and B
        etSqMeterA = findViewById(R.id.etSqMeterA);
        textSqMeterBVal = findViewById(R.id.textSqMeterBVal);
        etSqMeterA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etSqMeterA.hasFocus() && charSequence.length()>0){
                    double d = Double.parseDouble(charSequence.toString());
                    populateMeterB(d);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void populateSqMeter(double a){
        etAcre.setText(convertAndRound(a * 0.000247105, df2));
        etHectare.setText(convertAndRound(a * 1e-4));
        etSqFeetArea.setText(convertAndRound(a * 10.7639));

        resetLengths();
    }

    private void populateSqFeet(double a){
        etAcre.setText(convertAndRound(a * 2.29568e-5, df2));
        etHectare.setText(convertAndRound(a * 9.2903e-6));
        etSqMeterArea.setText(convertAndRound(a * 0.092903));

        resetLengths();
    }

    private void populateAcre(double a){
        etHectare.setText(convertAndRound(a * 0.404686));
        etSqFeetArea.setText(convertAndRound(a * 9.2903e-6));
        etSqMeterArea.setText(convertAndRound(a * 1e-4));

        resetLengths();
    }

    private void populateHectare(double a){
        etAcre.setText(convertAndRound(a * 2.47105, df2));
        etSqFeetArea.setText(convertAndRound(a * 107639));
        etSqMeterArea.setText(convertAndRound(a * 10000));

        resetLengths();
    }

    private void populateMeterB(double a){
        Editable editableArea = etSqMeterArea.getText();
        if( isNotEmpty(editableArea.toString()) ){
            double area = Double.parseDouble(editableArea.toString());
            textSqMeterBVal.setText(convertAndRound(area/a, df2));

            //Populate Feet
            if( etSqMeterA.hasFocus() ) {
                etSqFeetA.setText(convertAndRound( a*3.281 ));
                populateFeetB(a*3.281 );
            }
        }
    }

    private void populateFeetB(double a){
        Editable editableArea = etSqFeetArea.getText();
        if( isNotEmpty(editableArea.toString()) ){
            double area = Double.parseDouble(editableArea.toString());
            textSqFeetBVal.setText(convertAndRound(area/a, df2));

            // Populate Meter
            if(etSqFeetA.hasFocus()){
                etSqMeterA.setText(convertAndRound(a/3.281));
                populateMeterB( a/3.281 );
            }
        }
    }

    private void resetLengths(){
        etSqFeetA.setText("");
        textSqFeetBVal.setText("");
        etSqMeterA.setText("");
        textSqMeterBVal.setText("");
    }

    private void clearAll(){
        etHectare.setText("");
        etAcre.setText("");
        etSqMeterArea.setText("");
        etSqFeetArea.setText("");

        resetLengths();
        closeKeyboard();
    }

    private String convertAndRound(double d){
        return df3.format(d);
    }

    private String convertAndRound(double d, DecimalFormat df){
        return df.format(d);
    }

    private void closeKeyboard() {

        View view = this.getCurrentFocus();

        if (view != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow( view.getWindowToken(), 0);
        }
    }
}
