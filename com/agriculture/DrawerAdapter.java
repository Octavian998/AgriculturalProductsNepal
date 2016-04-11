package com.agriculture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter {

	String[] drawerList;
	Context context;
	int[] images = {R.drawable.home, R.drawable.complain, R.drawable.data_analytics};
	public DrawerAdapter(Context context) {
		drawerList = context.getResources().getStringArray(R.array.drawerList);
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return drawerList.length;
	}

	@Override
	public Object getItem(int position) {
		return drawerList[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row;
		if(convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.drawer_row, parent, false);
		}
		else {
			row = convertView;
		}
		TextView tvDrawerItem = (TextView) row.findViewById(R.id.tvDrawerItem);
		ImageView ivDrawerItem = (ImageView) row.findViewById(R.id.ivDrawerItem);
		
		tvDrawerItem.setText(drawerList[position]);
		ivDrawerItem.setImageResource(images[position]);
		
		return row;
	}
}
