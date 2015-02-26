package com.example.edu.ksu.crop.test;

import android.test.InstrumentationTestCase;

import com.example.edu.ksu.crop.DataSet;
import java.lang.reflect.*;

public class DataSetTest extends InstrumentationTestCase{
	
	private int headsPerPartAcre = 0;
	private DataSet mDataSet = new DataSet();

	@SuppressWarnings("rawtypes")
	Class noParams[] = {};
	@SuppressWarnings("rawtypes")
	Class stringParam[];
	@SuppressWarnings("rawtypes")
	Class intParam[];
	@SuppressWarnings("rawtypes")
	Class doubParam[];
	Object obj;
	public DataSetTest(){
		try{
			
			stringParam = new Class[1];
			stringParam[0] = String.class; 
			intParam = new Class[1];
			intParam[0] = Integer.TYPE;
			doubParam = new Class[1];
			doubParam[0] = Double.TYPE;
			obj = DataSet.class.newInstance();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	 
	public void testSetHeadsPerAcre(){
		try{
			Method method = DataSet.class.getDeclaredMethod("SetHeadsPerAcre", intParam);
			method.setAccessible(true);
			method.invoke(obj, 100);
			mDataSet.SetHeadsPerAcre(0);
			assertEquals(100, method);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testReturnHeadsPerAcre(){
		try{
			
			Field field = DataSet.class.getDeclaredField("headsPerPartAcre");
			field.setAccessible(true);
			field.setInt(obj, 173);
			Method method = DataSet.class.getDeclaredMethod("ReturnHeadsPerAcre", noParams);
			method.setAccessible(true);
			headsPerPartAcre = (Integer) method.invoke(obj, null);
			assertNotNull(headsPerPartAcre);
			assertEquals(173, headsPerPartAcre);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testAverageArea(){
		try{
			
			Field field = DataSet.class.getDeclaredField("areas");
			field.setAccessible(true);
			Method method = DataSet.class.getDeclaredMethod("AverageArea", noParams);
			method.setAccessible(true);
			method.invoke(obj, null);
			assertNotNull(mDataSet.AverageArea());
			mDataSet.AverageArea();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	public void testAddAreas(){
		try{

			Field field = DataSet.class.getDeclaredField("imageAreaCounter");
			field.setAccessible(true);
			mDataSet.AddAreas(22.2);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
