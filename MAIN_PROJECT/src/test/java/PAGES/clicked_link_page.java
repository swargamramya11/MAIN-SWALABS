package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BASE_CLASSES.DRIVERWAIT;

public class clicked_link_page {
	WebDriver dr;
	DRIVERWAIT d;
	By verify_text=By.xpath("//h1[@class='supertitle ']");
//constructor for driver
public clicked_link_page(WebDriver dr)
		{
			this.dr=dr;
			d=new DRIVERWAIT(dr);
		}
//To verify whether the page is navigated correctly
public void verify_page()        
		{
			System.out.println("page navigatedd to corresponding clicked link");
			String expected_text="CONTINUOUS TESTING CLOUD";
			WebElement w1=d.visibility(verify_text,20);         
			String actual_text=w1.getText();
			Assert.assertTrue(expected_text.contains(actual_text));
			System.out.println("page navigated correctly");
		}
}
