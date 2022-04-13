package com.crm.pratice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class prioritytest
{
@Test(priority=1)
public void introtest() {
	Reporter.log("how are you",true);
}

@Test(priority = 2)
	public void selfintrotest() {
		Reporter.log("i am fine",true);
}

@Test(priority=3)
public void citytest() {
Reporter.log("which is your fav city",true);
}
@Test(priority=4)
public void favcitytest() {
	Reporter.log("bhopal",true);
}
}