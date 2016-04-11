package com.agriculture.fragment;

import com.agriculture.CustomList;
import com.agriculture.R;
import com.agriculture.chart.Chart;
import com.agriculture.dummydata.Price;
import com.agriculture.dummydata.ProductList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class VegetablesFragment extends Fragment {
	ListView list;
	
	public VegetablesFragment() {
		ProductList.populateVegetableData();
		Price.populateVegetablesPrice();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		CustomList adapter = new CustomList(getActivity(), ProductList.productsVegetables, Price.pricesVegetables);
		list = (ListView) getActivity().findViewById(R.id.vegetables_list);

		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(
						getActivity(),
						"You Clicked at "
								+ ProductList.productsVegetables.get(position).getName(),
						Toast.LENGTH_SHORT).show();
				Chart chart = new Chart();
				chart.openChart(position, Price.pricesVegetables, getActivity().getBaseContext());
			}
		});
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_vegetables, container,
				false);
	}
}
