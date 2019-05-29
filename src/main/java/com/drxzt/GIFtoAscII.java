package com.drxzt;

/**
 * className GIFtoAscII
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/5/29 10:39
 */

public class GIFtoAscII {
    //gif图片路径，推荐使用像素在400*400以内的
    public static String input = "D:\\IdeaProjects\\gitToAscIIGif\\src\\main\\resources\\KUNKUN.gif";

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        System.out.println("---------- Do  --------->----------->");
        ImgToCharacter.readGiF();//将GIF分解成逐帧图片,并转为ASCII图
        long endTime=System.currentTimeMillis();
        System.out.println("Program run time: "+(endTime-startTime)+"ms");
    }

}
