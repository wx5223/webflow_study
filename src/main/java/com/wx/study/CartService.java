package com.wx.study;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @Description 购物车
 * @date 2013-3-19
 * @author WangXin
 */
@Component
public class CartService implements Serializable
{
    private Log log = LogFactory.getLog(CartService.class);
    private List<Order> orders = new ArrayList<Order>();

    public void add(Book book)
    {
        for(Order order: orders) {
            if(order.getBook().getId() == book.getId()) {
                order.setSize(order.getSize()+1);
                return;
            }
        }
        orders.add(new Order(book, 1));
    }
    
    public void add(Order order)
    {
        orders.add(order);
    }
    
    public void remove(String orderId) {
        for(Order order: orders) {
            if(order.getId().equals(orderId)) {
                orders.remove(order);
                return;
            }
        }
    }

    public List<Order> list()
    {
        return orders;
    }
    
    public float getTotalPrice() {
        float money = 0;
        for(Order order : orders) {
            money += order.getTotalPrice();
        }
        return money;
    }
}
