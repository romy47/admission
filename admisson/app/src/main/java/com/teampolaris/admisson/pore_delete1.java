package com.teampolaris.admisson;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teampolaris.admisson.R;
//
//
//
///**
// * Created by User on 05/05/2017.
// */
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.List;
//import java.util.Vector;
//
///**
// * Created by Belal on 18/09/16.
// */
//
//
//public class pore_delete1 extends Fragment {
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //returning our layout file
//        //change R.layout.yourlayoutfilename for each of your fragments
//        return inflater.inflate(R.layout.pore_delete1, container, false);
//
////
////
//
//    }
//
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        //you can set the title for your toolbar here for different fragments different titles
//        getActivity().setTitle("Menu 1");
//        setHasOptionsMenu(true);
//    }
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//                MySQLiteOpenHelper db=new MySQLiteOpenHelper(getContext());
//
//        super.onCreate(savedInstanceState);
//        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        //setContentView(R.layout.activity_user_services);
//        //setContentView(R.layout.activity_navigation_drawer);
//        List<Fragment> fragments = new Vector<>();
//
//        fragments.add(Fragment.instantiate(getContext(),UserServicesDashboard.class.getName()));
//        fragments.add(Fragment.instantiate(getContext(),UserServicesSuggested.class.getName()));
//        fragments.add(Fragment.instantiate(getContext(),UserServicesAllUni.class.getName()));
//
//        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager(),fragments);
//
//        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.myPager);
//
//        viewPager.setAdapter(pagerAdapter);
//
//        final ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        ActionBar.TabListener tabListener = new ActionBar.TabListener()
//        {
//            @Override
//            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
//            {
//
//            }
//
//            @Override
//            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
//            {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
//            {
//
//            }
//        };
//
//        actionBar.addTab(actionBar.newTab().setText("Dashboard").setTabListener(tabListener));
//        actionBar.addTab(actionBar.newTab().setText("Suggested Universities").setTabListener(tabListener));
//        actionBar.addTab(actionBar.newTab().setText("All University").setTabListener(tabListener));
//        setHasOptionsMenu(true);
//    }
//}
//
public class pore_delete1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.pore_delete1, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Menu 2");
    }
}

