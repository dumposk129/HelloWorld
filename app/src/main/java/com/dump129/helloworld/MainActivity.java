package com.dump129.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etNumber1, etNumber2;
    private TextView tvResult;
    private Button btnCalculate;
    private RadioButton rbPlus, rbMinus, rbMultiply, rbDivide;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        etNumber1 = (EditText) findViewById(R.id.etNumber1);
        etNumber2 = (EditText) findViewById(R.id.etNumber2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        radioGroup = (RadioGroup) findViewById(R.id.rgCalculate);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num1, num2;
        float result = 0;
        if (v == btnCalculate) {

            // EditText is empty
            if (TextUtils.isEmpty(etNumber1.getText().toString()) || TextUtils.isEmpty(etNumber2.getText().toString())) {
                return;
            }

            num1 = Integer.parseInt(etNumber1.getText().toString());
            num2 = Integer.parseInt(etNumber2.getText().toString());

            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.rbPlus:
                    result = num1 + num2;
                    break;
                case R.id.rbMinus:
                    result = num1 - num2;
                    break;
                case R.id.rbMultiply:
                    result = num1 * num2;
                    break;
                case R.id.rbDivide:
                    if (num2 == 0) {
                        Toast.makeText(MainActivity.this, "Number 2 is not zero", Toast.LENGTH_SHORT).show();
                        tvResult.setText("Error");
                    } else {
                        result = num1 / num2;
                    }
                    break;
            }

            tvResult.setText("" + result);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
