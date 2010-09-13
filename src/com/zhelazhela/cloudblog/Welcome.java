package com.zhelazhela.cloudblog;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
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
        tv.setText(Html.fromHtml("<a href='http://google.com.hk'>Hello</a>,Can we收款机发挥撒科打诨发电视监控发 support an we收款机发挥撒科打诨发电视监控发 an we收款机发挥撒科打诨发电视监控发 an we收款机发挥撒科打诨发电视监控发 an we收款机发挥撒科打诨发电视监控发 an we收款机发挥撒科打诨发电视监控发 an we收款机发挥撒科打诨发电视监控发 link?"));
        ImageView iv = (ImageView)findViewById(R.id.header);
        drawRounderIMG(iv.getDrawingCache());
    }
    
    private void drawRounderIMG(Bitmap myCoolBitmap){
    	int w = myCoolBitmap.getWidth(), h = myCoolBitmap.getHeight();
    	// We have to make sure our rounded corners have an alpha channel in most cases
    	Bitmap rounder = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
    	Canvas canvas = new Canvas(rounder);    
    	// We're going to apply this paint eventually using a porter-duff xfer mode.
    	// This will allow us to only overwrite certain pixels. RED is arbitrary. This
    	// could be any color that was fully opaque (alpha = 255)
    	Paint xferPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    	xferPaint.setColor(Color.RED);
    	// We're just reusing xferPaint to paint a normal looking rounded box, the 20.f
    	// is the amount we're rounding by.
    	canvas.drawRoundRect(new RectF(0,0,w,h), 20.0f, 20.0f, xferPaint);     
    	// Now we apply the 'magic sauce' to the paint  
    	xferPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

    }
    
}