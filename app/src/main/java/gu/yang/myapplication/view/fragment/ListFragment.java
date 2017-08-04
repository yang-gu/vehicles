package gu.yang.myapplication.view.fragment;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import gu.yang.myapplication.R;


import java.util.ArrayList;
import java.util.List;

import gu.yang.myapplication.model.pojo.Car;
import gu.yang.myapplication.model.retrieval.DataRetriever;
import gu.yang.myapplication.presenter.access.DataAccess;
import gu.yang.myapplication.presenter.adapter.CarListAdapter;
import gu.yang.myapplication.presenter.binder.DataBinder;
import gu.yang.myapplication.view.MainActivity;

/**
 * Created by yanggu on 8/4/17.
 */

public class ListFragment extends Fragment {

  private CarListAdapter carListAdapter;
  ListView lv;
  EditText et;
  ImageView iv;

  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.list_fragment, container, false);
    final List<Car> carList = DataAccess.getCarList();
    carListAdapter = new CarListAdapter(getActivity(), carList);
    lv = (ListView) v.findViewById(R.id.lv);
    et = (EditText) v.findViewById(R.id.search_field);
    iv = (ImageView) v.findViewById(R.id.search_icon);

    iv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        List<Car> secondaryCarList = new ArrayList<Car>() {
        };
        String searchString = et.getText().toString();
        if (!(searchString.replaceAll("\\s+", "").equals(""))) {
          for (Car car : carList) {
            if (car.matches(searchString)) {
              secondaryCarList.add(car);
            }
          }
        }
        else {
          secondaryCarList = carList;
        }
        carListAdapter.replaceList(secondaryCarList);
        carListAdapter.notifyDataSetChanged();
      }
    });

    lv.setAdapter(carListAdapter);
    lv.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getActivity(), "ListFragmentClicked", Toast.LENGTH_SHORT).show();
            Car car = carListAdapter.getItem(position);
            if (car != null && car.getImageURL() != null) {
              MainActivity activity = (MainActivity) getActivity();
              ImageFragment imf = new ImageFragment();
              Bundle bundle = new Bundle();
              bundle.putString("url", car.getImageURL());
              imf.setArguments(bundle);
              activity.switchFragment(imf);
            }
          }
        }
    );
    return v;
  }
}
