package com.yjj.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/26 17:51
 * @Version: 1.0
 */
@Service
public class BookService {
//    @Qualifier(value = "bookDao2")
    @Autowired(required = false)
    private BookDao bookDao;

    public void print(){
        System.out.println(bookDao.toString());
    }
}
