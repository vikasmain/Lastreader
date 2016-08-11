package com.example.dell.model;

/**
 * Created by dell on 5/14/2016.
 */
public class Navitem {
    private String title;
    private String subtitle;
    private int resIcon;
    public Navitem(String title,String subtitle,int resIcon)
    {
        super();
        this.title=title;
        this.subtitle=subtitle;
        this.resIcon=resIcon;
    }
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }
}
