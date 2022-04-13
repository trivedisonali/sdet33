package com.crm.pratice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgTest {
@Test
public void testRunTest() {

	Reporter.log("hi",true);//if fails then we wont get any msg
}
	
public void beforesuite(){
	Reporter.log("hlw",true);
}
public void aftersuit() {
	Reporter.log("hi",true);
}

public void aftersuite() {
	Reporter.log("sonali",true);
}
//for group
    @Test(groups = ("smoke,Regression"))
    public void test2() {
	Reporter.log("testngtest-test2",true);
	
}
    @Test(groups= "regression")
    public void test3() {
Reporter.log("test3 -test4,true");
}
    
    
    
  
    	
    	
    	
    	
    }

