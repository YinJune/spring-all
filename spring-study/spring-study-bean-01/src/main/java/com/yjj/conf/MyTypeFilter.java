package com.yjj.conf;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2018/11/20 16:09
 * @Version: 1.0
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * 如果被扫描的类经过此方法运算返回true表示可被注入，false不被注入
     * @param metadataReader 可以获取当前类的信息
     * @param metadataReaderFactory 可以获取到其他任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解的信息
        AnnotationMetadata annotationMetadata=metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类的类信息
        ClassMetadata classMetadata= metadataReader.getClassMetadata();
        // 获取当前类资源（类的路径）
        Resource resource=metadataReader.getResource();
        //当前类的类名
        String className=classMetadata.getClassName();
        System.out.println("className"+className);
        if (className.contains("er")){
            return true;
        }
        return false;
    }
}
