package com.teampolaris.admisson;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.util.List;
import java.util.Vector;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
public class UserServices extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        MySQLiteOpenHelper db=new MySQLiteOpenHelper(this);
//
//        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        //setContentView(R.layout.activity_user_services);
//        setContentView(R.layout.activity_navigation_drawer);
////        List<Fragment> fragments = new Vector<>();
////
////        fragments.add(Fragment.instantiate(this,UserServicesDashboard.class.getName()));
////        fragments.add(Fragment.instantiate(this,UserServicesSuggested.class.getName()));
////        fragments.add(Fragment.instantiate(this,UserServicesAllUni.class.getName()));
////
////        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),fragments);
////
////        final ViewPager viewPager = (ViewPager) findViewById(R.id.myPager);
////
////        viewPager.setAdapter(pagerAdapter);
////
////        final ActionBar actionBar = getSupportActionBar();
////        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
////        ActionBar.TabListener tabListener = new ActionBar.TabListener()
////        {
////            @Override
////            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
////            {
////
////            }
////
////            @Override
////            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
////            {
////                viewPager.setCurrentItem(tab.getPosition());
////            }
////
////            @Override
////            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
////            {
////
////            }
////        };
////
////        actionBar.addTab(actionBar.newTab().setText("Dashboard").setTabListener(tabListener));
////        actionBar.addTab(actionBar.newTab().setText("Suggested Universities").setTabListener(tabListener));
////        actionBar.addTab(actionBar.newTab().setText("All University").setTabListener(tabListener));
//
//
//        //navigation drawer ***************************************************
//
//        //setContentView(R.layout.activity_navigation_drawer);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//        displaySelectedScreen(R.id.nav_gallery);
//       ///////////////////////////////////////////////////////////////
////        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
////        tx.replace(R.id.content_frame, new pore_delete1());
////        tx.commit();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        displaySelectedScreen(R.id.nav_home);

    }

    public void dashUpdate(View view)
    {
        Toast.makeText(UserServices.this, "updating", Toast.LENGTH_LONG).show();
        try {
            //// added on 1-15-16
            recieveFeed rf=new recieveFeed(this);

            rf.getFeed();
            Intent intent = new Intent(this,UserServices.class);
            startActivity(intent);
            ////
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (mHandler != null) { mHandler.removeCallbacks(backPressHandle); }
    }
    public Runnable backPressHandle=new Runnable() {
        @Override
        public void run() {
              backPressedOnce=false;
        }
    };
    private final Handler mHandler=new Handler();
    private boolean backPressedOnce=false;
    /*@Override
    public void onBackPressed() {
        if(backPressedOnce){
            super.onBackPressed();
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }else{
            backPressedOnce=true;
            Toast.makeText(this,"press again to exit",Toast.LENGTH_SHORT).show();
            mHandler.postDelayed(backPressHandle,2000);
        }
    }*/

    /*@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_home:
                fragment = new pore_delete1();
                break;
            case R.id.nav_profile:
                fragment = new poreDelete2();
                break;


        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
        //calling the method displayselectedscreen and passing the id of selected menu
         displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

}
////package com.teampolaris.admisson;
////
////import android.content.Intent;
////import android.os.Bundle;
////import android.os.Handler;
////import android.support.v4.app.Fragment;
////import android.support.v4.app.FragmentTransaction;
////import android.support.v4.view.ViewPager;
////import android.support.v7.app.ActionBar;
////import android.support.v7.app.AppCompatActivity;
////import android.view.View;
////import android.view.Window;
////import android.widget.Toast;
////
////import java.util.List;
////import java.util.Vector;
////import android.os.Bundle;
////import android.support.design.widget.FloatingActionButton;
////import android.support.design.widget.Snackbar;
////import android.view.View;
////import android.support.design.widget.NavigationView;
////import android.support.v4.view.GravityCompat;
////import android.support.v4.widget.DrawerLayout;
////import android.support.v7.app.ActionBarDrawerToggle;
////import android.support.v7.app.AppCompatActivity;
////import android.support.v7.widget.Toolbar;
////import android.view.Menu;
////import android.view.MenuItem;
////public class UserServices extends AppCompatActivity
////        implements NavigationView.OnNavigationItemSelectedListener{
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
//////        MySQLiteOpenHelper db=new MySQLiteOpenHelper(this);
//////
//////        super.onCreate(savedInstanceState);
//////        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//////        //setContentView(R.layout.activity_user_services);
//////        setContentView(R.layout.activity_navigation_drawer);
////////        List<Fragment> fragments = new Vector<>();
////////
////////        fragments.add(Fragment.instantiate(this,UserServicesDashboard.class.getName()));
////////        fragments.add(Fragment.instantiate(this,UserServicesSuggested.class.getName()));
////////        fragments.add(Fragment.instantiate(this,UserServicesAllUni.class.getName()));
////////
////////        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),fragments);
////////
////////        final ViewPager viewPager = (ViewPager) findViewById(R.id.myPager);
////////
////////        viewPager.setAdapter(pagerAdapter);
////////
////////        final ActionBar actionBar = getSupportActionBar();
////////        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
////////        ActionBar.TabListener tabListener = new ActionBar.TabListener()
////////        {
////////            @Override
////////            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
////////            {
////////
////////            }
////////
////////            @Override
////////            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
////////            {
////////                viewPager.setCurrentItem(tab.getPosition());
////////            }
////////
////////            @Override
////////            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
////////            {
////////
////////            }
////////        };
////////
////////        actionBar.addTab(actionBar.newTab().setText("Dashboard").setTabListener(tabListener));
////////        actionBar.addTab(actionBar.newTab().setText("Suggested Universities").setTabListener(tabListener));
////////        actionBar.addTab(actionBar.newTab().setText("All University").setTabListener(tabListener));
//////
//////
//////        //navigation drawer ***************************************************
//////
//////        //setContentView(R.layout.activity_navigation_drawer);
//////        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//////        setSupportActionBar(toolbar);
//////
//////        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//////        fab.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View view) {
//////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//////                        .setAction("Action", null).show();
//////            }
//////        });
//////
//////        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//////        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//////                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//////        drawer.addDrawerListener(toggle);
//////        toggle.syncState();
//////
//////        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//////        navigationView.setNavigationItemSelectedListener(this);
//////        displaySelectedScreen(R.id.nav_gallery);
//////       ///////////////////////////////////////////////////////////////
////////        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
////////        tx.replace(R.id.content_frame, new pore_delete1());
////////        tx.commit();
////
////
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_navigation_drawer);
////        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        //setSupportActionBar(toolbar);
////
////        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////            }
////        });
////
////        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
////        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
////                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
////        drawer.setDrawerListener(toggle);
////        toggle.syncState();
////
////        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
////        navigationView.setNavigationItemSelectedListener(this);
////
////    }
////
////    public void dashUpdate(View view)
////    {
////        Toast.makeText(UserServices.this, "updating", Toast.LENGTH_LONG).show();
////        try {
////            //// added on 1-15-16
////            recieveFeed rf=new recieveFeed(this);
////
////            rf.getFeed();
////            Intent intent = new Intent(this,UserServices.class);
////            startActivity(intent);
////            ////
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////    }
////    @Override
////    protected void onDestroy()
////    {
////        super.onDestroy();
////
////        if (mHandler != null) { mHandler.removeCallbacks(backPressHandle); }
////    }
////    public Runnable backPressHandle=new Runnable() {
////        @Override
////        public void run() {
////              backPressedOnce=false;
////        }
////    };
////    private final Handler mHandler=new Handler();
////    private boolean backPressedOnce=false;
////    /*@Override
////    public void onBackPressed() {
////        if(backPressedOnce){
////            super.onBackPressed();
////            moveTaskToBack(true);
////            android.os.Process.killProcess(android.os.Process.myPid());
////            System.exit(1);
////        }else{
////            backPressedOnce=true;
////            Toast.makeText(this,"press again to exit",Toast.LENGTH_SHORT).show();
////            mHandler.postDelayed(backPressHandle,2000);
////        }
////    }*/
////
////    /*@Override
////    public boolean onNavigationItemSelected(MenuItem item) {
////        return false;
////    }*/
////    @Override
////    public void onBackPressed() {
////        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
////        if (drawer.isDrawerOpen(GravityCompat.START)) {
////            drawer.closeDrawer(GravityCompat.START);
////        } else {
////            super.onBackPressed();
////        }
////    }
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
////        return true;
////    }
////
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        // Handle action bar item clicks here. The action bar will
////        // automatically handle clicks on the Home/Up button, so long
////        // as you specify a parent activity in AndroidManifest.xml.
////        int id = item.getItemId();
////
////        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
////
////        return super.onOptionsItemSelected(item);
////    }
////
////
////    private void displaySelectedScreen(int itemId) {
////
////        //creating fragment object
////        Fragment fragment = null;
////
////        //initializing the fragment object which is selected
////        switch (itemId) {
////            case R.id.nav_gallery:
////                fragment = new pore_delete1();
////                break;
////            case R.id.nav_slideshow:
////                fragment = new poreDelete2();
////                break;
////
////
////        }
////
////        //replacing the fragment
////        if (fragment != null) {
////            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
////            ft.replace(R.id.content_frame, fragment);
////            ft.commit();
////        }
////
////        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
////        drawer.closeDrawer(GravityCompat.START);
////    }
////    @SuppressWarnings("StatementWithEmptyBody")
////    @Override
////    public boolean onNavigationItemSelected(MenuItem item) {
////
////        // Handle navigation view item clicks here.
////        int id = item.getItemId();
////
////        if (id == R.id.nav_camera) {
////            // Handle the camera action
////        } else if (id == R.id.nav_gallery) {
////
////        } else if (id == R.id.nav_slideshow) {
////
////        } else if (id == R.id.nav_manage) {
////
////        } else if (id == R.id.nav_share) {
////
////        } else if (id == R.id.nav_send) {
////
////        }
////
////        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
////        drawer.closeDrawer(GravityCompat.START);
////        return true;
////        //calling the method displayselectedscreen and passing the id of selected menu
////        // displaySelectedScreen(item.getItemId());
////        //make this method blank
////        //return true;
////    }
////
////}
//package com.teampolaris.admisson;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.view.View;
//import android.support.design.widget.NavigationView;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//
//public class UserServices extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_navigation_drawer);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        //setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//
//}
//package com.teampolaris.admisson;
//
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.view.View;
//import android.support.design.widget.NavigationView;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//
//public class UserServices extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_nav2);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.nav2, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//}
