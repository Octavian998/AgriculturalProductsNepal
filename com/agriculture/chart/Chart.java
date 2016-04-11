package com.agriculture.chart;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class Chart {
	public void openChart(int position, ArrayList<HashMap<Date, Float>> prices, Context context) {
    	
    	// Creating an  XYSeries for Income
    	XYSeries priceSeries = new XYSeries("Price");
    	// Creating an  XYSeries for Income
    	for(int i=1;i<=30;i++){
    		Date date = new Date(2014, 11, i);
    		priceSeries.add(i, prices.get(position).get(date));
    	}
    	
    	// Creating a dataset to hold each series
    	XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
    	// Adding Income Series to the dataset
    	dataset.addSeries(priceSeries);   	
    	
    	
    	// Creating XYSeriesRenderer to customize incomeSeries
    	XYSeriesRenderer priceRenderer = new XYSeriesRenderer();
    	priceRenderer.setColor(Color.WHITE);
    	priceRenderer.setPointStyle(PointStyle.DIAMOND);
    	priceRenderer.setFillPoints(true);
    	priceRenderer.setLineWidth(2);
    	priceRenderer.setDisplayChartValues(true);
    	
    	
    	// Creating a XYMultipleSeriesRenderer to customize the whole chart
    	XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
    	
    	multiRenderer.setApplyBackgroundColor(true);
    	multiRenderer.setBackgroundColor(Color.BLACK);
    	multiRenderer.setMarginsColor(Color.BLACK);
    	
    	multiRenderer.setXLabels(0);
    	multiRenderer.setChartTitle("Price Chart");
    	multiRenderer.setXTitle("2014/11/");
    	multiRenderer.setYTitle("Price in Rs.");
    	multiRenderer.setZoomButtonsVisible(true);    	    	
    	for(int i=1;i<=30;i++){
    		multiRenderer.addXTextLabel(i, String.valueOf(i));    		
    	}    	
    	
    	// Adding incomeRenderer and expenseRenderer to multipleRenderer
    	// Note: The order of adding dataseries to dataset and renderers to multipleRenderer
    	// should be same
    	multiRenderer.addSeriesRenderer(priceRenderer);
    	
    	// Creating an intent to plot line chart using dataset and multipleRenderer
    	Intent intent = ChartFactory.getLineChartIntent(context, dataset, multiRenderer);
    	
    	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	// Start Activity
    	context.startActivity(intent);
	}
}
