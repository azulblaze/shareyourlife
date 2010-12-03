package com.zhela.android.component;

import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.db.model.Image;
import com.zhela.android.core.util.CommonResource;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

public class ImageCache {
	private static byte[] byteArrayBitmap = null;
	private static ConcurrentHashMap<String, SoftReference<Bitmap>> imageCache = new ConcurrentHashMap<String, SoftReference<Bitmap>>();

	public static void loadImage(final String imageUrl,
			final int position,final int type, final ImageCallback imageCallback) {
		final Handler handler = new Handler() {
			public void handleMessage(Message message) {
				Bitmap bitmap = (Bitmap)message.obj;
				imageCallback.imageLoaded(bitmap, position, imageUrl);
			}
		};
		new Thread() {  
            @Override  
            public void run() {
            	Bitmap bitmap;
            	if(imageUrl==null||!imageUrl.startsWith("http")){
        			return;
        		}
        		if (imageCache.containsKey(imageUrl)) {
        			SoftReference<Bitmap> softReference = imageCache.get(imageUrl);
        			bitmap = softReference.get();
        			if (bitmap != null) {
        				Message message = CommonResource.getMessage(0, bitmap);
                		handler.sendMessage(message);
        				return;
        			}
        		}
        		Image image = new SQLService().getImageWithURL(imageUrl);
        		if(image!=null){
        			byteArrayBitmap = image.bitimg;
        			if(byteArrayBitmap !=null){
        				bitmap = CommonResource.getBitmap(byteArrayBitmap);
        				Message message = CommonResource.getMessage(0, bitmap);
                		handler.sendMessage(message);
        				return;
        			}
        		}
            	bitmap = downloadImageFromUrl(imageUrl,type);
            	if(bitmap!=null){
            		Message message = CommonResource.getMessage(0, bitmap);
            		handler.sendMessage(message);
            		saveImageToCache(bitmap,imageUrl);
    				saveImageToDB(bitmap,imageUrl,Image.STATUS_OK,type);
        		}
            }  
        }.start();		
	}

	private static void saveImageToCache(Bitmap bitmap,String url){
		SoftReference<Bitmap> _bitmap = new SoftReference<Bitmap>(bitmap);
		imageCache.put(url, _bitmap);
	}
	
	private static void saveImageToDB(Bitmap bitmap,String url,int status,int type){
		Image image = new Image();
		image.setBitmap(bitmap);
		image.status = status;
		image.type = type;
		image.update_time = new java.util.Date();
		image.url = url;
		new SQLService().insertOrUpdateImage(image);
	}
	
	public interface ImageCallback {
		public void imageLoaded(Bitmap bitmap,
				final int itemId, String imageUrl);
	}

	public static Bitmap downloadImageFromUrl(String imageUrl,int type) {
		
		URL mURL = null;
		try {
			mURL = new URL(imageUrl);
			HttpURLConnection  mHttpURLConnection = (HttpURLConnection) mURL.openConnection();
			mHttpURLConnection.setDoInput(true);
			mHttpURLConnection.connect();

			InputStream in = mHttpURLConnection.getInputStream();
			Bitmap mBitmap = CommonResource.getBitmap(in, null);
			return mBitmap;
		} catch (Exception e) {	
			return null;
		}
		
	}

}
