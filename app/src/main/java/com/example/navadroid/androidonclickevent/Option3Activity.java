package com.example.navadroid.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// TODO: Implementing View.OnClickListener
// This activity is implementing "View.OnClickListener" interface, so "onClick" method must be overridden.
public class Option3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText etInput;
    private TextView tvOutput;
    private Button btnBack,btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);
        bindView();
        initView();
    }

    // You don't have to bind any functions to "android:onClick" in layout XML file.
    // onClick is public!?!?
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_process_3:
                greet();
                break;
            case R.id.btn_back:
                Intent i = new Intent(getApplicationContext(), Option2Activity.class);
                startActivity(i);
                break;
            case R.id.btn_next:
                Intent j = new Intent(getApplicationContext(), Option4Activity.class);
                startActivity(j);
                break;
        }
        hideKeyboardInput(v);
    }

    // To bind views to this activity
    private void bindView(){
        etInput = (EditText) findViewById(R.id.et_input_3);
        tvOutput = (TextView) findViewById(R.id.tv_body_3);
        btnBack = (Button)findViewById(R.id.btn_back);
        btnNext = (Button)findViewById(R.id.btn_next);
    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_process_3).setOnClickListener(this);
        findViewById(R.id.btn_back).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);// Think about... Who is "this"?
    }

    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}


