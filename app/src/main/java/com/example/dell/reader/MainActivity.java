package com.example.dell.reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.dell.adapters.NavListadapters;
import com.example.dell.fragments.About;
import com.example.dell.fragments.Home;
import com.example.dell.fragments.Humk;
import com.example.dell.fragments.Settings;
import com.example.dell.fragments.classten;
import com.example.dell.model.Navitem;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {
    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    ListView lvNav;
    List<Navitem> navitemList;
    List<Fragment> fragmentList;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout=(DrawerLayout) findViewById(R.id.Drawer_pane);
        drawerPane=(RelativeLayout) findViewById(R.id.drawer_pane);
        lvNav=(ListView) findViewById(R.id.list_view);
        navitemList=new ArrayList<Navitem>();
        navitemList.add(new Navitem("Home","Home page",R.drawable.latte));
        navitemList.add(new Navitem("12 Science","change something",R.drawable.latte));
        navitemList.add(new Navitem("12 Commerce","tell here",R.drawable.latte));
        navitemList.add(new Navitem("12 humanites","tell here",R.drawable.latte));
        navitemList.add(new Navitem("10 class","tell here",R.drawable.latte));

        NavListadapters navListadapters=new NavListadapters(getApplicationContext(),R.layout.item_nav_list,navitemList);
        lvNav.setAdapter(navListadapters);
        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new Home());
        fragmentList.add(new Settings());
        fragmentList.add(new About());
        fragmentList.add(new Humk());
        fragmentList.add(new classten());

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content,fragmentList.get(0)).commit();
        setTitle(navitemList.get(0).getTitle());
        lvNav.setItemChecked(0,true);
        drawerLayout.closeDrawer(drawerPane);
        lvNav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content,fragmentList.get(position)).commit();
                setTitle(navitemList.get(position).getTitle());
                lvNav.setItemChecked(position,true);
                drawerLayout.closeDrawer(drawerPane);
            }
        });
        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout, R.string.drawer_opened,R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        RelativeLayout relativeLayout;
        relativeLayout=(RelativeLayout) findViewById(R.id.main_content);
        switch (item.getItemId()){
            case R.id.green:
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case R.id.blue:
                startActivity(new Intent(this, calc.class));

break;

        }
        return true;
    }



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }
}
