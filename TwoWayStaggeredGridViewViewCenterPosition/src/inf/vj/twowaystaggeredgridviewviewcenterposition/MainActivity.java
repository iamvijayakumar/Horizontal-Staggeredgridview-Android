package inf.vj.twowaystaggeredgridviewviewcenterposition;

import java.util.ArrayList;

import org.lucasr.twowayview.widget.DividerItemDecoration;
import org.lucasr.twowayview.widget.TwoWayView;


import com.squareup.picasso.Picasso;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView.OnScrollListener;

public class MainActivity extends Activity {
	TwoWayView mRecyclerView;
	ArrayList<NewsStructure> newsArrayLst = new ArrayList<NewsStructure>();
	
	String[] strImageUrl = {"http://www.hdwallpapersos.com/wp-content/uploads/2014/08/Nature-HD-Wallpaper-1080p.jpg",
			"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQJfVFBg3wTps8lucZi1RJ_sDrNDlsWUn5v_CP3dTI-eWlqnedn",
			"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnrFdFpG_70zp8RFPkuM7myrc6xkIVKS8aubXAvo_t3unbWuiJ",
			"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSuTV9Y9xYVvd0DHO7-gHht6O8tc343B5pa9kQnXMQbeyfQvwQF",
			"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcS5iTL5GeVCo2hlfCl9h1c8fBW7bF-2ZQ7hAuo6aNGzgpZgfELW",
			"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQJfVFBg3wTps8lucZi1RJ_sDrNDlsWUn5v_CP3dTI-eWlqnedn",
			"http://www.hdwallpapersos.com/wp-content/uploads/2014/08/Nature-HD-Wallpaper-1080p.jpg",
			"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnrFdFpG_70zp8RFPkuM7myrc6xkIVKS8aubXAvo_t3unbWuiJ",
			
			"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSuTV9Y9xYVvd0DHO7-gHht6O8tc343B5pa9kQnXMQbeyfQvwQF",
			"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcS5iTL5GeVCo2hlfCl9h1c8fBW7bF-2ZQ7hAuo6aNGzgpZgfELW"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mRecyclerView = (TwoWayView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLongClickable(false);
       mRecyclerView.setOrientation(org.lucasr.twowayview.TwoWayLayoutManager.Orientation.HORIZONTAL);
       
       
       for(int i =0; i< 10; i++){
    	   NewsStructure newsStr = new NewsStructure();
    	   newsStr.setmId(""+strImageUrl[i]);
    	   newsArrayLst.add(newsStr);
       }
       final Drawable divider = getResources().getDrawable(R.drawable.divider);
       mRecyclerView.addItemDecoration(new DividerItemDecoration(divider));
       ItemAdapter mAdapter = new ItemAdapter(MainActivity.this, mRecyclerView, R.layout.activity_main, newsArrayLst);
       mRecyclerView.setAdapter(mAdapter);
       mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
           @SuppressLint("NewApi") @Override
           public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
           	 boolean pauseOnScroll = false; // or true
        		boolean pauseOnFling = false; // or false
        		 final Picasso picasso = Picasso.with(MainActivity.this);
           	switch (scrollState) {
				case OnScrollListener.SCROLL_STATE_IDLE:
					picasso.resumeTag("mylist");
					break;
				case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
					if (pauseOnScroll) {
						picasso.pauseTag("mylist");
						
					}
					break;
				case OnScrollListener.SCROLL_STATE_FLING:
					if (pauseOnFling) {
						picasso.pauseTag("mylist");
				
					}
					break;
				}
           	
           
           }

           @SuppressLint("NewApi") @Override
           public void onScrolled(RecyclerView recyclerView, int i, int i2) {
           
           }
       });
       
       
       
    }
}
