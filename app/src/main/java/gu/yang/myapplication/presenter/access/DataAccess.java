package gu.yang.myapplication.presenter.access;

import java.util.List;

import gu.yang.myapplication.model.pojo.Car;
import gu.yang.myapplication.model.retrieval.DataRetriever;
import gu.yang.myapplication.presenter.binder.DataBinder;

/**
 * Created by yanggu on 8/3/17.
 */

public class DataAccess {

  public static List<Car> getCarList() {
    return DataBinder.getCarList(DataRetriever.getCarList());
  }
}
