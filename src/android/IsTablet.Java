package com.rjfun.cordova.istablet;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

public class IsTablet
  extends CordovaPlugin
{
  private static final String LOG_TAG = "IsTabletPlugin";
  
  private boolean isTabletDevice(Context paramContext)
  {
    if ((paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3) {}
    for (int i = 1; i != 0; i = 0)
    {
      DisplayMetrics metrics = new DisplayMetrics();
      this.cordova.getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
      if ((metrics.densityDpi != 160) && (metrics.densityDpi != 240) && (metrics.densityDpi != 160) && (metrics.densityDpi != 213) && (metrics.densityDpi != 320)) {
        break;
      }
      Log.d("IsTabletPlugin", "Is Tablet Device");
      return true;
    }
    Log.d("IsTabletPlugin", "Is NOT Tablet Device");
    return false;
  }
  
  public boolean execute(String funcName, JSONArray params, CallbackContext paramCallbackContext)
    throws JSONException
  {
    Log.d("IsTabletPlugin", "Plugin execute called - " + toString());
    boolean ret = isTabletDevice(this.cordova.getActivity().getApplicationContext());
    paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, ret));
    return true;
  }
}
