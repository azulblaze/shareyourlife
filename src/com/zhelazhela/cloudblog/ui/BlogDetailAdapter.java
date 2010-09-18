package com.zhelazhela.cloudblog.ui;


import java.util.List;

import com.zhelazhela.cloudblog.BlogList;
import com.zhelazhela.cloudblog.R;
import com.zhelazhela.cloudblog.domain.Post;
import com.zhelazhela.cloudblog.service.AsyncImageLoader;
import com.zhelazhela.cloudblog.service.AsyncImageLoader.ImageCallback;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BlogDetailAdapter extends ArrayAdapter<Post> {

	BlogList activity = (BlogList) getContext();  
	private ListView listView;
	private List<Post> posts;
	private AsyncImageLoader asyncImageLoader; 

	public BlogDetailAdapter(Context context, List<Post> posts, ListView listView) {
		super(context, 0, posts);
		this.listView = listView;
		this.posts = posts;
		asyncImageLoader = new AsyncImageLoader();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View _selectView = convertView;
		if (_selectView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			_selectView = inflater.inflate(R.layout.microblog, null);
		}
		Post _post = getItem(position);
		TextView tv = (TextView) _selectView.findViewById(R.id.blog_text);
		tv.setText(Html.fromHtml(_post.getText()));
		tv = (TextView) _selectView.findViewById(R.id.blog_from);
		tv.setText(Html.fromHtml(_post.getCreated_at() + BlogList.activity.getResources().getString(R.string.from)
				+ _post.getSource()));
		ImageView iv = (ImageView) _selectView.findViewById(R.id.header);
		//add a tag to allowed we can look for it and replace the picture
		iv.setTag(_post.getUser().getProfile_image_url());
		Bitmap cachedImage = asyncImageLoader.loadBitmap(_post.getUser()
				.getProfile_image_url(), new ImageCallback() {
			public void imageLoaded(Bitmap imageBitmap, String imageUrl) {
				ImageView imageViewByTag = (ImageView) listView
						.findViewWithTag(imageUrl);
				if (imageViewByTag != null) {
					imageViewByTag.setImageBitmap(imageBitmap);
				}
			}
		});
		if (cachedImage == null) {
			//iv.setImageResource(R.drawable.header);
		} else {
			iv.setImageBitmap(cachedImage);
			notifyDataSetChanged();
		}
		return _selectView;
	}
	
	
	/*
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
