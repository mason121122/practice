package com.practice.web.test;

import com.alibaba.fastjson.JSONObject;
import com.practice.model.bo.UserBo;
import com.practice.model.bo.UserTestBo;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Mark Wang
 * @date 2022/4/21 15:01
 */
public class test01 {

    public static void main(String[] args) throws Exception {
        List<UserTestBo> userBoList = new ArrayList<>();
//        for (int i = 0;i<2;i++){
//            UserTestBo userBo = new UserTestBo();
//            userBo.setString("123");
//            userBo.setId(1L);
//            userBoList.add(userBo);
//        }
        UserTestBo userBo1 = new UserTestBo();
        userBoList.add(userBo1);

        for (UserTestBo userBo:userBoList) {
            System.out.println(JSONObject.toJSONString(userBo));
            if(isObjectFieldEmpty(userBo)){
                System.out.println("111111");
            }
        }
    }


    /**
     *判断一个实体类对象实例的所有成员变量是否为空(此方法仅适用几个封装类适用时需注意)
     *@param obj 校验的类对象实例
     *@return List
     *@throws Exception
     */

    public static boolean isObjectFieldEmpty(Object obj) throws Exception {
        Class<?> clazz=obj.getClass(); //得到类对象
        Field[] fs=clazz.getDeclaredFields(); //得到属性集合
        List<String> list=new ArrayList<>();
        int count = fs.length;
        for(Field field:fs){      //遍历属性
            field.setAccessible(true); //设置属性是可以访问的（私有的也可以）
            String nameTypeName = field.getType().getTypeName();
            switch (nameTypeName){
                case "java.lang.String":
                    if(StringUtils.isEmpty((CharSequence) field.get(obj))){
                        String name=field.getName();
                        list.add(name);
                    }
                    break;
                case "java.lang.Long":
                    if(null == field.get(obj) || 0 == (Long)field.get(obj) ){
                        String name=field.getName();
                        list.add(name);
                    }
                    break;
                case "java.lang.Double":
                    if(null == field.get(obj) || 0.00 == (Double) field.get(obj)){
                        String name=field.getName();
                        list.add(name);
                    }
                    break;
                case "java.math.BigDecimal":
                case "boolean":
                case "java.time.LocalDate":
                case "java.time.LocalDateTime":
                case "java.util.Date":
                case "java.lang.Float":
                    count=count-1;
                    break;
                case "java.lang.Integer":
                    if(null == field.get(obj) || 0 == (int)field.get(obj)){
                        String name=field.getName();
                        list.add(name);
                    }
                    break;
                default:
                    if(null == field.get(obj)){
                        String name=field.getName();
                        list.add(name);
                    }
            }

        }
        if(list.size() == count){
            return true;
        }else {
            return false;
        }
    }

}
