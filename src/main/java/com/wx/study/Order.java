package com.wx.study;

import java.io.Serializable;
import java.util.UUID;

/** 
 * @Description
 * @date 2013-3-20
 * @author WangXin
 */
public class Order implements Serializable
{
    private String id;
    private Book book;
    private int size;
    private float totalPrice;
    
    public Order()
    {
        super();
        this.id = UUID.randomUUID().toString();
    }

    public Order(Book book, int size)
    {
        this();
        this.book = book;
        this.size = size;
        this.setSize(size);
    }
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Book getBook()
    {
        return book;
    }
    public void setBook(Book book)
    {
        this.book = book;
    }
    public int getSize()
    {
        return size;
    }
    public void setSize(int size)
    {
        this.size = size;
        totalPrice = book.getPrice() * size;
    }
    public float getTotalPrice()
    {
        return totalPrice;
    }
    public void setTotalPrice(float totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString()
    {
        return "orderId:" + this.getId()
                + "book:" + this.getBook()
                + "size:" + this.getSize()
                + "totalPrice:" + this.getTotalPrice();
    }
    
}

