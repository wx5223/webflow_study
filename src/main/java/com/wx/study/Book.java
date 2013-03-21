package com.wx.study;

import java.io.Serializable;

/** 
 * @Description
 * @date 2013-3-19
 * @author WangXin
 */
public class Book implements Serializable
{
    private int id;
    private String name;
    private float price;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public float getPrice()
    {
        return price;
    }
    public void setPrice(float price)
    {
        this.price = price;
    }
    
    public Book(int id, String name, float price)
    {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Book()
    {
        super();
    }
    @Override
    public String toString()
    {
        return this.getId() + ":" + this.getName() + ":" + this.getPrice();
    }
    
}

