package com.he.controller;/*
@author he
@creat 2022-05-18-15:03
*/

import com.he.pojo.Books;
import com.he.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller调用Service层创建一个BookService对象
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);//将list存放在model中
        return "allBook";//返回到allBook页面
    }
    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        int i = bookService.addBook(books);
        if(i>0)
        {
            System.out.println("添加成功"+books);
        }
        return "redirect:/book/allBook";//@RequestMapping("/book/allBook")
    }

    //跳转到修改书籍页面
    @RequestMapping(path = "/toUpdate/{bookId}")
    public String toUpdatePaper(@PathVariable("bookId") int id, Model model){
        Books book = bookService.queryBookById(id);
        System.out.println(book);
        model.addAttribute("book",book);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("===>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";//这个链接自带查询功能，会调用之前的list方法
    }


    //添加删除书籍请求
    @RequestMapping(path = "/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookID){
        bookService.deleteBookById(bookID);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBook(queryBookName);
        List<Books> list =new ArrayList<Books>();
        if(books==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未查询到书籍信息");
        }else{
            list.add(books);
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
