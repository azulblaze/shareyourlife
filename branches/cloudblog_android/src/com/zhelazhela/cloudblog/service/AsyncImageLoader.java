package com.zhelazhela.cloudblog.service;

import java.io.IOException;  
import java.io.InputStream;  
import java.lang.ref.SoftReference;  
import java.net.HttpURLConnection;
import java.net.MalformedURLException;  
import java.net.URL;  
import java.util.HashMap;  

import com.zhelazhela.cloudblog.BlogList;
import com.zhelazhela.cloudblog.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.os.Handler;
import android.os.Message;

public class AsyncImageLoader {
	private HashMap<String, SoftReference<Bitmap>> imageCache;

	public AsyncImageLoader() {
		imageCache = new HashMap<String, SoftReference<Bitmap>>();
	}

	public Bitmap loadBitmap(final String imageUrl,
			final ImageCallback imageCallback) {
		if (imageCache.containsKey(imageUrl)) {
			SoftReference<Bitmap> softReference = imageCache.get(imageUrl);
			Bitmap Bitmap = softReference.get();
			if (Bitmap != null) {
				return Bitmap;
			}
		}
		final Handler handler = new Handler() {
			public void handleMessage(Message message) {
				imageCallback.imageLoaded((Bitmap) message.obj, imageUrl);
			}
		};
		new Thread() {
			@Override
			public void run() {
				Bitmap bitmap = loadImageFromUrl(imageUrl);
				imageCache.put(imageUrl, new SoftReference<Bitmap>(bitmap));
				Message message = handler.obtainMessage(0, bitmap);
				handler.sendMessage(message);
			}
		}.start();
		return null;
	}

	public static Bitmap loadImageFromUrl(String url) {
		URL m;
		InputStream i = null;
		try {
			m = new URL(url);
			HttpURLConnection  mHttpURLConnection = (HttpURLConnection) m.openConnection();
			mHttpURLConnection.setDoInput(true);
			mHttpURLConnection.connect();
			i = mHttpURLConnection.getInputStream();
		} catch (MalformedURLException e1) {
			//e1.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(i);
		if(bitmap != null){
			bitmap = getRoundedCornerBitmap(bitmap);
		}else{
			bitmap = BitmapFactory.decodeResource(BlogList.activity.getResources(), R.drawable.header);
		}
		return bitmap;
	}

	private static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
            bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
     
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 8;
     
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
     
        return output;
      }
	
	public interface ImageCallback {
		public void imageLoaded(Bitmap imageBitmap, String imageUrl);
	}
}
