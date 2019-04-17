package reflect;

import annotation.Pro;

import java.lang.reflect.Method;


@Pro(className = "domain.Person",methodName = "eat")
public class AnnotationText {

    public static void main(String[] args) throws Exception {


        /* getAnnotation(Class)
        //其实就是在内存中生成了一个该注解接口的子类实现对象

        public class ProImpl implements Pro{
            public String className(){
                return "cn.itcast.annotation.Demo1";
            }
            public String methodName(){
                return "show";
            }
        }*/
        Class<AnnotationText> annotationTextClass = AnnotationText.class;
        Pro annotation = annotationTextClass.getAnnotation(Pro.class);


        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);
        System.out.println("------------------------------");


        //3. 使用反射技术来加载类文件进内存
        Class  cls = Class.forName(className);


        //4. 创建对象
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);


        //5.执行方法
        method.invoke(obj);


    }



}
