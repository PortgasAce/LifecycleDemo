package com.portgas.lifecycledemo;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class CounterDelegate {

  private TextView mCounterTv;
  @SuppressLint("HandlerLeak")
  private Handler mHandler = new Handler() {
    int count = 0;

    @Override
    public void handleMessage(Message msg) {
      super.handleMessage(msg);
      count++;
      mCounterTv.setText(count + "");
      sendEmptyMessageDelayed(1, 1000);
    }
  };

  public CounterDelegate(TextView counterTv) {
    mCounterTv = counterTv;
  }

  public void onResume() {
    mHandler.sendEmptyMessageDelayed(1, 1000);
  }

  public void onPause() {
    mHandler.removeCallbacksAndMessages(null);
  }

}
