package com.portgas.lifecycledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private TextView mCounterTv;
  private CounterDelegate mCounterDelegate;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mCounterTv = findViewById(R.id.counter);
    mCounterDelegate = new CounterDelegate(mCounterTv);
  }

  @Override
  protected void onResume() {
    super.onResume();
    mCounterDelegate.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mCounterDelegate.onPause();
  }
}
