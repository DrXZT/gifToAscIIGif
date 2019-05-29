package com.drxzt;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImgToCharacter {

	private static BufferedImage[] charImgs;
	private static int size = 4;
	private static String[] chars= {" ",".",":",";","-","~","1","i","o","r","a",
									"2","c","3","b","n","q","k","x","S","X",
									"7","Z","O","8","#","$","%","&","M","B",
									"W","@","@"};
	private static int interval = 16777215 / (chars.length-1) ;

	public static void readGiF() {
		try {
			File f = new File(GIFtoAscII.input);
			String name = f.getName();
			String suffix = name.substring(name.lastIndexOf('.')+1);
			Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
			ImageReader reader = iter.next();
			ImageInputStream imageIn;
			imageIn = ImageIO.createImageInputStream(f);
			reader.setInput(imageIn);
			int count = reader.getNumImages(true);
			charImgs = new BufferedImage[count];
			for(int index=0; index< count; index++) {
				BufferedImage oneRealImg = reader.read(index);
				int width = oneRealImg.getWidth();
				int height = oneRealImg.getHeight();
				BufferedImage oneCharImg = new BufferedImage(width*3, height*3,BufferedImage.TYPE_INT_RGB);
				Graphics g = oneCharImg.getGraphics();
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, oneCharImg.getWidth(), oneCharImg.getHeight());
				g.setColor(Color.BLACK);
				g.setFont(new Font("ºÚÌå", Font.BOLD, 15));
				for(int i= 0 ; i < height ; i+=size){
					for(int j = 0 ; j < width; j+=size){
						int rgb = getAvgRGB(j, i, oneRealImg);
						int k = rgb/interval;
						g.drawString(chars[k], 12*j/size, 12*i/size);
					}
				}
				g.dispose();
				BufferedImage newRealImg=Thumbnails.of(oneCharImg)
						.scale(0.7f)
						.outputQuality(0.1f)
						.asBufferedImage();//Ñ¹ËõÍ¼Æ¬
				charImgs[index] = newRealImg;
			}
			JpgToGif jpgToGif =new JpgToGif();
			jpgToGif.jpgToGif(charImgs,"D:\\IdeaProjects\\gitToAscIIGif\\src\\main\\resources\\success-"+name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int getAvgRGB(int i, int j, BufferedImage img) {
		int result = 0;
		for(int m=0; m<size; m++) {
			for(int n=0; n<size; n++) {
				if(i+m < img.getWidth() && j+n < img.getHeight())
				result += img.getRGB(i+m, j+n);
			}
		}
		return  Math.abs(result) / (size*size);
	}

}
