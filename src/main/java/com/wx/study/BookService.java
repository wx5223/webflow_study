package com.wx.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @date 2013-3-19
 * @author WangXin
 */
@Component
public class BookService
{
    private Map<Integer, Book> books = new HashMap<Integer, Book>();

    public void init()
    {
        books.put(1, new Book(1, "spring深入解析", 56.00f));
        books.put(2, new Book(2, "hibernate内幕", 33.00f));
        books.put(3, new Book(3, "CGLib自学手册", 78.50f));
    }

    public void add(Book book)
    {
        books.put(book.getId(), book);
    }
    
    public void remove(Integer id) {
        books.remove(id);
    }

    public List<Book> list()
    {
        List<Book> list = new ArrayList<Book>();
        for (Book book : books.values())
        {
            list.add(book);
        }
        return list;
    }

    public Book getById(Integer id)
    {
        return books.get(id);
    }
}
