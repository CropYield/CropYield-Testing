package com.example.edu.ksu.crop.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.example.edu.ksu.crop.FinalFragment;
import com.example.edu.ksu.crop.MainActivity;
import com.example.edu.ksu.crop.MainActivity.CalculateFragment;
import com.example.edu.ksu.crop.MainActivity.PlaceholderFragment;
import com.example.edu.ksu.crop.MainActivity.SoilFragment;
import com.example.edu.ksu.crop.MainActivity.WeatherFragment;

import android.test.InstrumentationTestCase;

public class MainActivityTest extends InstrumentationTestCase{
	
	@SuppressWarnings("rawtypes")
	Class intDoubParam[] = {Integer.TYPE, Double.TYPE};
	@SuppressWarnings("rawtypes")
	Class intParam[] = {Integer.TYPE};
	@SuppressWarnings("rawtypes")
	Class boolParam[] = {Boolean.class};
	
	MainActivity mMainActivity = new MainActivity();
	WeatherFragment mWeatherFragment = new WeatherFragment();
	SoilFragment mSoilFragment = new SoilFragment();
	CalculateFragment mCalculateFragment = new CalculateFragment();
	PlaceholderFragment mPlaceHolderFragment = new PlaceholderFragment();
	private int instance = 2;
	private int lengthOfForecast = 7;
	private String strLatitude = "44.50";
	private String strLongitude = "5.29";
	
	public void testPreConditions(){
		assertNotNull(mMainActivity);
		assertNotNull(mWeatherFragment);
		assertNotNull(mSoilFragment);
		assertNotNull(mCalculateFragment);
		assertNotNull(mPlaceHolderFragment);
	}

	@SuppressWarnings("static-access")
	public void testMainActivity(){
		try{
		assertNotNull(mCalculateFragment.newInstance(instance));
		assertNotNull(mPlaceHolderFragment.newInstance(instance));
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public void testWeatherFragment(){
		try{
			
			@SuppressWarnings("rawtypes")
			Class stringIntParam[] = {String.class, Integer.TYPE};
			
			assertNotNull(mWeatherFragment.newInstance(instance));
			Object objWF = WeatherFragment.class.newInstance();
			Method method = WeatherFragment.class.getDeclaredMethod("obtainLocation", boolParam);
			method.setAccessible(true);
			method.invoke(objWF, false);
		
			method = WeatherFragment.class.getDeclaredMethod("sendToast", stringIntParam);
			method.setAccessible(true);
			method.invoke(objWF, "Testing", 1);
			
			Field fieldForecast = WeatherFragment.class.getDeclaredField("LENGTH_OF_FORECAST");
			fieldForecast.setAccessible(true);
			assertTrue(fieldForecast.getInt(objWF) == lengthOfForecast);
			assertNotNull(method.invoke(objWF, "Testing", 1));
			
			Field fieldImages = WeatherFragment.class.getDeclaredField("weatherImages");
			fieldImages.setAccessible(true);
			int [] test = (int[]) fieldImages.get(objWF);
			assertTrue(test.length == 4);
			assertNotNull(method.invoke(objWF, "Testing", 1));
			
		}catch(Exception e){
			e.getCause().printStackTrace();
		}
	}
	
	public void testSoilFragment(){
		try{
			
			Class[] intParam = {Integer.TYPE};
			assertNotNull(mSoilFragment.newInstance(instance));
			Object objSF = SoilFragment.class.newInstance();
			Method method = SoilFragment.class.getDeclaredMethod("newInstance", intParam);
			method.setAccessible(true);
			method.invoke(objSF);
			
			Field fieldLat = SoilFragment.class.getDeclaredField("LATITUDE");
			fieldLat.setAccessible(true);
			assertEquals(strLatitude, fieldLat.get(objSF));
			Field fieldLon = SoilFragment.class.getDeclaredField("LONGITUDE");
			fieldLon.setAccessible(true);
			assertEquals(strLongitude, fieldLon.get(objSF));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}

