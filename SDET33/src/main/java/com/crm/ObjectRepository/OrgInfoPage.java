package com.crm.ObjectRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {                  //to verify organization name

	@FindBy(id="dtlview_Organization Name")
	private WebElement OrgInfo;

	
	
   public OrgInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}



public WebElement getOrgInfo() {
	return OrgInfo;
}
   
   public String fetchOrgName() {
	   String text=OrgInfo.getText();
	   return text;
	   
   }
}
