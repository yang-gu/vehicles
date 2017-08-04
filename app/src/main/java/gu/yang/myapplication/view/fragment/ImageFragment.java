package gu.yang.myapplication.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import gu.yang.myapplication.R;
import gu.yang.myapplication.model.pojo.Car;
import gu.yang.myapplication.presenter.access.DataAccess;
import gu.yang.myapplication.presenter.adapter.CarListAdapter;

/**
 * Created by yanggu on 8/4/17.
 */

public class ImageFragment extends Fragment{

  ImageView iv;
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.image_view_fragment, container, false);
    iv = (ImageView)v.findViewById(R.id.image_view);
    String url = getArguments().getString("url");
    System.out.println("image url is " + url);
    int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
    int height = width * 3 / 4;

    Picasso.with(getActivity())
        .load(url)
        .resize(width, height)
        .centerCrop()
        .into(iv);

    iv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        getFragmentManager().popBackStack();
      }
    });
    return v;
  }

}
