package reflect;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectText {
    public static void main(String[] args) throws Exception {


       /* 	* 案例：
		* 需求：写一个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法
                * 实现：
        1. 配置文件
        2. 反射
                * 步骤：
        1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
        2. 在程序中加载读取配置文件
        3. 使用反射技术来加载类文件进内存
        4. 创建对象
        5. 执行方法

      */

        //创建Properties对象
        Properties pro=new Properties();
        //获取配置文件路径
        ClassLoader classLoader=    ReflectText.class.getClassLoader();
        //获取指定文件名的内容转换成字符流
        InputStream in= classLoader.getResourceAsStream("pro.properties");
        pro.load(in);
        //  2. 在程序中加载读取配置文件
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");


        //3. 使用反射技术来加载类文件进内存
        Class  cls = Class.forName(className);


        //4. 创建对象
        Object obj = cls.newInstance();

        Method method = cls.getMethod(methodName);


        //5.执行方法
        method.invoke(obj);


    }
}
