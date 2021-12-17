package com.company;

import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入购买的商品编号：");
        System.out.println("1.T恤" + "\t" + "2.网球鞋" + "\t" + "3.网球拍" + "\t");
        System.out.println("**************************************************");

        char flag = 'y';
        int number = 0;
        int id = 0;
        double sum = 0;
        int count = 0;

        while(flag == 'y'){

            System.out.print("请输入商品编号：");
            id = sc.nextInt();
            System.out.print("请输入购买数量：");
            number = sc.nextInt();

            count += number;

            switch(id){

                case 1:
                    System.out.println("T恤￥245.0" + "\t" + "数量 " + number + "\t" + "合计 ￥" + (245.0 * number));
                    sum += 245.0 * number;
                    break;
                case 2:
                    System.out.println("网球鞋￥570.0" + "\t" + "数量 " + number + "\t" + "合计 ￥" + (570.0 * number));
                    sum += 570.0 * number;
                    break;
                case 3:
                    System.out.println("网球拍￥320.0" + "\t" + "数量 " + number + "\t" + "合计 ￥" + (320.0 * number));
                    sum += 320.0 * number;
                    break;
                default:
                    System.out.println("商品编号输入有误，请确认是否重新输入！");
            }

            System.out.print("是否继续y/n:");
           String tmp = sc.next();
            flag = tmp.charAt(0);
            System.out.println();
        }

        sum = sum * 0.8;
        System.out.print("折扣：0.8" + "\n" + "应付金额：" + sum + "\n" + "实付金额：");
        double money = sc.nextDouble();


        while(sum > money){

            System.out.print("您输入的金额小于应付金额，请重新输入：");
            money = sc.nextDouble();
        }
        System.out.println("找钱：" + (money - sum));
    }
}