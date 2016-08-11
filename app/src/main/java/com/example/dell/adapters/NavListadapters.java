package com.example.dell.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.model.Navitem;
import com.example.dell.reader.R;

import java.util.List;



/**
 * Created by dell on 5/14/2016.
 */
public class NavListadapters extends ArrayAdapter<Navitem> {
    Context context;
    int resLayout;
    List<Navitem> navitemList;
    public NavListadapters(Context context, int resLayout, List<Navitem> navitemList) {
        super(context,resLayout, navitemList);
        this.context=context;
        this.resLayout=resLayout;
        this.navitemList=navitemList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context,resLayout,null);
        TextView tvTitle=(TextView) v.findViewById(R.id.txt1);
        TextView tvsubtitle=(TextView) v.findViewById(R.id.txt2);
        ImageView img=(ImageView) v.findViewById(R.id.nav_icon);
        Navitem navitem=navitemList.get(position);
        tvTitle.setText(navitem.getTitle());
        tvsubtitle.setText(navitem.getSubtitle());
        img.setImageResource(navitem.getResIcon());

        return v;
    }
}

