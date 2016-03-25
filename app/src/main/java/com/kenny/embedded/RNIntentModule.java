package com.kenny.embedded;

import android.app.Activity;
import android.text.TextUtils;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


/**
 * Created by kenny on 16/3/25.
 */
public class RNIntentModule extends ReactContextBaseJavaModule {

    public RNIntentModule(  ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNIntentModule";
    }

    @ReactMethod
    public void getDataFromIntent(Callback successBack, Callback errorBack) {
        try {
            Activity currentActivity = getCurrentActivity();
            String result = currentActivity.getIntent().getStringExtra("result");
            if (TextUtils.isEmpty(result)) {
                result = "注意：数据为空！";
            }
            successBack.invoke(result);
        } catch (Exception e) {
            errorBack.invoke(e.getMessage());
        }
    }
}