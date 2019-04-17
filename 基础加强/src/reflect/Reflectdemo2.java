package reflect;

import domain.Person;

import java.lang.reflect.Field;

public class Reflectdemo2 {
    public static void main(String[] args) throws Exception {

         Class personClass= Person.class;
        /*1. 获取成员变量们
                * Field[] getFields() ：获取所有public修饰的成员变量
                * Field getField(String name)   获取指定名称的 public修饰的成员变量

				* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
                * Field getDeclaredField(String name)*/

        // * Field[] getFields() ：获取所有public修饰的成员变量
         Field[] files= personClass.getFields();
         for (Field filed:files)
         {
             System.out.println(filed);
         }
        System.out.println("----------------------------------");
        //Field getField(String name)   获取指定名称的 public修饰的成员变量
         Field a=personClass.getField("a");
         //获取成员变量a的值
         Person p=new Person();
         Object value= a.get(p);
         System.out.println(value);
         //设置a的值
         a.set(p,"Csqin");
         System.out.println(p);
         System.out.println("----------------------------------");
        //* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
        Field[] declaredFields= personClass.getDeclaredFields();
        for (Field field:declaredFields) {
            System.out.println(field);
        }
        Field d= personClass.getDeclaredField("d");
       // 忽略访问权限修饰符的安全检查
        // * setAccessible(true):暴力反射
        d.setAccessible(true);
        Object value2= d.get(p);
        System.out.println(value2);
        //b.set(p,"123");

    }
}
