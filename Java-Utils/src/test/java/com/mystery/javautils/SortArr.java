package com.mystery.javautils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortArr {
    public static void main(String[] args) {
        int [] arr = new int[] {2,3,4,1,2,3,5,88,55,32,14};
        /*冒泡*/
/*        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j+1] + arr[j] - (arr[j+1] = arr[j]);
                }
            }
        }*/
        /*选择*/
/*        int mixIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            mixIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[mixIndex] > arr[j]){
                    mixIndex = j;
                }
            }
            if(mixIndex != i){
                arr[mixIndex] = arr[i] + arr[mixIndex] - (arr[i] = arr[mixIndex]);
            }
        }*/
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
