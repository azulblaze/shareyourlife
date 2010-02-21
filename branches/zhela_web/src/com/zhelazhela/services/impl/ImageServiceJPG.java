package com.zhelazhela.services.impl;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.zhelazhela.services.ImageService;

/**
 * <code>ImageServiceJPG.java</code>
 * 
 * @version 1.0, 2009-8-6
 */
public class ImageServiceJPG implements ImageService {

        @Override
        public boolean reSizeImage(File source, String dest, int width, int height) {
                try {
                        Image src = javax.imageio.ImageIO.read(source);
                        int _height = src.getHeight(null);
                        int _width = src.getWidth(null);
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
                        BufferedImage tag = new BufferedImage(width, height,
                                        BufferedImage.TYPE_INT_RGB);
                        tag.getGraphics().drawImage(
                                        src.getScaledInstance(width, height, Image.SCALE_SMOOTH),
                                        0, 0, null);
                        FileOutputStream out = new FileOutputStream(dest);
                        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                        encoder.encode(tag);
                        out.close();
                } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                }
                return true;
        }

}
