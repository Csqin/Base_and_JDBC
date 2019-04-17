package annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class CheckText {


    public static void main(String[] args) throws Exception {
        //创建    Calculator对象
        Calculators c=new Calculators();
        //获取Calculator里面的方法
        Method[] methods = c.getClass() .getMethods();
        //定义记录发生异常的次数，创建一个bug.txt来记录
        int number=0;
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {                              //遍历method数组

            if(method.isAnnotationPresent(Check.class))       //判断方法上是否有指定的注解
            {
                try {
                    method.invoke(c);                                      //执行方法
                } catch (Exception e) {                                    //捕获发生的异常

                    number++;                                               //记录异常发生的次数

                    bw.write(method.getName()+"方法出现异常");    //出现异常方法的名称
                    bw.newLine();
                    bw.write("异常的名称:"+e.getClass().getSimpleName()); //异常的名称
                    bw.newLine();
                    bw.write("异常的原因"+e.getCause().getMessage()); //异常的原因
                    bw.newLine();
                    bw.write("-------------------");
                    bw.newLine();
                }
            }

        }
        bw.write("本次总共出现"+number+"个异常");
        bw.flush();
        bw.close();

    }

}
