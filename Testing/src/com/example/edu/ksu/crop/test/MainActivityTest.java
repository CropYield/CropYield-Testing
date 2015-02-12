package com.example.edu.ksu.crop.test;

import com.example.edu.ksu.crop.MainActivity;
import com.example.edu.ksu.crop.MainActivity.CalculateFragment;
import com.example.edu.ksu.crop.MainActivity.PlaceholderFragment;
import com.example.edu.ksu.crop.MainActivity.SoilFragment;
import com.example.edu.ksu.crop.MainActivity.WeatherFragment;

import android.test.InstrumentationTestCase;

public class MainActivityTest extends InstrumentationTestCase{
	
	MainActivity mMainActivity = new MainActivity();
	WeatherFragment mWeatherFragment = new WeatherFragment();
	SoilFragment mSoilFragment = new SoilFragment();
	CalculateFragment mCalculateFragment = new CalculateFragment();
	PlaceholderFragment mPlaceHolderFragment = new PlaceholderFragment();
	private int instance = 2;
	private int lengthOfForecast = 7;
	private double dLatitude, dLongitude = 0.0;
	private String strLatitude = "44.50";
	private String strLongitude = "5.29";
	
	public void testPreConditions(){
		assertNotNull(mMainActivity);
		assertNotNull(mWeatherFragment);
		assertNotNull(mSoilFragment);
		assertNotNull(mCalculateFragment);
		assertNotNull(mPlaceHolderFragment);
		assertNotNull(mMainActivity.lengthOfForecastTest());
		assertNotNull(mMainActivity.weatherLatitudeTest());
		assertNotNull(mMainActivity.weatherLongitudeTest());
		assertNotNull(mMainActivity.soilLatitudeTest());
		assertNotNull(mMainActivity.soilLongitudeTest());
	}
	@SuppressWarnings("static-access")
	public void testMainActivity(){
		assertNotNull(mCalculateFragment.newInstance(instance));
		assertNotNull(mPlaceHolderFragment.newInstance(instance));
	}
	@SuppressWarnings("static-access")
	public void testWeatherFragment(){
		assertNotNull(mWeatherFragment.newInstance(instance));
		assertEquals(lengthOfForecast, mMainActivity.lengthOfForecastTest());
		assertEquals(dLatitude, mMainActivity.weatherLatitudeTest());
		assertEquals(dLongitude, mMainActivity.weatherLongitudeTest());
	}
	@SuppressWarnings("static-access")
	public void testSoilFragment(){
		assertNotNull(mSoilFragment.newInstance(instance));
		assertEquals(strLatitude, mMainActivity.soilLatitudeTest());
		assertEquals(strLongitude, mMainActivity.soilLongitudeTest());
	}
	
}

