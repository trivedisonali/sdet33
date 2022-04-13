package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cmr.genericUtility.WebDriverUtility;

public class HomePage {
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationTab;
	

	@FindBy(xpath="//img[contains(@src,'/user.PNG')]")
	private WebElement MouseHover;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOut;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationTab() {
		return OrganizationTab;
	}
	

	public WebElement getMouseHover() {
		return MouseHover;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	public void OrganizationTab() {
		OrganizationTab.click();
		

	}
	
	public void Logout(WebDriver driver) {
		WebElement mousehover=getMouseHover();
 		WebDriverUtility.moveToElement(driver, mousehover);
 		
        WebElement signout=getSignOut();
        signout.click();
        
        
        
        
        
        
	
	}

	public void logoutToApplication(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
}





		
	
	



		
	
	

 
 
     
     
 