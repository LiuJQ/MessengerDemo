package com.jackin.messengerdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;

public class DemoMessengerService extends Service {

    private static final String TAG = "DemoMessengerService";
    private Messenger mMessenger;

    public DemoMessengerService() {
        mMessenger = new Messenger(new IncomingHandler());
    }

    private static class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DemoMessageConstants.MESSAGE_FROM_CLIENT:
                    Log.d(TAG, "received message from client");
                    break;
                    default:
                    super.handleMessage(msg);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

}
