package com.crm.pratice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethod {
	


@Test(dependsOnMethods="introtest")
	public void modifyselfintrotest() {
		Reporter.log(" modify i am fine",true);
}

@Test(dependsOnMethods="modifyselfintrotest")
public void modifycitytest() {
Reporter.log(" modify which is your fav city",true);
}
@Test(dependsOnMethods= "modifycitytest")
public void favcitytest() {
	Reporter.log(" modify city name bhopal",true);
}
	
	
	

}
