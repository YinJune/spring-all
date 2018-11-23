package com.yjj.factory;

import com.yjj.bean.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/23 15:21
 * @Version: 1.0
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个Color对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean创建Color对象...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否单例
     * @return true：单例；false：多实例，每次获取都会创建一个新实力
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
