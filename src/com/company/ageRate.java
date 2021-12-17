package com.company;
import java.util.Scanner;
public class ageRate {
         public static void main(String[] args){
             Scanner sc=new Scanner(System.in);
             int ageUp=0;
             int ageDown=0;
             for(int i=1;i<=10;i++){
                 System.out.print("请输入第"+i+"位顾客的年龄：");
                 int age= sc.nextInt();
                 if(age>30){
                     ageUp++;
                 }else{
                     ageDown++;
                 }
             }
             System.out.println("30岁以上的比例是："+(ageUp/10.0*100+"%"));
             System.out.println("30岁以下的比例是："+(ageDown/10.0*100+"%"));
         }
}