package com.he.pojo;/*
@author he
@creat 2022-05-18-11:02
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private  int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
