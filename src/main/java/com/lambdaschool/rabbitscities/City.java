package com.lambdaschool.rabbitscities;


import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class City
{
    private @Id @GeneratedValue Long id;
    private String cityname;
    private double homeprice;
    private int index;

    public City()
    {
        //default constructor
    }

    public City(String cityname, double homeprice, int index)
    {
        this.cityname = cityname;
        this.homeprice = homeprice;
        this.index = index;
    }
}


