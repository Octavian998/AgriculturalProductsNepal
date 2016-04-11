package com.agriculture;

import com.agriculture.chart.Chart;
import com.agriculture.dummydata.Price;
import com.agriculture.dummydata.ProductList;
import com.agriculture.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class RawMaterialFragment extends Fragment {

	ListView list;

	public RawMaterialFragment() {
		ProductList.populateRawMaterialData();
		Price.populateRawMaterialPrice();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		super.onCreate(savedInstanceState);
		super.onActivityCreated(savedInstanceState);

		CustomList adapter = new CustomList(getActivity(), ProductList.productsRawMaterial, Price.pricesRawMaterial);
		list = (ListView) getActivity().findViewById(R.id.raw_material_list);

		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(
						getActivity(),
						"You Clicked at "
								+ ProductList.productsRawMaterial.get(position).getName(),
						Toast.LENGTH_SHORT).show();
				Chart chart = new Chart();
				chart.openChart(position, Price.pricesRawMaterial, getActivity().getBaseContext());
			}
		});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_raw_material, container,
				false);

	}
}
