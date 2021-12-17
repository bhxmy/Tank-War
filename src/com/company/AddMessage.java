package com.company;
import java.util.Scanner;
public class AddMessage {
    public static void main(String[] args)

    {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String Id = sc.nextLine();
        System.out.println("用户名是："+ Id);

        System.out.println("请输入密码：");
        String password = sc.nextLine();
        System.out.println("密码是："+ password);
       if (Id.equals("青") && password.equals("123")){
//     if (Id=="青"&& password=="123"){
 System.out.println("欢迎您"+"\t"+ "青");

    }else{
    System.out.println("对不起"+"\t"+"您不是会员");
}


    }
 }
