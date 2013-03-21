package com.wx.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @Description 购买记录
 * @date 2013-3-19
 * @author WangXin
 */
@Component
public class Record
{
    private Map<String, Order> orders = new HashMap<String, Order>();

    public void add(Order order)
    {
        orders.put(order.getId(), order);
    }

    public List<Order> list()
    {
        List<Order> list = new ArrayList<Order>();
        for (Order order : orders.values())
        {
            list.add(order);
        }
        return list;
    }
}
