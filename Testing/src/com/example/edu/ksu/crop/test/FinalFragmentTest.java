package com.example.edu.ksu.crop.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.test.InstrumentationTestCase;

import com.example.edu.ksu.crop.FinalFragment;
import com.example.edu.ksu.crop.GraphViewData;


public class FinalFragmentTest extends InstrumentationTestCase{
	
	@SuppressWarnings("rawtypes")
	Class intDoubParam[] = {Integer.TYPE, Double.TYPE, Integer.TYPE};
	@SuppressWarnings("rawtypes")
	Class intParam[] = {Integer.TYPE, Integer.TYPE, Integer.TYPE};
	FinalFragment mFinalFragment = new FinalFragment();
	Object objFF;
	private int seedsPerPound = 15500;
	static int headsPerAcreInt = 50000;
	static double grainNum = 1797;
	int hpa = 100;
	int sph = 200;
	int spp = 300;
	
	public FinalFragmentTest(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void testCalculateValues(){
		try{
			
			objFF = FinalFragment.class.newInstance();
			Method method = FinalFragment.class.getDeclaredMethod("CalculateValues", intDoubParam);
			method.setAccessible(true);
			method.invoke(objFF, headsPerAcreInt, grainNum, seedsPerPound);
			Field fieldAvg = FinalFragment.class.getDeclaredField("averageBUA");
			fieldAvg.setAccessible(true);
			
			Field fieldSeeds = FinalFragment.class.getDeclaredField("seedsPerPound");
			fieldSeeds.setAccessible(true);
			
			assertTrue(fieldAvg.getDouble(objFF) > 9000);
			assertEquals(15500, fieldSeeds.getInt(objFF));
			GraphViewData[] gvd = (GraphViewData[]) method.invoke(objFF, headsPerAcreInt, grainNum, seedsPerPound);
			assertNotNull(gvd);
			assertNotNull(method.invoke(objFF, hpa, sph, spp));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testUpdateGraphView(){
		try{
			int slider = -1;
			objFF = FinalFragment.class.newInstance();
			Method method = FinalFragment.class.getDeclaredMethod("UpdateGraphView", intParam);
			method.setAccessible(true);
			assertNotNull(method.invoke(objFF, hpa, sph, spp));
			slider = (Integer) method.invoke(objFF, hpa, sph, spp);
			assertNotNull(slider);
			assertTrue(slider >= 0);
			assertTrue(slider <= 1000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
