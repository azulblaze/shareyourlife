package com.twitpic.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiException;
import com.sun.jimi.core.JimiWriter;

/**
 * <code>ImageDeal.java</code>
 * 
 * @version 1.0, 2009-8-3
 */
public class ImageDeal {

	public void changeDimension(String source, String desc, double ins)
			throws JimiException, IOException {
		String temp = desc;
		File _file = new File(source);
		if (desc == null || desc.trim().equals("")){
			desc = source;
		}
		Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象
		double width = (double) src.getWidth(null); // 得到源图宽
		double height = (double) src.getHeight(null); // 得到源图长

		int iWidth = (int) (width * ins);
		int iHeight = (int) (height * ins);
		BufferedImage tag = new BufferedImage(iWidth, iHeight,
				BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(src, 0, 0, iWidth, iHeight, null); // 绘制缩小后的图
		if (!temp.trim().equals(desc)){
			_file.deleteOnExit();
		}
		JimiWriter writer = Jimi.createJimiWriter(desc);
		writer.setSource(tag);
		writer.putImage(desc);
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JimiException 
	 */
	public static void main(String[] args) throws JimiException, IOException {
		long c_time = System.currentTimeMillis();
		double i = 0.5;
		new ImageDeal().changeDimension("D:/My Documents/My Pictures/build7077wallpapers/panda.gif", "D:/My Documents/My Pictures/build7077wallpapers/panda_small.gif",i);
		System.out.println(System.currentTimeMillis()-c_time);
	}

}
