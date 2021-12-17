package com.company1;

public class MaoPaoPaiXu {
    public static void main(String[] args){
        int[] array = new int[]{4,9,2,8,3,1,6,7,5};//从小到大冒泡排序；
        int sum = 0;
        int i = 1;
        int j = 1;
        for (; i <= 10; ++i) {
            j = 1;
            for (; j <= 10; ++j) {
                sum = sum + i * j;
            }
            System.out.println(i+"\t"+j+"\t"+sum);

        }


    }
}
