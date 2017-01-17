package com.dump129.helloworld;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by Dump129 on 1/17/2017.
 */

public class CustomViewGroup extends FrameLayout {
    private Button btnHello;
    public CustomViewGroup(@NonNull Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
    }

    private void initInstances() {
        // findViewById
        btnHello = (Button) findViewById(R.id.btnCustomViewGroupHello);
    }

    private void initInflate() {
        // Inflate layout here
        inflate(getContext(), R.layout.sample_layout, this);
    }

    public void setBtnHelloText(String text) {
        btnHello.setText(text);
    }
}
