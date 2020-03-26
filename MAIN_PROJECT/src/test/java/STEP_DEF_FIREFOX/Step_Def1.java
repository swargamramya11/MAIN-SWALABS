package STEP_DEF_FIREFOX;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import BASE_CLASSES.EXCEL;
import BASE_CLASSES.LAUNCHBROWSER;
import PAGES.About_page;
import PAGES.Add_to_cart_page;
import PAGES.Login_page;
import PAGES.clicked_link_page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step_Def1 extends EXCEL{
	static WebDriver dr;
	Login_page L;
	Add_to_cart_page A;
	About_page A1;
	clicked_link_page c;
	@Given("^Browser is launched & login page displayed$")
	public void browser_is_launched_login_page_displayed() throws Throwable {
		 read();
		 dr=LAUNCHBROWSER.launchbrowser("firefox","https://www.saucedemo.com/");
		 dr.manage().window().maximize();
	}

	@When("^User enters valid login credentials  of set (\\d+) & clicks on login$")
	public void user_enters_valid_login_credentials_of_set_clicks_on_login(int arg1) throws Throwable {
		int row=arg1;
		String Username=testdata[row][0];
		String Password=testdata[row][1];
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		L=new Login_page(dr);
		System.out.println(Username+" "+Password);
		L.login_functions(Username,Password);
	}

	@Then("^Select the Name AtoZ and Add to Cart the items$")
	public void select_the_Name_AtoZ_and_Add_to_Cart_the_items() throws Throwable {
		System.out.println("login is successfull");
		A=new Add_to_cart_page(dr);
		A.functions();
	}

	@Then("^Moving to About page and Click the Learn_More$")
	public void moving_to_About_page_and_Click_the_Learn_More() throws Throwable {
		 A1=new About_page(dr);
		 A1.about_functions();
		 c=new clicked_link_page(dr); 
		 c.verify_page();
		 dr.close();
	}

	@When("^User enters Invalid login credentials  of set (\\d+) & clicks on login$")
	public void user_enters_Invalid_login_credentials_of_set_clicks_on_login(int arg1) throws Throwable {
		int row=arg1;
		String Username=testdata[row][0];
		String Password=testdata[row][1];
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		L=new Login_page(dr);
		System.out.println(Username+" "+Password);
		L.login_functions(Username,Password);
		dr.close();
	}

	@Then("^Display an Error message with Invalid credentials$")
	public void display_an_Error_message_with_Invalid_credentials() throws Throwable {
		System.out.println("login is unsuccessfull due to invalid credentials");
		System.out.println(L.Error);
	}

	@When("^User leaves manditory field as blank of set (\\d+) & clicks on login$")
	public void user_leaves_manditory_field_as_blank_of_set_clicks_on_login(int arg1) throws Throwable {
		int row=arg1;
		String Username=testdata[row][0];
		String Password=testdata[row][1];
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		L=new Login_page(dr);
		System.out.println(Username+" "+Password);
		L.login_functions(Username,Password);
		dr.close();
	}

	@Then("^Display an Error message with blank fields$")
	public void display_an_Error_message_with_blank_fields() throws Throwable {
		System.out.println("login is unsuccessfull due to manitory fields left blank");
		System.out.println(L.Error);
	}
}
