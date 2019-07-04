package com.blackface.seckill.util;

/**
 * Author:lwenm
 * Description:
 * Date:2019/7/3
 * Time:22:50
 **/
public class Test {


        public static void main(String[] args) {

            String a = new String("123456"); // a 为一个引用
          
            String b = new String("12345678"); // b为另一个引用,对象的内容一样

//            String aa = "ab" ; // 放在常量池中
//            String bb = "ab"; // 从常量池中查找
//            if (aa == bb) // true
//                System.out.println("aa==bb");
//            // false，非同一对象
//            if (a == b){
//                System.out.println("a==b");
//            }else {
//                System.out.println("a！=b");
//            }


            if (a.equals(b)) // true
                System.out.println("aEQb");
//            if (42 == 42.0) { // true
//                System.out.println("true");
//            }

            System.out.println(a.hashCode()  +"    " +b.hashCode());

//            System.out.println(aa.hashCode()  +"    " +bb.hashCode());
        }

}
