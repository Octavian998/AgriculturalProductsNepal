package com.agriculture;

import com.agriculture.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements TabListener,
		OnItemClickListener {

	private DrawerLayout drawerLayout;
	private ListView listView;
	private String[] drawerList;
	private ActionBarDrawerToggle drawerListener;

	private ActionBar actionBar;
	private ViewPager viewPager;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// for drawer_navigation
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerList = getResources().getStringArray(R.array.drawerList);
		listView = (ListView) findViewById(R.id.drawerList);
		// listView.setAdapter(new ArrayAdapter<>(this,
		// android.R.layout.simple_list_item_1, drawerList));
		DrawerAdapter drawerAdapter = new DrawerAdapter(this);
		listView.setAdapter(drawerAdapter);

		listView.setOnItemClickListener(this);
		drawerListener = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			@Override
			public void onDrawerClosed(View drawerView) {
				//Toast.makeText(MainActivity.this, "Drawer Closed",
				//		Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				//Toast.makeText(MainActivity.this, "Drawer Opened",
				//		Toast.LENGTH_SHORT).show();
			}

		};
		drawerLayout.setDrawerListener(drawerListener);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// for tab_menu
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				actionBar.setSelectedNavigationItem(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab fruits = actionBar.newTab().setText("Fruits").setTabListener(this);

		Tab vegetables = actionBar.newTab().setText("Vegetables")
				.setTabListener(this);

		Tab producedMaterials = actionBar.newTab()
				.setText("Produced Materials").setTabListener(this);

		actionBar.addTab(fruits);
		actionBar.addTab(vegetables);
		actionBar.addTab(producedMaterials);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerListener.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerListener.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}

	// tab_menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// Log.d("Binod", "Reselected" + arg0.getText());

	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// Log.d("Binod", "Selected" + arg0.getText());
		viewPager.setCurrentItem(arg0.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// Log.d("Binod", "Unselected" + arg0.getText());
	}

	// when navigation_drawer clicked
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long id) {
		Toast.makeText(this, drawerList[position], Toast.LENGTH_LONG).show();
		selectItem(position);
	}

	public void selectItem(int position) {
		listView.setItemChecked(position, true);
		setTitle(drawerList[position]);
		if (position == 0) {
			drawerLayout.closeDrawers();
			
		} else if (position == 1) {
			setTitle("KrishiBazar");
			drawerLayout.closeDrawers();
			Intent intent = new Intent(getApplicationContext(), Complain.class);
		    startActivity(intent);
		} else if (position == 2) {
			setTitle("KrishiBazar");
			drawerLayout.closeDrawers();
			Intent intent = new Intent(getBaseContext(), DataAnalytics.class);
			startActivity(intent);
		}
	}

	public void setTitle(String title) {
		getActionBar().setTitle(title);
	}
}
