package gu.yang.myapplication.presenter.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import gu.yang.myapplication.R;
import gu.yang.myapplication.model.pojo.Car;
import gu.yang.myapplication.view.MainActivity;

/**
 * Created by yanggu on 8/3/17.
 */

public class CarListAdapter extends ArrayAdapter<Car> {

  private List<Car> carList;
  private MainActivity context;


  public CarListAdapter(Context context, List<Car> carList) {
    super(context, 0, carList);
    this.context = (MainActivity) context;
    this.carList = carList;
  }

  public long getItemId(int index) {
    return carList.get(index).hashCode();
  }

  public Car getItem(int index) {
    return carList.get(index);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    LayoutInflater vi;
    vi = LayoutInflater.from(getContext());
    View v = vi.inflate(R.layout.list_item, null);


    Car c = getItem(position);

    if (c != null)

    {
      TextView yearField = (TextView) v.findViewById(R.id.year);
      TextView makeField = (TextView) v.findViewById(R.id.make);
      TextView modelField = (TextView) v.findViewById(R.id.model);
      TextView mileageField = (TextView) v.findViewById(R.id.mpg);


      if (yearField != null && c.getYear() != null) {
        yearField.setText(c.getYear().toString());
      }

      if (makeField != null && c.getMake() != null) {
        makeField.setText(c.getMake());
      }

      if (modelField != null && c.getModel() != null) {
        modelField.setText(c.getModel());
      }

      if (mileageField != null && c.getMileage() != null) {
        mileageField.setText(c.getMileage().toString() + " mpg");
      }
    }

    /*v.setOnClickListener(new View.OnClickListener()

                         {
                           @Override
                           public void onClick(View v) {

                           }
                         }

    );*/

    return v;
  }

  public void replaceList(List<Car> carList) {
    Toast.makeText(context, "replaceList " + carList.size(), Toast.LENGTH_LONG).show();
    this.carList = carList;
  }
}
