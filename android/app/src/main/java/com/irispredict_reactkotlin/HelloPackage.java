package com.irispredict_reactkotlin;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloPackage implements ReactPackage {
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext){
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule>  createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule>  modules = new ArrayList<>();
        modules.add(new HelloModule(reactContext));
//        modules.add(new Hello3Module(reactContext));
//
        modules.add(new Hello2Module(reactContext));

        return modules;
    }
}
