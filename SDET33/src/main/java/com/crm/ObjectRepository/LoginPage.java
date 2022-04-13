package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//step 1 public class name and give the class as webpage name
public class LoginPage {
		//declaration public ---> we will declare locator as private
      @FindBy(name = "user_name")
      private WebElement userNameTextField;
      
      @FindBy(name= "user_password")
      private WebElement passwordTextfield;
      
      @FindBy(id ="submitButton")
      private WebElement loginButton;

      public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
      }
	//step3 intialize we will create public constructor and intialize the element
      //public LoginPage(WebDriver driver) {
    	 // PageFactory.initElements(driver, this);//login page class //this--->take  driver object and objectand initalized 
    	  //pageFactory not used staleElement exception
//}
      //utilization by devloping public getters or bussiness library
      //way1  by creating public getters

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}


	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	//way2 by creating bussiness library
		//public void enterUN_PWD(String userName,String password) {
			
			//userNameTextField.sendKeys(userName);
			//passwordTextfield.sendKeys(password);
			//loginButton.click();
			
		
	/**
	 * 	
	 * @param driver
	 */
   // public void enterUN_PWD(S userName,String password) {
			public void ToLogin(String userName,String password) {
			userNameTextField.sendKeys(userName);
			passwordTextfield.sendKeys(password);
			loginButton.click();
			
		}
			
		
		
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
