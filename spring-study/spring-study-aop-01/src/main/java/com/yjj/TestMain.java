package com.yjj;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/28 10:18
 * @Version: 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("1", 1);
        map.put("2", 2);
        System.out.println(map);
        String[] strs={"2","2","1"};
        System.out.println(strs);

        BigDecimal amount=new BigDecimal("100.12");
        BigDecimal fAmount=amount.negate();
        BigDecimal zAmount=new BigDecimal("200");
        System.out.println(amount);
        System.out.println(fAmount);
        System.out.println(zAmount.add(fAmount));
        System.out.println(zAmount);
    }
}
