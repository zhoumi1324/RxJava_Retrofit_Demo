package com.example.administrator.rxjava_retrofit_demo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.rxjava_retrofit_demo.R;
import com.example.administrator.rxjava_retrofit_demo.entity.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by zhoumi on 2018/5/29.
 */

public class MainAdapter extends BaseAdapter {
    private Context mContext;
    private List<Movie.Subjects> mDataSet;

    public MainAdapter(Context context, List<Movie.Subjects> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
             convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_list_item, parent, false); //加载布局
             holder = new ViewHolder();

             holder.image = convertView.findViewById(R.id.image);
             holder.text = convertView.findViewById(R.id.text);

             convertView.setTag(holder);
         } else {   //else里面说明，convertView已经被复用了，说明convertView中已经设置过tag了，即holder
             holder = (ViewHolder) convertView.getTag();
         }
        Picasso.with(mContext).load(mDataSet.get(position).getImages().getLarge()).into(holder.image);
        holder.text.setText(mDataSet.get(position).getTitle());
        return convertView;
    }

    static class ViewHolder {

        public ImageView image;
        public TextView text;
    }
}
