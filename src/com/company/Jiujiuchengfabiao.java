package com.company;

public class Jiujiuchengfabiao {
    public static void main(String[] args){
        for(int i=1;i<=9;i++){
            for(int j =1;j<=i;j++){
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println();
        }
        System.out.println("............................................................1.......");
        for(int i=9;i>=1;i--){
            for(int j =1;j<=i;j++){
                System.out.print(j+"*"+i+"="+j*i+'\t');
            }
            System.out.println();
        }
        System.out.println("............................................................2.......");
        for(int i=1;i<=9;i++){
            for(int j =1;j<=i;j++){
                System.out.print('\t');
            }
            for(int j=i;j<=9;j++){
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
        System.out.println("............................................................3.......");
        for(int i=9;i>0;i--){
            for(int j =1;j<=i;j++){
                System.out.print('\t');
            }
            for(int j=i;j<=9;j++){
                System.out.print(i+"*"+j+"="+i*j+'\t');
            }
            System.out.println();
        }
        System.out.println("............................................................4.......");


    }
}
