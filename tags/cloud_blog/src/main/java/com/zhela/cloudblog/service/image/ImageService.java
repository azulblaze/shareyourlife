package com.zhela.cloudblog.service.image;

/**
 * <code>ImageService.java</code>
 * @version 1.0, 2009-8-6
 */
public interface ImageService {

        /**
         * 
         * @param source source file
         * @param dest dest address
         * @param width width want to be changed
         * @param height if height<=0,the image will changed by scale
         * @return true:resized image to dest file, false: no need to resize or occoured exception
         */
        public boolean reSizeImage(java.io.File source,String dest,int width,int height);
        
}
