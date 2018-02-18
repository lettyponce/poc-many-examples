package com.example.android.coderunner;

import android.app.IntentService;
import android.content.Intent;

public class MyIntentService extends IntentService {

    public static final String MESSAGE_KEY = "message_key";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
    }
}
