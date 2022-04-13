package com.cmr.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryaImplement implements IRetryAnalyzer{
int count=0;
int maxlimit=5;

public boolean retry(ITestResult result) 
{
	if(count<maxlimit)
	{
		count++;
		return true;
	}
	
	return false;
}
}
