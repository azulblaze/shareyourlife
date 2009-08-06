package com.twitpic.services.impl;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.twitpic.services.ImageService;

/**
 * <code>ImageServicePNG.java</code>
 * @version 1.0, 2009-8-6
 */
public class ImageServicePNG implements ImageService{
	
	public boolean reSizeImage(File source,String dest,int width,int height){
		try{
			Image src = javax.imageio.ImageIO.read(source);
			int _height = src.getHeight(null);
			int _width = src.getWidth(null);
			//if height>0,we need to change image to absolute width and height
			if(height>0){
				if(_height<=height&&_width<=width){
					return false;
				}
			}else{//we make image's width to be given, the height will be changed relative
				if(_width>width){
					height = (int)Math.ceil(_height*width/_width);
				}else{
					return false;
				}
			}
			BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = image.createGraphics();
			//to make the png background  transparent
			image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
			g2d.dispose();
			g2d = image.createGraphics();
			//draw image
			g2d.drawImage(src, 0, 0, width, height, null);
			//release the g2d
			g2d.dispose();
			//save image
			ImageIO.write(image, "png",new File(dest));
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
