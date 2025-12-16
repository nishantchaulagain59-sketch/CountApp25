package com.example.countapp25;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.countapp25.R;

public class MainActivity extends AppCompatActivity {
    EditText editTextInput;
    Spinner spinnerMetric;
    Button buttonCount;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        spinnerMetric = findViewById(R.id.spinnerMetric);
        buttonCount = findViewById(R.id.buttonCount);
        textViewResult = findViewById(R.id.textViewResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.metrics_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMetric.setAdapter(adapter);
        spinnerMetric.setPrompt(getString(R.string.select_metric_prompt));

        buttonCount.setOnClickListener(v -> performCounting());
    }

    /**
     * Handles the counting logic on button click.
     * Validates input and displays result or warning.
     */
    @SuppressLint("SetTextI18n")
    private void performCounting() {
        String inputText = editTextInput.getText().toString().trim();
        if (inputText.isEmpty()) {
            Toast.makeText(this, R.string.empty_text_warning, Toast.LENGTH_SHORT).show();
            return;
        }
        String selectedMetric = spinnerMetric.getSelectedItem().toString();
        int countResult = 0;
        switch (selectedMetric) {
            case "Sentences":
                countResult = TextMetricCounter.countSentences(inputText);
                break;
            case "Words":
                countResult = TextMetricCounter.countWords(inputText);
                break;
            case "Chars":
                countResult = TextMetricCounter.countCharacters(inputText);
                break;
            case "Numbers":
                countResult = TextMetricCounter.countNumbers(inputText);
                break;
            case "UPPERCASE Words":
                countResult = TextMetricCounter.countUppercaseWords(inputText);
                break;
            default:
                break;

        }
        textViewResult.setText(selectedMetric + ":" + countResult);
    }
}