package com.twitpic.services.impl;

import java.io.File;
import java.io.IOException;

import com.gif4j.GifDecoder;
import com.gif4j.GifEncoder;
import com.gif4j.GifImage;
import com.gif4j.GifTransformer;
import com.twitpic.services.ImageService;

/**
 * <code>ImageServiceGIF.java</code>
 * 
 * @version 1.0, 2009-8-6
 */
public class ImageServiceGIF implements ImageService {

	@Override
	public boolean reSizeImage(File source, String dest, int width, int height) {
		try {
			GifImage gifImage = GifDecoder.decode(source);
			int _height = gifImage.getScreenHeight();
			int _width = gifImage.getScreenWidth();
			// if height>0,we need to change image to absolute width and height
			if (height > 0) {
				if (_height <= height && _width <= width) {
					return false;
				}
			} else {// we make image's width to be given, the height will be
					// changed relative
				if (_width > width) {
					height = (int) Math.ceil((float)_height * width / _width);
				} else {
					return false;
				}
			}
			GifImage resizeIMG = GifTransformer.resize(gifImage, width, height,false);
			GifEncoder.encode(resizeIMG, new File(dest));
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
