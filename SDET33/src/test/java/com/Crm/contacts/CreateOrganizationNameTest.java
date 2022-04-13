package com.Crm.contacts;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cmr.genericUtility.BaseClass;
import com.cmr.genericUtility.ExcelUtility;
import com.cmr.genericUtility.FileUtility;
import com.cmr.genericUtility.JavaUtility;
import com.crm.ObjectRepository.CreateNewOrganizationPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.OrgInfoPage;
public class CreateOrganizationNameTest extends BaseClass {
	

	@Test
	
	//instead of main method its @test
	 
	public void createOrganizationNameTest() throws Throwable  {
		
		//create the object for POM class
		 CreateOrganizationPage createorgpage=new CreateOrganizationPage(driver);
		 CreateNewOrganizationPage createneworgpage=new CreateNewOrganizationPage(driver);
         OrgInfoPage orginfo=new OrgInfoPage(driver);
		
		
		//store variable
        int random = JavaUtility.generateRandomNumber(1000);
		String orgName=ExcelUtility.fetchData(FileUtility.fetchDataFromProperty("excelsheetname"), 12, 2);
		String orgnaization_Name=orgName+random;
		//click on organization tab
		//HomePage hp =new HomePage(driver);
		homepage.OrganizationTab();
		
		//click on create organization
		createorgpage.createOrganization();
		
		//create org and save
		createneworgpage.CreateNewOrgPageWithOrgName(orgnaization_Name);
		
		
		//verify org
      String actOrgName = orginfo.fetchOrgName();
		
      Assert.assertEquals(orgName, actOrgName);
		//if(orgName.equalsIgnoreCase(actOrgName))
		//{
			
			Reporter.log("Organization created successfully",true);
			
		//}	
		
	}
}

	