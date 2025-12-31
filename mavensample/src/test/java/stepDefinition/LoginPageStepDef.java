package stepDefinition;

import coreUtils.BaseClass;
import coreUtils.SeleniumHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.LoginPage;


public class LoginPageStepDef {
	//BaseClass baseClass = new BaseClass();
	//LoginPage loginPage = new LoginPage();
	
	//method for login feature and it glues with feature file
	@And("User navigates to loginpage")
	public void user_navigates_to_loginpage() throws Throwable {
		BaseClass.launchWebsite();
	    
	}
	
	@And("User validates all fields in the UI")
	public void User_validates_all_fields_in_the_UI() {
		
		String error;
		error = LoginPage.validateStaticTextinUI();
		//SeleniumHelper.logPass("Execution Ended successfully");
		if (!error.equals(""))
		{
			SeleniumHelper.logFail(error);
		}
		else
		{
			SeleniumHelper.logPass("No Failure:)");
		}

	}
	
	@And("User prints the list of usernames")
	public void user_prints_the_list_of_usernames() {
		LoginPage.toPrint();
	}
	@And("User enters Username and Password")
    public void user_enters_username_and_password() {
	LoginPage.login();
	}
	
	
}

