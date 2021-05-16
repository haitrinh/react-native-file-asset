package com.reactnativefileasset;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = FileAssetModule.NAME)
public class FileAssetModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FileAsset";
    public  static final String ERROR_TAG = "Fetch content failure";
    public FileAssetModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }


    @ReactMethod
    public void loadTextFile(String name, String type, Promise promise) {
        try {
            if (name.isEmpty()) {
                promise.reject(ERROR_TAG, "invalid file name");
                return;
            }
            if (type.isEmpty()) {
                promise.reject(ERROR_TAG, "invalid file type");
                return;
            }
            String content = Utilities.AssetFileToString(getReactApplicationContext(), String.format("%s.%s", name, type));
            promise.resolve(content);
        } catch (Exception e) {
            promise.reject(ERROR_TAG, e);
        }
    }

    @ReactMethod
    public void loadFilePath(String name, String type, Promise promise) {
        try {
            if (name.isEmpty()) {
                promise.reject(ERROR_TAG, "invalid file name");
                return;
            }
            if (type.isEmpty()) {
                promise.reject(ERROR_TAG, "invalid file type");
                return;
            }
            String path = Utilities.AssetFilePath(getReactApplicationContext(), String.format("%s.%s", name, type));
            promise.resolve(path);
        } catch (Exception e) {
            promise.reject(ERROR_TAG, e);
        }
    }
}
