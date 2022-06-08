package com.he.dao;/*
@author he
@creat 2022-05-18-11:17
*/

import com.he.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一本书
    int addBook(Books books);

    //删除一本书(通过Id)
    int deleteBookById(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID") int id);

    //查询全部图书
    List<Books> queryAllBook();

    //
    Books queryBookByName(@Param("bookName") String bookName);
}
