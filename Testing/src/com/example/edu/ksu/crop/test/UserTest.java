package com.example.edu.ksu.crop.test;

import com.example.edu.ksu.crop.User;

import android.test.InstrumentationTestCase;

public class UserTest extends InstrumentationTestCase{
	
	private String testUser = "testUserName";
	private String testEmail = "testEmail@gmail.com";
	User user = new User(testUser, testEmail);
	
	public void testGetUsername(){
		assertNotNull(user.getUsername());
		assertEquals(testUser,user.getUsername());
		assertNotSame(testUser, testEmail);
	}
}
