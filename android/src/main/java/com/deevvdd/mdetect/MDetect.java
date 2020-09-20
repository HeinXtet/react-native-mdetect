package com.deevvdd.mdetect;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class MDetect extends ReactContextBaseJavaModule {
    private Boolean cacheUnicode = null;
    private static ReactApplicationContext reactContext;

    public MDetect(ReactApplicationContext context) {
        super(context);
        if (cacheUnicode != null) {
            Log.i("MDetect", "MDetect was already initialized.");
            return;
        }
        TextView textView = new TextView(context, null);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        textView.setText("\u1000");
        textView.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int length1 = textView.getMeasuredWidth();

        textView.setText("\u1000\u1039\u1000");
        textView.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int length2 = textView.getMeasuredWidth();
        cacheUnicode = length1 == length2;
    }

    @ReactMethod
    public void isUnicode(Promise promise) {
        if (null == cacheUnicode) {
            promise.reject("MDetect", "MDetect was not initialized");
        }
        promise.resolve(cacheUnicode);
    }

    @NonNull
    @Override
    public String getName() {
        return "MDetect";
    }
}
