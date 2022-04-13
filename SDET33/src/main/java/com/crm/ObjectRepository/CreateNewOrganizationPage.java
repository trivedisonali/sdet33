package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Step:1:We should create public class and give the class name as webpage name

public class CreateNewOrganizationPage {

	//Step:2:declaration--->We will declare locators as private
	
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement AssignTo;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Save;
	
	
	//Step:3:Initialization--->We will create public constructors and initialize the element variables
	
	public CreateNewOrganizationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}


	//Step:4:Utilization--->by developing public getters or /and busniness library
	//way:1
	
	public WebElement getOrganizationName() {
		return OrganizationName;
	}


	public WebElement getAssignTo() {
		return AssignTo;
	}
	
	public WebElement getSave() {
		return Save;
	}
	

	//way:2
	public void  CreateNewOrgPagewithOrgNameAssignTo (String OrgName) {
		
		OrganizationName.sendKeys(OrgName);
		AssignTo.click();
		Save.click();
		}
	
	public void CreateNewOrgPageWithOrgName(String OrgName) {
		OrganizationName.sendKeys(OrgName);
		Save.click();
	}
	
	}


