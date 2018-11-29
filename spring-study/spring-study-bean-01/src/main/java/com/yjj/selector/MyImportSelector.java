package com.yjj.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/22 15:52
 * @Version: 1.0
 */
public class MyImportSelector implements ImportSelector {

    /**
     * 返回值就是导入到容器中的组件全类名
     * @param annotationMetadata 当前标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //方法不能返回null，可以返回空数组
        return new String[]{"com.yjj.importBean.Black","com.yjj.importBean.White"};
    }
}
