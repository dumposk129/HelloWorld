package com.dump129.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tvResult;
    private Button btnFinish;
    private EditText etSendData;

    private int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        sum = intent.getIntExtra("sum", 0);

        // Bundle
        Bundle bundle = intent.getBundleExtra("cBundle");
        int x = bundle.getInt("x");
        int y = bundle.getInt("y");
        int z = bundle.getInt("z");

        Log.d("x", "x = " + x);
        Log.d("y", "y = " + y);
        Log.d("z", "z = " + z);

        // Serializable
        // Don't use
        CoordinateSerializable c2 = (CoordinateSerializable) intent.getSerializableExtra("cSerializable");
        Log.d("CoordinateSerializable", "c2.x = " + c2.x);
        Log.d("CoordinateSerializable", "c2.y = " + c2.y);
        Log.d("CoordinateSerializable", "c2.z = " + c2.z);

        // Parcelable
        CoordinateParcelable c3 = intent.getParcelableExtra("cParcelable");
        Log.d("CoordinateParcelable", "c3.x = " + c3.x);
        Log.d("CoordinateParcelable", "c3.y = " + c3.y);
        Log.d("CoordinateParcelable", "c3.z = " + c3.z);

        initInstances();
    }

    private void initInstances() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        etSendData = (EditText) findViewById(R.id.etSendData);

        tvResult.setText("Result = " + sum);
        tvResult.setTextSize(40);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", etSendData.getText().toString());
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
