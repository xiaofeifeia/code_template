package com.itheima.code.build;

import java.util.Map;

/****
 * @Author:shenkunlin
 * @Description:Entity构建
 * @Date 2019/6/14 19:13
 *****/
public class EntityBuilder {


    /***
     * 构建Entity
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel){
        //生成Entity层文件
        BuilderFactory.builder(dataModel,
                "/template/entity",
                "Entity.java",
                TemplateBuilder.PACKAGE_ENTITY,
                ".java");
    }

}
