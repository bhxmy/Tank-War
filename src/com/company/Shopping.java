package com.company;
import java.util.Scanner;
public class Shopping {

    public static void main(String[] args){
        char flag='y';
        String tmp;
        int id=0;
        int nb=0;
        int p1=245,p2=570,p3=320;
        double sum=0;

        Scanner sc= new Scanner(System.in);

        System.out.println("**********************************");
        System.out.println("请选择购买的商品编号：");
        System.out.println("1.T恤"+'\t'+"2.网球鞋" +'\t'+'\t'+"3.网球拍");
        System.out.println("**********************************");

    while(flag=='y') {
        System.out.println("请输入商品编号：");
        id = sc.nextInt();
        System.out.println("请输入购买数量：");
        nb = sc.nextInt();

        switch (id) {
            case 1:
                System.out.println("T恤  ￥" + p1 + '\t' + "数量：" + nb + '\t' + "合计：" + sum);
                sum=p1*nb;
                break;
            case 2:
                System.out.println("网球鞋￥" + p2 + '\t' + "数量：" + nb + '\t' + "合计：" + sum);
                sum=p2*nb;
                break;
            case 3:
                System.out.println("网球拍￥" + p3 + '\t' + "数量：" + nb + '\t' + "合计：" + sum);
                sum=p3*nb;
                break;
            //default:
            //System.out.println("商品输入有误，请重新输入");
        }
        System.out.println("是否继续(y/n)");

        System.out.print("是否继续y/n:");

        //tmp = sc.next();
        //flag = tmp.charAt(0);
       // System.out.println(flag);
        tmp = sc.next();
          flag = tmp.charAt(0);
          System.out.println(flag);

        //char[] choose = ch.toCharArray();    //输入y/n
        //System.out.println(choose);        //
    }



        System.out.println("折扣0.8");
        System.out.println("应付金额："+sum);






    }


}
