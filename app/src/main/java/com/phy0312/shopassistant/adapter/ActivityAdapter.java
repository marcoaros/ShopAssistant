package com.phy0312.shopassistant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.phy0312.shopassistant.R;
import com.phy0312.shopassistant.model.HuoDong;
import com.phy0312.shopassistant.tools.ImageLoaderUtil;

import java.util.List;

/**
 * Created by dingdj on 2014/11/16.
 */
public class ActivityAdapter extends BaseAdapter {

    private Context context;

    private List<HuoDong> list;

    DisplayImageOptions options;

    public ActivityAdapter(Context context, List<HuoDong> list) {
        this.context = context;
        this.list = list;
        options = ImageLoaderUtil.newDisplayImageOptionsInstance();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list == null ? null : list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listitem_activity, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_activity_photo = (ImageView) view.findViewById(R.id.iv_activity_photo);
            viewHolder.tv_activity_name = (TextView) view.findViewById(R.id.tv_activity_name);
            viewHolder.tv_activity_valid_time = (TextView) view.findViewById(R.id.tv_activity_valid_time);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        HuoDong huoDong = list.get(i);
        viewHolder.tv_activity_name.setText(huoDong.getName());
        ImageLoader.getInstance().displayImage(huoDong.getIconPath(), viewHolder.iv_activity_photo, options);
        viewHolder.tv_activity_valid_time.setText(huoDong.getStartTime() + "-" +
                huoDong.getEndTime());
        return view;
    }

    public void setList(List<HuoDong> list) {
        this.list = list;
    }

    public List<HuoDong> getList() {
        return list;
    }

    class ViewHolder {
        ImageView iv_activity_photo;
        TextView tv_activity_name;
        TextView tv_activity_valid_time;
    }
}
