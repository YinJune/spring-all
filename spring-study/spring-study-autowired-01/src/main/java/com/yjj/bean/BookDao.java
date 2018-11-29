package com.yjj.bean;

import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/26 17:51
 * @Version: 1.0
 */
@Repository
public class BookDao {
    private String lable="1";
    private Car car;

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
