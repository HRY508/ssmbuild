package com.he.service;/*
@author he
@creat 2022-05-18-11:54
*/

import com.he.dao.BookMapper;
import com.he.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    //Service调用dao层：组合dao
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper){
        this.bookMapper=bookMapper;
    }
    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        System.out.println("BookServiceImpl:updateBook"+books);
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBook(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }


}
