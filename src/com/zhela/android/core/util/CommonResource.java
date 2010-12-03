package com.zhela.android.core.util;

import java.io.InputStream;

import com.zhela.android.core.db.model.Image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Message;

public class CommonResource {

	public final int[] SCALE_HEADER_WH = new int[]{50,50};
	public final int[] SCALE_WEIBOIMG_WH = new int[]{200,200};
	public static final BitmapFactory.Options options = new BitmapFactory.Options();
	static{
		options.inPurgeable = true;
	}
	public synchronized static Bitmap getBitmap(byte []bitimg){
		return BitmapFactory.decodeByteArray(bitimg, 0, bitimg.length,options);
	}
	
	public synchronized static Bitmap getBitmap(InputStream is, Rect outPadding){
		return BitmapFactory.decodeStream (is,outPadding,options);
	}
	
	public int[] getImageScale(int type){
		switch(type){
		case Image.SCALE_HEADER:
			return SCALE_HEADER_WH;
		case Image.SCALE_WEIBOIMG:
			return SCALE_WEIBOIMG_WH;
		case Image.SCALE_WEIBOHEADER:
			return SCALE_HEADER_WH;
		default:
			return SCALE_WEIBOIMG_WH;
		}
	}
	
	public static synchronized Message getMessage(int what,Object message){
		Message msg = Message.obtain();
		msg.what= what;
		msg.obj = message;
		return msg;
	}
}
