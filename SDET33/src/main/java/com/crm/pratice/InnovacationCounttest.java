package com.crm.pratice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InnovacationCounttest {//Same test-script executed with multiple Times with same test data we are using invocation count

@Test(invocationCount =3)
public void invocation() {
	Reporter.log("execute the statement",true);
}

//Same test-script executed with multiple Times with same test data we are using invocation count

@Test(invocationCount =3)
public void invocation1() {
	Reporter.log("execute the statement",false);
}
}