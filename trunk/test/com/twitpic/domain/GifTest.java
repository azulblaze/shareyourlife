package com.twitpic.domain;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;

import com.gif4j.GifDecoder;
import com.gif4j.GifEncoder;
import com.gif4j.GifFrame;
import com.gif4j.GifImage;
import com.gif4j.GifTransformer;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.twitpic.services.ImageService;

public class GifTest {

	public static final File file = new File("F:/gif/gif.gif");
	
	public static final File jgp = new File("F:/gif/01.jpg");
	
	public static final File header = new File("F:/gif/header.gif");

	public void decode(File input) throws IOException {
		GifImage gifImage = GifDecoder.decode(file);
		if (gifImage.getNumberOfComments() > 0) {
			// get iterator over gif image textual comments
			Iterator commentsIterator = gifImage.comments();
			while (commentsIterator.hasNext())
				System.out.println(commentsIterator.next()); // print comments
		}
		System.out.println("number of frames: " + gifImage.getNumberOfFrames());
		for (int i = 0; i < gifImage.getNumberOfFrames(); i++) {
			System.out.println("------frame(" + (i + 1) + ")---------");
			GifFrame frame = gifImage.getFrame(i);
			System.out.println("width: " + frame.getWidth());
			System.out.println("height: " + frame.getHeight());
			System.out
					.println("position: " + frame.getX() + "," + frame.getY());
			System.out.println("disposal method: " + frame.getDisposalMethod());
			System.out.println("delay time: " + frame.getDelay());
			System.out.println("is interlaced: " + frame.isInterlaced());
			// get frame's color model
			IndexColorModel frameColorModel = frame.getColorModel();
			System.out.println("number of colors: "
					+ frameColorModel.getMapSize());
			System.out.println("is transparent: " + frameColorModel.hasAlpha());
			System.out.println("transparent index: "
					+ frameColorModel.getTransparentPixel());
			// get frame's representation as an Image
			Image image = frame.getAsImage();
			// get frame's representation as a BufferedImage
			BufferedImage bufferedImage = frame.getAsBufferedImage();
		}
	}

	public void addCommentToGifImage(File from,File to,String comment)
			throws IOException {
		// read gif image from the file
		GifImage gifImage = GifDecoder.decode(from);
		gifImage.addComment(comment);
		GifEncoder.encode(gifImage, to);
	}
	
	public static void getGifImage(File srcImg, File destImg, int width, int height, boolean smooth) {   
		  try {   
		  GifImage gifImage = GifDecoder.decode(srcImg);//创建一个GifImage对象.   
		      // 1.缩放重新更改大小.   
		  GifImage resizeIMG = GifTransformer.resize(gifImage,width,      height,smooth);   
		    // 2.剪切图片演示.   
		// Rectangle rect = new Rectangle(0,0,200,200);   
		// GifImage cropIMG = GifTransformer.crop(gifImage, rect);   
		// 3.按比例缩放   
		// GifImage scaleIMG = GifTransformer.scale(gifImage, 200.0, 200.0,  true);//参数需要double型   
		// 4.其他的方法.还有很多,比如水平翻转，垂直翻转 等等.都是GifTransformer类里面的.   
		   GifEncoder.encode(resizeIMG, destImg);   
		     } catch (IOException e) {   
		        e.printStackTrace();   
		      }   
		   }   
	
	public void reduceImg(String imgsrc, String imgdist, int widthdist,   
	        int heightdist) {   
	    try {   
	        File srcfile = new File(imgsrc);   
	        if (!srcfile.exists()) {   
	            return;   
	        }   
	        Image src = javax.imageio.ImageIO.read(srcfile);   
	  
	        BufferedImage tag= new BufferedImage((int) widthdist, (int) heightdist,   
	                BufferedImage.TYPE_INT_RGB);   
	        tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist,  Image.SCALE_SMOOTH), 0, 0,  null);   
	        FileOutputStream out = new FileOutputStream(imgdist);   
	        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
	        encoder.encode(tag);   
	        out.close();   
	  
	    } catch (IOException ex) {   
	        ex.printStackTrace();   
	    }   
	}   

	
	public void savePNG() throws IOException{
		int width = 100;
		int height = 300;
		// 创建BufferedImage对象
		BufferedImage image = new BufferedImage(width, height,     BufferedImage.TYPE_INT_RGB);
		// 获取Graphics2D
		Graphics2D g2d = image.createGraphics();
		// ----------  增加下面的代码使得背景透明  -----------------
		image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
		g2d.dispose();
		g2d = image.createGraphics();
		// ----------  背景透明代码结束  -----------------
		// 画图
		g2d.setColor(new Color(255,0,0));
		g2d.setStroke(new BasicStroke(1));
		Image src = javax.imageio.ImageIO.read(new File("F:/gif/png-3.png"));
		g2d.drawImage(src, 0, 0, width, height, null);
		//释放对象
		g2d.dispose();
		// 保存文件    
		ImageIO.write(image, "png", new File("F:/gif/png-1_33.png"));
	}
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//GifTest gt = new GifTest();
		//gt.decode(GifTest.file);
		//gt.addCommentToGifImage(GifTest.file, new File("F:/gif/my_gif.gif"), "Andy Chen");
		//gt.getGifImage(GifTest.header, new File("F:/gif/my_header.gif"), 400, 400, false);
		//gt.reduceImg("F:/gif/01.jpg", "F:/gif/01__.jpg", 400, 300);
		//gt.reduceImg("F:/gif/png-1.png", "F:/gif/png-1_11.png", 100, 150);
		//gt.savePNG();
		ImageService is = (ImageService)Class.forName("com.twitpic.services.impl.ImageService"+"PNG").newInstance();
		System.out.println(is.reSizeImage(new File("F:/image/png-1.png"), "F:/image/png-22.png", 149, 0));
	}

}
