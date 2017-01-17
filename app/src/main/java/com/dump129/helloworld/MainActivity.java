package com.dump129.helloworld;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etNumber1, etNumber2;
    private TextView tvResult;
    private Button btnCalculate;
    private RadioGroup radioGroup;
    private CustomViewGroup customViewGroup1, customViewGroup2;

    int x, y, z; // Save/Restore in Activity's instance state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check mobile or tablet, mobile can't orientation but tablet can it.
        if (getResources().getBoolean(R.bool.portrait_only)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        etNumber1 = (EditText) findViewById(R.id.etNumber1);
        etNumber2 = (EditText) findViewById(R.id.etNumber2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        radioGroup = (RadioGroup) findViewById(R.id.rgCalculate);

        customViewGroup1 = (CustomViewGroup) findViewById(R.id.viewGroup1);
        customViewGroup2 = (CustomViewGroup) findViewById(R.id.viewGroup2);
        customViewGroup1.setBtnHelloText("Hello");
        customViewGroup2.setBtnHelloText("World");

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num1, num2;
        int result = 0;
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

            Log.d("Calculation", "Result = " + result);
            Toast.makeText(MainActivity.this, "Result = " + result, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("sum", result);

            // Bundle
            Coordinate c1 = new Coordinate();
            c1.x = 5;
            c1.y = 10;
            c1.z = 20;
            Bundle bundle = new Bundle();
            bundle.putInt("x", c1.x);
            bundle.putInt("y", c1.y);
            bundle.putInt("z", c1.z);
            intent.putExtra("cBundle", bundle);

            //Serializable
            // Don't use
            CoordinateSerializable c2 = new CoordinateSerializable();
            c2.x = 5;
            c2.y = 10;
            c2.z = 20;
            intent.putExtra("cSerializable", c2);

            CoordinateParcelable c3 = new CoordinateParcelable();
            c3.x = 5;
            c3.y = 10;
            c3.z = 20;
            intent.putExtra("cParcelable", c3);

            int requestCode = 100;
            startActivityForResult(intent, requestCode);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check if ti is a result from SecondActivity
        //
        if (requestCode == 100 && resultCode == RESULT_OK) {
            // Get data from data's extra
            String result = data.getStringExtra("result");
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "onStart");
        Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart", "onRestart");
        Toast.makeText(MainActivity.this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "onPause");
        Toast.makeText(MainActivity.this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "onStop");
        Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "onDestroy");
        Toast.makeText(MainActivity.this, "onDestroy", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save here
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore here
    }
}
