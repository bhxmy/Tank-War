package com.company;
import java.util.Scanner;
public class A1013 {
    public static void main(String[] args) {
        System.out.println("请输入会员积分：");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();// ctrl alt v 自动赋值
        System.out.println(score);
        if (score < 2000) {
            System.out.println("9折");
        } else if (score < 4000) {
            System.out.println("8折");
        }
    }
}
/*int money=(int)(Math.random()*1000);
System.out.println("money是"+money);
String level= (int)(Math.random()*2)==0?"会员":"普通";
if(money<300){
    System.out.println("您没有折扣");
}else if(money>=300&&money<600){
    System.out.println("恭喜您享有折扣");
    if(level=="会员"){
        System.out.println("会员8折");

    }else{
        System.out.println("普通顾客9折");
    }

}else if(level=="会员"){
    System.out.println("会员75折");

}else{
    System.out.println("普通顾客9折");
}*/


