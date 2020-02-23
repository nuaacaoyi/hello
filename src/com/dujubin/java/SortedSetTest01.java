package com.dujubin.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author CY_JFXX
 * @create 2020-02-19 10:16
 */
public class SortedSetTest01 {
    public static void main(String[] args) throws ParseException {
        SortedSet ss=new TreeSet();

        ss.add("10");
        ss.add("26");
        ss.add("15");
        ss.add("13");
        ss.add("8");
        ss.add("JACK");
        ss.add("LUCY");
        ss.add("BRUCE");

        Iterator it=ss.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        String s1="2008-08-08";
        String s2="2009-08-08";
        String s3="2008-08-09";
        String s4="2005-08-08";

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


            Date t1=sdf.parse(s1);
            Date t2=sdf.parse(s2);
            Date t3=sdf.parse(s3);
            Date t4=sdf.parse(s4);


        SortedSet times=new TreeSet();

        times.add(t1);
        times.add(t3);
        times.add(t4);
        times.add(t2);

        Iterator its=times.iterator();
        while (its.hasNext()){
            System.out.println(its.next());
        }


        //创建TreeSet集合的时候提供一个比较器
        SortedSet products=new TreeSet(new ProductComparator());

        Product p1=new Product(3.4);
        Product p2=new Product(1.4);
        Product p3=new Product(5.4);
        Product p4=new Product(3.2);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        Iterator ibis=products.iterator();
        while (ibis.hasNext()){
            System.out.println(ibis.next());
        }
        System.out.println("-------");

    }
}
class Product  {
    double price;

    public Product(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                '}';
    }
}
class ProductComparator implements Comparator{//推荐使用比较器方式，因为比较器可以重复使用
    public int compare(Object o1,Object o2   ) {
        double price1=((Product)o1).price;
        double price2=((Product)o2).price;
        return price1>price2?1:(price1==price2?0:-1);
    }

}