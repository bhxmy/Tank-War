package com.company1;

public class Test1 {
    public static void main(String[] args){
        int[] ng= {2,4,6,8,10 };
        for(int i=0;i<ng.length;i++){
            int n = ng[i];
            System.out.print(n+"\t");  // 这里'\t'和"\t"不同？
        }
        System.out.println("....................................................");
        int[] a ={1,2,3,4,5};
        System.out.print(a[1]);
    }
}
