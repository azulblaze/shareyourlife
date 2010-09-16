package com.zhelazhela.cloudblog.ui;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhelazhela.cloudblog.R;
import com.zhelazhela.cloudblog.domain.Post;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class BlogDetailAdapter extends SimpleAdapter {

	private final LayoutInflater inflater;

	public BlogDetailAdapter(Context context,ArrayList<HashMap<String, String>> data){
		super(context,data,R.layout.microblog,new String[]{"blog_text","blog_from"},new int[]{R.id.blog_text,R.id.blog_from});
		inflater = LayoutInflater.from(context);
	}
	public BlogDetailAdapter(Context context,
			List<? extends Map<String, ?>> data, int resource, String[] from,
			int[] to) {
		super(context, data, resource, from, to);
		inflater = LayoutInflater.from(context);
		// TODO Auto-generated constructor stub
	}

	/*
	
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView tv_blog_text = (TextView)view.findViewById(R.id.blog_text);
		tv_blog_text.setText(Html.fromHtml(cursor.getString(cursor.getColumnIndex(Post.ID))));
		TextView tv_blog_from = (TextView)view.findViewById(R.id.blog_from);
		tv_blog_from.setText("This is from sina blog");
		view.setBackgroundColor(3284683);
        ImageView iv = (ImageView)view.findViewById(R.id.header);
        Bitmap bMap = BitmapFactory.decodeResource(view.getResources(), R.drawable.header);
        iv.setImageBitmap(getRoundedCornerBitmap(bMap));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		 final View view = inflater.inflate(R.layout.microblog, parent, false);
		 return view; 
	}
	
	private Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
            bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
     
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 24;
     
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
     
        return output;
      }
*/
}
