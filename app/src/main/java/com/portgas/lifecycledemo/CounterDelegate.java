package com.portgas.lifecycledemo;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class CounterDelegate implements LifecycleObserver {

  private TextView mCounterTv;
  @SuppressLint("HandlerLeak")
  private Handler mHandler = new Handler() {
    int count = 0;

    @SuppressLint("SetTextI18n")
    @Override
    public void handleMessage(Message msg) {
      super.handleMessage(msg);
      count++;
      mCounterTv.setText(String.valueOf(count));
      sendEmptyMessageDelayed(1, 1000);
    }
  };

  public CounterDelegate(TextView counterTv) {
    mCounterTv = counterTv;
  }

  @OnLifecycleEvent(Event.ON_RESUME)
  public void onResume() {
    mHandler.sendEmptyMessageDelayed(1, 1000);
  }

  @OnLifecycleEvent(Event.ON_PAUSE)
  public void onPause() {
    mHandler.removeCallbacksAndMessages(null);
  }

}
