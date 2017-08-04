package gu.yang.myapplication;

import android.content.Context;

/**
 * Created by yanggu on 8/3/17.
 */

public class Utils {

  public static Context context;

  public static Context getContext() {
    return context;
  }

  public static void setContext(Context context) {
    Utils.context = context;
  }
}
