/**
 * FBAdsPackage.java
 * com.reactnativefbads
 */
package com.reactnativefbads;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Main package exporting native modules and views
 */
public class FBAdsPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(
           new NativeAdManager(reactContext),
           new NativeBannerAdManager(reactContext),
           new AdSettingsManager(reactContext),
           new InterstitialAdManager(reactContext),
           new RewardedVideoAdManager(reactContext)
        );
    }

    // Deprecated RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
           new NativeAdViewManager(),
           new NativeBannerAdViewManager(),
           new BannerViewManager(),
           new AdIconViewManager(),
           new MediaViewManager(),
           new NativeAdChoicesViewManager(reactContext)
        );
    }
}
