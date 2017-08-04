package gu.yang.myapplication.presenter.binder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import gu.yang.myapplication.model.pojo.Car;

/**
 * Created by yanggu on 8/3/17.
 */

public class DataBinder {
  public static List<Car> getCarList(String jsonString) {
    Gson gson = new Gson();
      return gson.fromJson(jsonString, new TypeToken<List<Car>>(){}.getType());
  }
}
