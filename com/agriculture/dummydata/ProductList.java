package com.agriculture.dummydata;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.agriculture.R;
import com.parse.*;
import com.parse.ParseQuery.CachePolicy;

public class ProductList {
	public static ArrayList<Product> productsRawMaterial;
	public static ArrayList<Product> productsFruits;
	public static ArrayList<Product> productsVegetables;
	public static ArrayList<Product> productsProducedMaterial;

	public static void populateFruitsData() {
		productsFruits = new ArrayList<>();

		// adding apple
		Product product = new Product();
		product.setName("Apple");
		product.setImage(R.drawable.apple);
		productsFruits.add(product);

		// adding grapes
		product = new Product();
		product.setName("Grapes");
		product.setImage(R.drawable.grapes);
		productsFruits.add(product);

		// adding mango
		product = new Product();
		product.setName("Mango");
		product.setImage(R.drawable.mango);
		productsFruits.add(product);

		// adding orange
		product = new Product();
		product.setName("Orange");
		product.setImage(R.drawable.orange);
		productsFruits.add(product);

		// adding papaya
		product = new Product();
		product.setName("Papaya");
		product.setImage(R.drawable.papaya);
		productsFruits.add(product);

		// adding pear
		product = new Product();
		product.setName("Pear");
		product.setImage(R.drawable.pear);
		productsFruits.add(product);

		// adding pineapple
		product = new Product();
		product.setName("Pineapple");
		product.setImage(R.drawable.pineapple);
		productsFruits.add(product);

		// adding pumpkin
		product = new Product();
		product.setName("Pumpkin");
		product.setImage(R.drawable.pumpkin);
		productsFruits.add(product);

		// adding strawberry
		product = new Product();
		product.setName("Strawberry");
		product.setImage(R.drawable.strawberry);
		productsFruits.add(product);

		// adding watermelon
		product = new Product();
		product.setName("Watermelon");
		product.setImage(R.drawable.watermelon);
		productsFruits.add(product);
	}

	public static void populateVegetableData() {
		productsVegetables = new ArrayList<>();

		// adding carrot
		Product product = new Product();
		product = new Product();
		product.setName("Carrot");
		product.setImage(R.drawable.carrot);
		productsVegetables.add(product);

		// adding garlic
		product = new Product();
		product.setName("Garlic");
		product.setImage(R.drawable.garlic);
		productsVegetables.add(product);

		// adding ginger
		product = new Product();
		product.setName("Ginger");
		product.setImage(R.drawable.ginger);
		productsVegetables.add(product);

		// adding onion
		product = new Product();
		product.setName("Onion");
		product.setImage(R.drawable.onion);
		productsVegetables.add(product);

		// adding potato
		product = new Product();
		product.setName("Potato");
		product.setImage(R.drawable.potato);
		productsVegetables.add(product);

		// adding tomato
		product = new Product();
		product.setName("Tomato");
		product.setImage(R.drawable.tomato);
		productsVegetables.add(product);
	}

	public static void populateRawMaterialData() {
		productsRawMaterial = new ArrayList<>();

		// adding apple
		Product product = new Product();
		product.setName("Apple");
		product.setImage(R.drawable.apple);
		productsRawMaterial.add(product);

		// adding carrot
		product = new Product();
		product.setName("Carrot");
		product.setImage(R.drawable.carrot);
		productsRawMaterial.add(product);

		// adding garlic
		product = new Product();
		product.setName("Garlic");
		product.setImage(R.drawable.garlic);
		productsRawMaterial.add(product);

		// adding ginger
		product = new Product();
		product.setName("Ginger");
		product.setImage(R.drawable.ginger);
		productsRawMaterial.add(product);

		// adding carrot
		product = new Product();
		product.setName("Mango");
		product.setImage(R.drawable.mango);
		productsRawMaterial.add(product);

		// adding onion
		product = new Product();
		product.setName("Onion");
		product.setImage(R.drawable.onion);
		productsRawMaterial.add(product);

		// adding onion
		product = new Product();
		product.setName("Orange");
		product.setImage(R.drawable.orange);
		productsRawMaterial.add(product);

		// adding potato
		product = new Product();
		product.setName("Potato");
		product.setImage(R.drawable.potato);
		productsRawMaterial.add(product);

		// adding tomato
		product = new Product();
		product.setName("Tomato");
		product.setImage(R.drawable.tomato);
		productsRawMaterial.add(product);
	}

	public static void populateProducedMaterialData() {
		productsProducedMaterial = new ArrayList<>();
		Product product;
		// adding bean
		product = new Product();
		product.setName("Bean");
		product.setImage(R.drawable.bean);
		productsProducedMaterial.add(product);

		// adding sugar
		product = new Product();
		product.setName("Sugar");
		product.setImage(R.drawable.sugar);
		productsProducedMaterial.add(product);
	}
}
