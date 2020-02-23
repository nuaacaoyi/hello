package com.atguigu.java;

//这是单行注释
public class HelloWorld {
      static   String  hobby="imooc";
      private int a=10;
    public static int m1(int i){
        if(i==1 || i==0) return 1;
        else
            return i*m1(i-1);

    }
    public static int test(){
        int divider=10;
        int result=100;
        try{
            while(divider>-1){
                result=result+100/divider;
                divider--;

            }
            return result;
        }catch(Exception e) {
            e.printStackTrace();;
            System.out.println("异常");
            return 99;
        }
        finally {
            System.out.println("最终还是要执行我");
            return 111;
        }
    }
    public static void main(String[] args){
        //System.out.println("helloworld!!");
        //ArrayList list=new ArrayList();

        System.out.println(test());

        //System.out.println(m1(5));
/*
        Scanner sc=new Scanner(System.in);
        int one;
        int two;
        try{
            System.out.println("请输入第一个整数");

            one=sc.nextInt();
            System.out.println("请输入第二个整数");
            two=sc.nextInt();
            System.out.println("两者相除等于"+one/two);
        }catch (InputMismatchException e)
        {
            System.out.println("请输入数字");
        }
        catch (ArithmeticException e)
        {
            System.out.println("除数为0");
        }*/
        /*Telphone tel = new Telphone(1,2,3);
        tel.setScreen(6.0f);
        tel.message();*/
     /*  // 多态
       HashMap<String,String> map=new HashMap<>();
        map.put("name","Tom");
        map.put("age","12");

        map.put("school","Tsinghua");
        map.put("major","computer");

        String age=map.get("age");
        System.out.println(age);

        map.remove("major");
        System.out.println(map);*/


        /**
        System.out.println("通过类名访问hobby  "+HelloWorld.hobby);

        HelloWorld he = new HelloWorld();
        System.out.println("通过对象访问hobby  "+he.hobby);
        he.hobby="imooc-java";
        System.out.println("通过类名访问hobby  "+HelloWorld.hobby);
         */

    }
}
