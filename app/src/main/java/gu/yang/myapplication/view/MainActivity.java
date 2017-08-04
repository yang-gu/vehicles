package gu.yang.myapplication.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import gu.yang.myapplication.R;
import gu.yang.myapplication.Utils;
import gu.yang.myapplication.view.fragment.ListFragment;

public class MainActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Utils.setContext(getApplicationContext());
    setContentView(R.layout.activity_main);
    switchFragment(new ListFragment());
    Toast.makeText(this, "Mainactivity", Toast.LENGTH_SHORT).show();
  }

  public void switchFragment(Fragment f) {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction transaction = fm.beginTransaction();
    transaction.replace(R.id.main_fragment_container, f);
    transaction.commit();
  }
}
