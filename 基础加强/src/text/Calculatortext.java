package text;

import Junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Calculatortext {
  /*
   初始化方法
   用来进行资源的申请，所有测试方法执行前都会执行该方法
   */
  @Before
   public void init()
   {
       System.out.println("init");
   }
   @After
   public void colse()
   {
       System.out.println("colse");
   }



    //测试add方法
    @Test
    public void testadd()
    {
        Calculator add=new Calculator();
        int result=add.add(1,2);
        System.out.println(result);
        //断言
        Assert.assertEquals(3,result);
    }
    //测试sub方法
    @Test
    public void subadd()
    {
        Calculator sub=new Calculator();
        int result=sub.sub(1,2);
        System.out.println(result);
        //断言
       // Assert.assertEquals(3,result);
    }

}
