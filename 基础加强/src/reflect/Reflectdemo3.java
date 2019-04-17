package reflect;

import domain.Person;

import java.lang.reflect.Constructor;

public class Reflectdemo3 {
    public static void main(String[] args) throws Exception {

        Class personClass = Person.class;
        /*2. 获取构造方法们
                * Constructor<?>[] getConstructors()
                * Constructor<T> getConstructor(类<?>... parameterTypes)
				* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
				* Constructor<?>[] getDeclaredConstructors()*/

        //* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);

        Object peson1= constructor.newInstance("Csqin",22);
        System.out.println(peson1);

        Constructor constructor2 = personClass.getConstructor();
        Object peson2= constructor2.newInstance();
        System.out.println(peson2);

       Object peson3= personClass.newInstance();
        System.out.println(peson3);
    }
}