package inf.vj.twowaystaggeredgridviewviewcenterposition;

/*
 * Copyright (C) 2014 Lucas Rocha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.lucasr.twowayview.TwoWayLayoutManager;
import org.lucasr.twowayview.widget.TwoWayView;
import org.lucasr.twowayview.widget.SpannableGridLayoutManager;
import org.lucasr.twowayview.widget.StaggeredGridLayoutManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends
		RecyclerView.Adapter<ItemAdapter.SimpleViewHolder> {
	private final Context mContext;

	private final int mLayoutId;
	ArrayList<NewsStructure> newsArrayLst = new ArrayList<NewsStructure>();

	static Typeface typeFace;
	String imageUrl = "";

	public static class SimpleViewHolder extends RecyclerView.ViewHolder {
		public final ImageView imageView;

		public SimpleViewHolder(View view) {
			super(view);
			imageView = (ImageView) view.findViewById(R.id.newsTileImage);

		}
	}

	public ItemAdapter(Context context, TwoWayView recyclerView, int layoutId,
			ArrayList<NewsStructure> newsAry) {

		mContext = context;
		newsArrayLst = newsAry;
		mLayoutId = layoutId;

	}

	@Override
	public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		final View view = LayoutInflater.from(mContext).inflate(
				R.layout.news_feed_item_en, parent, false);
		return new SimpleViewHolder(view);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBindViewHolder(SimpleViewHolder holder, int position) {
		final View itemView = holder.itemView;
		final int itemId = position;
		if (mLayoutId == R.layout.activity_main) {
			int dimenId;
			final int span;
			if (itemId % 3 == 0) {
				imageUrl = newsArrayLst.get(position).getmId();
				span = 2;
				Picasso.with(mContext).load(imageUrl)
						.placeholder(R.drawable.ic_launcher).noFade()
						.tag("mylist").into(holder.imageView);
			} else {
				imageUrl =  newsArrayLst.get(position).getmId();;
				span = 1;
				Picasso.with(mContext).load(imageUrl)
						.placeholder(R.drawable.ic_launcher).noFade()
						.tag("mylist").into(holder.imageView);
			}
			dimenId = R.dimen.staggered_child_medium;
			final int size = mContext.getResources().getDimensionPixelSize(
					dimenId);
			final StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams) itemView
					.getLayoutParams();
			lp.span = span;
			lp.width = size;
			itemView.setLayoutParams(lp);
		}
	}

	@Override
	public int getItemCount() {
		return newsArrayLst.size();
	}
}
