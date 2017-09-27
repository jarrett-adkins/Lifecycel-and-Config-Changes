package com.example.admin.lifecycleandconfigchanges;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityTag";
    private EditText editText;
    private TextView textView;

    //https://developer.android.com/guide/components/activities/activity-lifecycle.html
    /*onDestroy is not guaranteed to be called, use onStop().
    */
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        editText = (EditText) findViewById(R.id.etValue);
        textView = (TextView) findViewById(R.id.tvValue);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //keeps the form form getting wiped when onDestroy gets called, such as when the phone is rotated.
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putString("textViewValue", textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        textView.setText( savedInstanceState.getString( "textViewValue" ));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    public void updateTextView(View view) {
        textView.setText( editText.getText().toString());
    }

    public void goToSecond(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity( intent );
    }
}