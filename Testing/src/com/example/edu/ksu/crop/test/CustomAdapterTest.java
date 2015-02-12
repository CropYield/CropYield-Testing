package com.example.edu.ksu.crop.test;

import java.util.ArrayList;

import com.example.edu.ksu.crop.CustomAdapter;

import android.content.Context;
import android.test.InstrumentationTestCase;

public class CustomAdapterTest extends InstrumentationTestCase{
	
	int[] mImages = new int[] {0,1,2,3,4,5,6};
	ArrayList<Integer> mIcons = new ArrayList<Integer>();
	ArrayList<String> mWeatherInfo = new ArrayList<String>();
	CustomAdapter mCustomAdapter;
	private int lengthOfForecast = 7;
	
	public void testCustomAdapter(){
		Context ctx = getInstrumentation().getContext();
		assertNotNull(ctx);
		mCustomAdapter = new CustomAdapter(ctx, mImages, mIcons,mWeatherInfo);
		assertNotNull(mCustomAdapter.getCount());
		assertNotNull(mCustomAdapter.getItem(0));
		assertNotNull(mCustomAdapter.getItemId(0));
		assertNotNull(mCustomAdapter);
		assertNotNull(mIcons);
		assertNotNull(mWeatherInfo);
		assertEquals(7, mCustomAdapter.getCount());
		assertEquals(lengthOfForecast,mCustomAdapter.getCount());
		assertEquals(1,mCustomAdapter.getItemId(1));
		assertEquals(0,mCustomAdapter.getItem(0));
	}
	
}
