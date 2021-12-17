/*淡旺季机票的价格，原价机票价格为5000
  淡季头等舱打5折，经济舱打4折
  旺季头等舱打9折，经济舱打8折
  要求：
  输入任意的月份与舱位来计算机票的价格
  1代表头等舱，2代表经济舱
  4-10月为旺季，其他月份为淡季
 */

package com.company;
import java.util.Scanner;
public class TicketDiscount {
    public static void main(String[] args){
        int price=5000,np;
        System.out.println("请输入月份：");
        Scanner sc=new Scanner(System.in);
        int month =sc.nextInt();
        System.out.println("请输入舱位，1代表头等舱，2代表经济舱");
        int place =sc.nextInt();
        if(place ==1){
            System.out.println(month+"月份"+"头等舱");
        }else{
            System.out.println(month+"月份"+"经济舱");
        }
        if(month>=4&&month<=10){
             switch(place){
                 case 1 :
                     np=(int)(price*0.9);
                     break;
                 default:
                     np=(int)(price*0.8);
             }
        }else {
            switch(place){
                case 1 :
                    np=(int)(price*0.5);
                    break;
                default:
                    np=(int)(price*0.4);
            }
        }
System.out.println("机票价格是："+np);



    }
}
