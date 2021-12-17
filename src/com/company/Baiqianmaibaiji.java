//公鸡5文钱一只，母鸡3文钱一只，小鸡三只1文钱，100文钱买100只鸡。怎么买？
//cock:0-20   hen:0-33   chicken:0-300
package com.company;

public class Baiqianmaibaiji {
    public static void main(String[] args){
        for(int cock=0;cock<=20;cock++){
            for(int hen=0;hen<=33;hen++){
                    if((cock*5+hen*3+(100-cock-hen)/3==100)&&(100-cock-hen)%3==0){
                        System.out.println("公鸡数为："+cock+'\t'+"母鸡数为："+hen+'\t'+"小鸡数为："+(100-cock-hen)+'\t');
                    }
            }
        }
    }
}
