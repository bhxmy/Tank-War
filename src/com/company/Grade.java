package com.company;
import java.util.Scanner;
public class Grade {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int score=0;
        int sum=0;
        System.out.print("输入学生姓名："+'\t');
        String name=sc.nextLine();
        for(int i=1;i<=5;i++){
            System.out.print("请输入第"+i+"门课的成绩："+'\t');
            score = sc.nextInt();
            if (score<0) {
                System.out.println("抱歉，分数录入错误，请重新进行录入！");
                break;
            }else{
                sum=sum+score;
            }
        //..................... 这里可以选择当输出5个成绩的时候才能计算平均成绩
            if(i==5){
            System.out.println(name+"的平均分是："+(int)(sum/5));
            }
    }
    }
}
