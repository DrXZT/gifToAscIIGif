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
     * �Ѷ���jpgͼƬ�ϳ�һ��
     * @param pic String[] ���jpg�ļ��� ����·��
     * @param newPic String ���ɵ�gif�ļ��� ����·��
     */
    private synchronized void jpgToGif(String[] pic, String newPic) {
        try {
            AnimatedGifEncoder  e = new AnimatedGifEncoder ();
            e.setRepeat(0);
            e.start(newPic);
            BufferedImage src[] = new BufferedImage[pic.length];
            for (int i = 0; i < src.length; i++) {
                if(i%8==0) continue;
                e.setDelay(80); //���ò��ŵ��ӳ�ʱ��
                src[i] = ImageIO.read(new File(pic[i])); // ������Ҫ���ŵ�jpg�ļ�
                e.addFrame(src[i]);  //��ӵ�֡��
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
                e.setDelay(80); //���ò��ŵ��ӳ�ʱ��
                e.addFrame(src[i]);  //��ӵ�֡��
            }
            e.finish();
        } catch (Exception e) {
            System.out.println( "jpgToGif Failed:");
            e.printStackTrace();
        }
    }
}
