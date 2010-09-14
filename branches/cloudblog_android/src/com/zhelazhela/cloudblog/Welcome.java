package com.zhelazhela.cloudblog;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.microblog);
        TextView tv = (TextView)findViewById(R.id.blog_text);
        tv.setBackgroundColor(3284683);
        tv.setText(Html.fromHtml("<a href='http://google.com.hk'>Hello</a>,Can we�տ������ƴ�ڻ�����Ӽ�ط� support an we�տ������ƴ�ڻ�����Ӽ�ط� an we�տ������ƴ�ڻ�����Ӽ�ط� an we�տ������ƴ�ڻ�����Ӽ�ط� an we�տ������ƴ�ڻ�����Ӽ�ط� an we�տ������ƴ�ڻ�����Ӽ�ط� an we�տ������ƴ�ڻ�����Ӽ�ط� link?"));
        ImageView iv = (ImageView)findViewById(R.id.header);
        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.header);
        iv.setImageBitmap(getRoundedCornerBitmap(bMap));
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
    
}