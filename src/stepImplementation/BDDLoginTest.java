package stepImplementation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoginTest {

	
	
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		System.out.println("user is on the login page");
		
	}
	
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password() {
		System.out.println("correct username and password are entered");
		
		
		
	}
	
	
	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("give user the confirmations");
		
		
		
		
	}
	
	
}
