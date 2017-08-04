package gu.yang.myapplication.model.retrieval;

import java.io.IOException;
import java.io.InputStream;

import gu.yang.myapplication.Utils;

/**
 * Created by yanggu on 8/3/17.
 */

public class DataRetriever {



  public static String getCarList() {
    String json = null;
    try {

      InputStream is = Utils.getContext().getAssets().open("vehicles.json");

      int size = is.available();

      byte[] buffer = new byte[size];

      is.read(buffer);

      is.close();

      json = new String(buffer, "UTF-8");
    } catch (IOException ex) {
      ex.printStackTrace();
      return null;
    }
    return json;
  }
}
