package com.rnmdetect.mdetect;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public  class MDetectPackage implements ReactPackage {

    private MDetect mDetect = null;
    private static MDetectPackage instance = null;

    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        mDetect = new MDetect(reactContext);
        if (instance == null) {
            instance = this;
        }
        return Arrays.<NativeModule>asList(mDetect);
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    public static MDetectPackage getInstance() {
        if (instance == null) {
            instance = new MDetectPackage();
        }
        return instance;
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
