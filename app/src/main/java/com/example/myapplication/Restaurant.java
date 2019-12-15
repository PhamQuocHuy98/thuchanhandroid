package com.example.myapplication;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class Restaurant {
    private String name="";
    private String address="";
    private String type="";
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return (name);
    }
    public void setAddress(String address)
    {
        this.address = address;}
    public String getAddress()
    {
        return (address);
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getType()
    {
        return (type);
    }

    @NonNull
    @Override
    public String toString() {
        return name+" "+" "+ address+" "+type;
    }

}
