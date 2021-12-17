//更改管理员密码，1创建管理员类的对象 2用while实现循环执行
package OppDemo;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Administrator  {
    //创建管理员类
    //属性(定义管理员初始密码)
    String loginName = "admin";
    String password  = "123";
    //方法-------------输出用户名和密码
    public void introduce(){
        System.out.println("用户名是："+loginName);
        System.out.println("密码是："+password);
    }
    //主函数
    public static void main(String[] args){
        //创建类的对象
        Administrator admin = new Administrator();
        System.out.println(admin.loginName);
        System.out.println(admin.password);
        admin.introduce();//使用方法：输出两个值

        //从控制台读取数据，需要Scanner对象
        System.out.println("修改密码：");
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("请输入用户名：");
            String name = sc.nextLine();
            System.out.println("请输入密码：");
            String pwd  = sc.nextLine();
            if(name.equals(admin.loginName) && pwd.equals(admin.password)){  //如果对，输入新的密码
                System.out.println("请输入新用户名：");
                admin.loginName = sc.nextLine();
                System.out.println("请输入新密码：");
                admin.password  = sc.nextLine();
                System.out.println("修改成功！");
                break;
            }else{
                System.out.println("用户名和密码不正确,请重新输入");
            }
        }

        admin.introduce();
    }


}
