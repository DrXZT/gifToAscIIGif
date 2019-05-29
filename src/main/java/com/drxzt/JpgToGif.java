package com.drxzt;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * className JpgToGif
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/5/27 20:38
 */


public class JpgToGif {

    /**
     * 把多张jpg图片合成一张
     * @param pic String[] 多个jpg文件名 包含路径
     * @param newPic String 生成的gif文件名 包含路径
     */
    private synchronized void jpgToGif(String[] pic, String newPic) {
        try {
            AnimatedGifEncoder  e = new AnimatedGifEncoder ();
            e.setRepeat(0);
            e.start(newPic);
            BufferedImage src[] = new BufferedImage[pic.length];
            for (int i = 0; i < src.length; i++) {
                if(i%8==0) continue;
                e.setDelay(80); //设置播放的延迟时间
                src[i] = ImageIO.read(new File(pic[i])); // 读入需要播放的jpg文件
                e.addFrame(src[i]);  //添加到帧中
            }
            e.finish();
        } catch (Exception e) {
            System.out.println( "jpgToGif Failed:");
            e.printStackTrace();
        }
    }
    public synchronized void jpgToGif(BufferedImage src[] , String newPic) {
        try {
            AnimatedGifEncoder  e = new AnimatedGifEncoder ();
            e.setRepeat(0);
            e.start(newPic);
            for (int i = 0; i < src.length; i++) {
                if(i%8==0) continue;
                e.setDelay(80); //设置播放的延迟时间
                e.addFrame(src[i]);  //添加到帧中
            }
            e.finish();
        } catch (Exception e) {
            System.out.println( "jpgToGif Failed:");
            e.printStackTrace();
        }
    }
}
