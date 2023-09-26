package stepDef;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001 extends AbstractTest {

	//WebDriver driver;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		//driver=DriverFactory.getDriver();
		
		driver.getTitle();
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@When("user select the location")
	public void user_select_the_location() {
		WebElement patientDashboardLink = driver.findElement(By.xpath("//li[@id='Laboratory']"));
        patientDashboardLink.click();
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.id("loginButton")).click();
	   
	}

	@When("user navigated to Register a Patient page")
	public void user_navigated_to_register_a_patient_page() {
		
		String actualTitle = driver.getTitle();
		System.out.println("The Title is" + actualTitle);
		WebElement Register = driver.findElement(By.xpath("//*[@id=\"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension\"]"));
        Register.click();
	}

	@When("user enters {string} and {string} and {string}")
	public void user_enters_and_and(String givenname, String middlename, String familyname) {
		
		//final String Name=givenname;
		driver.findElement(By.name("givenName")).sendKeys(givenname);
        driver.findElement(By.name("middleName")).sendKeys(middlename);
        driver.findElement(By.name("familyName")).sendKeys(familyname);
	}

	@When("user clicks continue by selects gender")
	public void user_clicks_continue_by_selects_gender() {
		WebElement checkbox = driver.findElement(By.xpath("//button[@id='next-button']"));
        checkbox.click();
        WebElement gender=driver.findElement(By.id("gender-field"));
		
		Select sel=new Select(gender);
		
		sel.selectByVisibleText("Female");
	}
	
	@When("User Clicks next button enters {int} and {string} and {int}")
	public void user_clicks_next_button_enters_and_and(Integer int1, String month, Integer int2) {
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.name("birthdateDay")).sendKeys("03");
        WebElement monthdd=driver.findElement(By.xpath("//*[@id=\"birthdateMonth-field\"][@name=\"birthdateMonth\"]"));
		
		Select mon=new Select(monthdd);
		
		mon.selectByVisibleText(month);
		driver.findElement(By.name("birthdateYear")).sendKeys("2000");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
	}
	
	@When("user enters address details and phonenumber")
	public void user_enters_address_details_and_phonenumber() {
		
		driver.findElement(By.xpath("//*[@id=\"address1\"][@name=\"address1\"]")).sendKeys("South");
		driver.findElement(By.xpath("//*[@id=\"address2\"][@name=\"address2\"]")).sendKeys("Street");
		driver.findElement(By.xpath("//*[@id=\"cityVillage\"][@name=\"cityVillage\"]")).sendKeys("cbe");
		driver.findElement(By.xpath("//*[@id=\"stateProvince\"][@name=\"stateProvince\"]")).sendKeys("Tamilnadu");
		driver.findElement(By.xpath("//*[@id=\"country\"][@name=\"country\"]")).sendKeys("India");
		driver.findElement(By.xpath("//*[@id=\"postalCode\"][@name=\"postalCode\"]")).sendKeys("3333");
		driver.findElement(By.xpath("//*[@id=\"next-button\"][@class=\"confirm right\"]")).click();
		driver.findElement(By.xpath("//*[@name=\"phoneNumber\"]")).sendKeys("2233435");
		driver.findElement(By.xpath("//*[@id=\"next-button\"][@class=\"confirm right\"]")).click();
	}
	
	@When("User enters the {string} and {string}")
	public void user_enters_the_and(String reltype, String personname) {
		WebElement relationtype=driver.findElement(By.xpath("//*[@id='relationship_type'][@name='relationship_type']"));
		
		Select mon=new Select(relationtype);
		
		mon.selectByVisibleText(reltype);
		driver.findElement(By.xpath("//input[@placeholder='Person Name']")).sendKeys(personname);
	}
	
	@When("User clicks by continue and validating the information")
	public void user_clicks_by_continue_and_validating_the_information() {
		driver.findElement(By.id("next-button")).click();
		//assert.assertEquals(false, givenname);
		
	}
	@Then("User clicks confirm button should get account created sucessfully")
	public void user_clicks_confirm_button_should_get_account_created_sucessfully() {
		driver.findElement(By.id("submit")).click();
		
		System.out.println("Account Created");
	}
	

	
}
