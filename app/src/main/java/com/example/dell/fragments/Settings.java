package com.example.dell.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import com.example.dell.adapters.Myfragmentpageradapter;
import com.example.dell.inner.fragments.fragment2;
import com.example.dell.inner.fragments.fragment3;
import com.example.dell.inner.fragments.fragment5;
import com.example.dell.reader.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 5/14/2016.
 */
@SuppressWarnings("deprecation")
public class Settings extends Fragment implements ViewPager.OnPageChangeListener,TabHost.OnTabChangeListener{
    private ViewPager vg;
    private TabHost tabhost;
    int i=0;
    View v;
    private Myfragmentpageradapter m;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.tabp,container,false);
        i++;
        this.inittabHost();
        this.initviewpager();
        return v;
    }
    class FakeContent implements TabHost.TabContentFactory{
        Context context;
        public FakeContent(Context mcontext){
            context=mcontext;
        }
        @Override
        public View createTabContent(String tag) {
            View fakeview=new View(context);
            fakeview.setMinimumHeight(0);
            fakeview.setMinimumWidth(0);
            return fakeview;
        }
    }

    private void inittabHost() {
        tabhost=(TabHost) v.findViewById(android.R.id.tabhost);
        tabhost.setup();
        String[] tabnames={"Mathmatics","Physics","Chemistry","English","Computer science","Physical"};
        for (int i=0;i<tabnames.length;i++)
        {
            TabHost.TabSpec tabspec;
            tabspec=tabhost.newTabSpec(tabnames[i]);
            tabspec.setIndicator(tabnames[i]);
            tabspec.setContent(new FakeContent(getActivity()));
            tabhost.addTab(tabspec);

        }
        tabhost.setOnTabChangedListener(this);

    }
    private void initviewpager() {
        vg = (ViewPager) v.findViewById(R.id.view_pager);
        List<Fragment> listfragments = new ArrayList<Fragment>();
        listfragments.add(new fragment2());
        listfragments.add(new fragment2());
        listfragments.add(new fragment3());
        listfragments.add(new fragment2());
        listfragments.add(new fragment5());
        listfragments.add(new fragment3());
        Myfragmentpageradapter m = new Myfragmentpageradapter(getChildFragmentManager(), listfragments);
        vg.setAdapter(m);
        vg.setOnPageChangeListener(this);
    }

    //viewpagerlisteners

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectedpage) {
        tabhost.setCurrentTab(selectedpage);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    //tabhostlistenres
    @Override
    public void onTabChanged(String tabId) {
        int selectedpage=tabhost.getCurrentTab();
        vg.setCurrentItem(selectedpage);
        HorizontalScrollView horiz=(HorizontalScrollView) v.findViewById(R.id.h_scroll_view);
        View tabview=tabhost.getCurrentTabView();
        int scrollpos=tabview.getLeft()-(horiz.getWidth()-tabview.getWidth())/2;
        horiz.smoothScrollTo(scrollpos,0);
    }

}
