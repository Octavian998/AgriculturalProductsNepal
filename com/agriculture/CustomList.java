package com.agriculture;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.agriculture.dummydata.Product;
import com.agriculture.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomList extends ArrayAdapter<Product> {
	private final Activity context;
	private final ArrayList<Product> products;
	private final ArrayList<HashMap<Date, Float>> prices;
	public CustomList(Activity context, ArrayList<Product> products, ArrayList<HashMap<Date, Float>> prices) {
		super(context, R.layout.list_style, products);
		this.context = context;
		this.products = products;
		this.prices = prices;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.list_style, null, true);
		ImageView img = (ImageView) rowView.findViewById(R.id.img);
		TextView txtName = (TextView) rowView.findViewById(R.id.txtName);
		TextView txtPrevPrice = (TextView) rowView.findViewById(R.id.txtPrevPrice);
		TextView txtPrice = (TextView) rowView.findViewById(R.id.txtPrice);
		
		txtName.setText(products.get(position).getName());
		Date currentDate = new Date(2014, 11, 30);
		Date prevDate = new Date(2014, 11, 29);
		
		txtPrice.setText("Current Price: Rs. " + prices.get(position).get(currentDate) + "/kg");
		txtPrevPrice.setText("Previous Price: Rs. " + prices.get(position).get(prevDate) + "/kg");
		img.setImageResource(products.get(position).getImage());
		
		return rowView;
	}
}