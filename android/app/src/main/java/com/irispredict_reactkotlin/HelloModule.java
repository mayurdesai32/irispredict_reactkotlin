package com.irispredict_reactkotlin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


public class HelloModule extends ReactContextBaseJavaModule {
    public HelloModule(@Nullable ReactApplicationContext reactContext){
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName(){
        return "HelloWorld";
    }


    @ReactMethod
    public void sayhello(String name, Callback callback){
        try {
            String message ="hello"+name;
            callback.invoke(null,message);
        } catch (Exception e){
            callback.invoke(e.toString(),null);
        }
    }



    @ReactMethod
    public void createPromise(Promise promise){
        try{
            promise.resolve("just the value");
        }catch (Exception e){
            promise.reject("Erorr from promise");
        }
    }



}
