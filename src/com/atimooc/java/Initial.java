package com.atimooc.java;

/**
 * @author CY_JFXX
 * @create 2020-02-14 14:39
 */
public class Initial {
    public static void main(String[] args) {
       /* 计算周常和面积
       Shape s=new Rectangele();
        System.out.println("请输入长度");
        Scanner sc=new Scanner(System.in);
        int chang=sc.nextInt();
        int kuan=sc.nextInt();
        System.out.println("周长是："+s.zhouChangh(chang,kuan));*/
        //抽象类中手机测试
//       Phone ph=new CellPhone();
//        ph.call();
//        ph.message();
//        Phone ph1=new SmartPhone();
//        ph1.call();
//        ph1.message();

        IPlayGame ip1=new SmartPhone();
        IPlayGame ip2=new Psp();
        ip1.playGame();
        ip2.playGame();
     /* 多态的运用
        Dog dog=new Dog();
        //dog.age=10;
        dog.name="xixo";
        //dog.method();
        //System.out.println(dog.age);
        //System.out.println(dog);
        Aniaml obj1= new Aniaml();
        Aniaml obj2= new Dog();
        Aniaml obj3 =new cat();
        obj1.eat();
        obj2.eat();
        obj3.eat();*/

    }
}
