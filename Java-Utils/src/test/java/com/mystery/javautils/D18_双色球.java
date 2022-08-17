package com.mystery.javautils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 一，玩法说明:红球(1-33)+蓝球(1-16)
 * 一等奖：6+1
 * 二等奖：6+0
 * 三等奖：5+1
 * 四等奖：5+0	4+1
 * 五等奖：4+0	3+1
 * 六等奖：2+1	1+1	0+1
 *
 * 二，案例分析：
 * 1.如何产生蓝球和红球
 * 2.如何接受用户选号
 * 3.如何验证是否中奖
 * 4.公布本期中奖号码
 *
 * 三，实现步骤
 * 1.整体实现思路
 * 2.随机取值不重复（系统和用户）
 * 3.判断是否中奖的逻辑
 * 4.结果输出
 */
/**
 * 模拟双色球综合案例
 * 1.用户选择是机选还是手选
 * 2.接收用户选号（6红1蓝）
 * 3.生成系统号码（6红1蓝）
 * 4.比较系统号码和用户号码
 * 5.验证是否中奖
 * 6.系统号码排序
 * 7.公布结果
 * */
public class D18_双色球 {

    public static void main(String[] args) {
        Scanner Lulu=new Scanner(System.in);
//定义相关变量
        int [] userRedBall=new int[6];//用户选择的红球号码
        int [] sysRedBall=new int[6]; //系统生成的红球号码
        int userBlueBall=0;			  //用户选择的红球号码
        int sysBlueBall=0;			  //系统生成的红球号码
        int redCount=0;				  //用于记录用户选择的正确的红球数
        int blueCount=0;				  //用于记录用户选择的正确的蓝球数
        int [] redBall=new int[33];	  //用于存储1-33的红球号码

//需要随机生成6个1到33之间不重复的数
        for (int i=0;i<redBall.length;i++){
            redBall[i]=i+1;

        }

//系统提示
        System.out.println("游戏开始，祝君好运!");
        System.out.println("请问是机选还是自选（1，机选；2，自选）");
        boolean flag=true;
        Random ll=new Random();
        while(flag){
            int isAuto=Lulu.nextInt();
            switch(isAuto){
                case 1:
                    //机选
                    computerSelection(redBall,userRedBall);//机选红球
                    userBlueBall=ll.nextInt((16)+1);//机选随机蓝球
                    flag=false;
                    break;
                case 2:
                    //自选
                    System.out.println("请选择6个红球号码（1-33之间）");
                    for(int i=0;i<userRedBall.length;i++){
                        userRedBall[i]=Lulu.nextInt();
                    }
                    System.out.println("请选择一个蓝球号码（1-16之间）");
                    userBlueBall=Lulu.nextInt();
                    flag=false;
                    break;
                default:
                    System.out.println("请问是机选还是自选（1，机选；2，自选）");
                    break;
            }
        }
//系统随机生成号码
        //红球
        computerSelection(redBall,sysRedBall);
        //蓝球
        sysBlueBall=ll.nextInt((16)+1);

//统计结果：
        //统计红球：
        for(int i=0;i<userRedBall.length;i++){
            for(int j=0;j<sysRedBall.length-redCount;j++){

                if(userRedBall[i]==sysRedBall[j]){
                    int temp=sysRedBall[j];
                    sysRedBall[j]=sysRedBall[sysRedBall.length-1-redCount];
                    sysRedBall[sysRedBall.length-1-redCount]=temp;
                    redCount++;
                    break;
                }
            }
        }
        //统计蓝球：
        if(userBlueBall==sysBlueBall){
            blueCount=1;
        }
//验证是否中奖
        if(blueCount==0&&redCount<=3){
            System.out.println("继续加油，未中奖");
        }else if(blueCount==1&&redCount<3){
            System.out.println("六等奖");
        }else if((blueCount==1&&redCount==3)||(blueCount==0&&redCount==4)){
            System.out.println("五等奖");
        }else if((blueCount==1&&redCount==4)||(blueCount==0&&redCount==5)){
            System.out.println("四等奖");
        }else if(blueCount==1&&redCount==5){
            System.out.println("三等奖");
        }else if(blueCount==0&&redCount==6){
            System.out.println("二等奖");
        }else if(blueCount==1&&redCount==6){
            System.out.println("一等奖");
        }else{
            System.out.println("系统错误");
        }

//输出中奖号码
        System.out.println("本期中奖的红球号码为：");
        sort(sysRedBall);
        System.out.println(Arrays.toString(sysRedBall));
        System.out.println("本期中奖的蓝球号码为："+sysBlueBall);
//输出用户号码
        System.out.println("您选择的红球号码为：");
        sort(userRedBall);
        System.out.println(Arrays.toString(userRedBall));
        System.out.println("您选择的篮球号码为："+userBlueBall);
    }



    //冒泡排序
    public static void sort(int [] ball){
        for(int i=0;i<ball.length;i++){
            for(int j=0;j<ball.length-1-i;j++){
                if(ball[j]>ball[j+1]){
                    ball[j]=ball[j]+ball[j+1]-(ball[j+1]=ball[j]);
                }
            }
        }
    }
    //用于在指定的数列中，随机生成多个不重复的数的算法
    public static void computerSelection(int[] redBall,int []userRedBall){
        int index=-1;
        Random ll=new Random();
        for(int i=0;i<userRedBall.length;i++){
            index=ll.nextInt(redBall.length-i);
            userRedBall[i]=redBall[index];

//			int temp=redBall[index];
//			redBall[index]=redBall[redBall.length-1-i];
//			redBall[redBall.length-1-i]=temp;
            redBall[index]=redBall[index]+redBall[redBall.length-1-i]-
                    (redBall[redBall.length-1-i]=redBall[index]);
        }
    }
}
