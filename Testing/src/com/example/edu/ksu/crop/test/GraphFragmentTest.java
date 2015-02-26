package com.example.edu.ksu.crop.test;

import java.lang.reflect.Method;

import com.example.edu.ksu.crop.GraphFragment;
import com.example.edu.ksu.crop.GraphViewData;


import android.test.InstrumentationTestCase;


public class GraphFragmentTest extends InstrumentationTestCase{
	
	@SuppressWarnings("rawtypes")
	Class intParam[] = {Integer.TYPE, Integer.TYPE, Integer.TYPE};
	GraphFragment mGraphFragment = new GraphFragment();
	Object objGF;
	int hpa = 100;
	int sph = 200;
	int spp = 300;
	
	public void testCalculateValues(){
		try{
			
			objGF = GraphFragment.class.newInstance();
			Method method = GraphFragment.class.getDeclaredMethod("CalculateValues", intParam);
			method.setAccessible(true);
			method.invoke(objGF, 100, 200, 300);
			GraphViewData[] gvd = (GraphViewData[]) method.invoke(objGF, hpa, sph, spp);
			assertNotNull(method.invoke(objGF, hpa, sph, spp));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testUpdateGraphView(){
		try{
			objGF = GraphFragment.class.newInstance();
			Method method = GraphFragment.class.getDeclaredMethod("UpdateGraphView", intParam);
			method.setAccessible(true);
			assertNotNull(method);
			assertEquals(200, method.invoke(objGF, 100, 200, 300));
			assertEquals(229, method.invoke(objGF, 125, 255, 356));

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}