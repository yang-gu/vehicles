package gu.yang.myapplication.model.pojo;

import android.os.Parcelable;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by yanggu on 8/3/17.
 */

public class Car implements Serializable{
  private Integer year;
  private String make;
  private String model;
  private Integer mileage;
  private String image_url;

  public String getImageURL() {
    return image_url;
  }

  public void setImageURL(String imageURL) {
    this.image_url = imageURL;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getMileage() {
    return mileage;
  }

  public void setMileage(Integer mileage) {
    this.mileage = mileage;
  }

  // Returns true if all string tokens are contained somewhere
  public boolean matches(String searchString) {
    System.out.println("1234 Matching");

    String[] tokens = searchString.split("\\s+");
    for (String string : tokens ) {
      System.out.println("1234 token is " + tokens);
      if (!carContains(string))
        return false;
    }

    return true;
  }

  private boolean carContains(String searchString) {
    String lower = searchString.toLowerCase();

    //If token is a number compare it to year
    if (StringUtils.isNumeric(lower)) {
      if (!(Integer.parseInt(lower) == year))
        return false;
      else
        return true;
    }

    if ((make.toLowerCase().contains(lower) || (model.toLowerCase().contains(lower))))
      return true;
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Car car = (Car) o;

    if (year != null ? !year.equals(car.year) : car.year != null) return false;
    if (make != null ? !make.equals(car.make) : car.make != null) return false;
    if (model != null ? !model.equals(car.model) : car.model != null) return false;
    return mileage != null ? mileage.equals(car.mileage) : car.mileage == null;

  }

  @Override
  public int hashCode() {
    int result = year != null ? year.hashCode() : 0;
    result = 31 * result + (make != null ? make.hashCode() : 0);
    result = 31 * result + (model != null ? model.hashCode() : 0);
    result = 31 * result + (mileage != null ? mileage.hashCode() : 0);
    return result;
  }
}
