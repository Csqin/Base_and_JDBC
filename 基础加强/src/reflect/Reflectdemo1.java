package reflect;

import domain.Person;

public class Reflectdemo1 {
    public static void main(String[] args) throws Exception {

          /*1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
			* 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
			*
			* */

        Class cls1  = Class.forName("domain.Person");
        System.out.println(cls1);


        //2.类名.class：通过类名的属性class获取
        //多用于参数的传递

        Class cls2 = Person.class;
        System.out.println(cls2);


          /* 3. 对象.getClass()：getClass()方法在Object类中定义着。
			* 多用于对象的获取字节码的方式
			* */
        Person p=new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);
    }
}
