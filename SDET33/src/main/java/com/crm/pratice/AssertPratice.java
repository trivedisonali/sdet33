package com.crm.pratice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPratice {
@Test
public void assertpraticeTest() {
	String s = "Sdet33";
	Assert.assertEquals("s","sdet" );
	Reporter.log(s);
}
@Test
public void assertpraticeTest1() {
	String  s = "Sdet33";
	Assert.assertTrue(s.equals("Sdet33"));
	Reporter.log("printed or not");
	
}
	
@Test
public void  assertpraticeTest2() {
	SoftAssert sa = new SoftAssert();
	String s = "Sdet3";
	Reporter.log("line 19 - assertpraticeTest2");
	sa.assertAll();
	Reporter.log("line 18 -assertpraticeTest2");
}

@Test
public void assertpraticeTest3() {
	SoftAssert sa = new SoftAssert();
	String s = "sonali16";
	Reporter.log(s);
	
}

}


	
	
	
	
	
	

