package reflect;

import domain.Person;

import java.lang.reflect.Method;

public class Reflectdemo4 {
    public static void main(String[] args) throws Exception {

        Class personClass = Person.class;
       /*3. 获取成员方法们：
                * Method[] getMethods()
                * Method getMethod(String name, 类<?>... parameterTypes)

				* Method[] getDeclaredMethods()
                * Method getDeclaredMethod(String name, 类<?>... parameterTypes)*/

        Method methods1 = personClass.getMethod("eat");
        Person p = new Person();
        //执行方法
        methods1.invoke(p);

        Method methods2 = personClass.getMethod("eat", String.class);

        //执行方法
        methods2.invoke(p, "饭");

        System.out.println("------------------------------------");

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            // method.setAccessible(true);

        }

        System.out.println("----------------------------------");

        String    classname=personClass.getName();
        System.out.println(classname);

    }
}
