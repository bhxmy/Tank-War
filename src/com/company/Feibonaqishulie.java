//fibn=first+second;
//first =second;
//second=fibn;

package com.company;

public class Feibonaqishulie {
    public static void main(String[] args){
        int first =0;
        int second=1;
        int fibn  =0;
        for(int i=1 ;i<=10;i++){
            fibn=first+second;
            first = second;
            second= fibn;
        }
    }
}
