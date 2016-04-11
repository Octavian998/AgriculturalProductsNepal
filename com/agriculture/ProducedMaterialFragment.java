package com.agriculture;

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

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class ProducedMaterialFragment extends Fragment {
	ListView list;
	
	public ProducedMaterialFragment() {
		ProductList.populateProducedMaterialData();
		Price.populateProducedMaterialPrice();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		CustomList adapter = new CustomList(getActivity(), ProductList.productsProducedMaterial, Price.pricesProducedMaterial);
		list = (ListView) getActivity().findViewById(R.id.produced_material_list);

		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(
						getActivity(),
						"You Clicked at "
								+ ProductList.productsProducedMaterial.get(position).getName(),
						Toast.LENGTH_SHORT).show();
				Chart chart = new Chart();
				chart.openChart(position, Price.pricesProducedMaterial, getActivity().getBaseContext());
			}
		});
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_produced_material, container,
				false);
	}

}
