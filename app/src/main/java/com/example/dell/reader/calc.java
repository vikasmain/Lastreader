package com.example.dell.reader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calc extends Activity { private EditText edText1,edText2;
    private Button btnProduct;
    @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma);
        addListenerOnButton(); } private void addListenerOnButton() { edText1 = (EditText)findViewById(R.id.edittext);
        edText2 = (EditText)findViewById(R.id.edittext2);
        btnProduct = (Button)findViewById(R.id.button1);
    btnProduct.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            String t1 = edText1.getText().toString();
            String t2 = edText2.getText().toString();

            double i1 = Double.parseDouble(t1); double i2 = Double.parseDouble(t2);

            double product = i1*i2;
            Toast.makeText(getApplicationContext(), String.valueOf(product),Toast.LENGTH_LONG).show(); } }); }
    }