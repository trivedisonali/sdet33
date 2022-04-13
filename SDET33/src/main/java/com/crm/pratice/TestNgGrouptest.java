package com.crm.pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgGrouptest {

public class TestNgTest {
@Test
public void testRunTest() {

	Reporter.log("bye",true);//if fails then we wont get any msg
}
@BeforeMethod
public void beforesuite(){
	Reporter.log("bye2",true);
}
public void aftersuit() {
	Reporter.log("bye3",true);
}

public void aftersuite() {
	Reporter.log("sonali",true);
}
//for group execution
    @Test(groups = ("smoke,Regression"))
    public void test2() {
	Reporter.log("testngtest-test2",true);
	
}
    @Test(groups= "regression")
    public void test3(){
Reporter.log("test3 -test4,true");
}
}


}
