package stepDef;

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
		WebElement patientDashboardLink = driver.findElement(By.xpath("//*[@id=\"Inpatient Ward\"]"));
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
		driver.findElement(By.name("givenName")).sendKeys(givenname);
        driver.findElement(By.name("middleName")).sendKeys(middlename);
        driver.findElement(By.name("familyName")).sendKeys(familyname);
	}

	@When("User selects Unidentified Patient")
	public void user_selects_unidentified_patient() {
		WebElement checkbox = driver.findElement(By.id("checkbox-unknown-patient"));
        checkbox.click();
	}

	@When("User selects gender")
	public void user_selects_gender() {
		WebElement gender=driver.findElement(By.id("gender-field"));
		
		Select sel=new Select(gender);
		
		sel.selectByVisibleText("Female");
		
	}

	@When("User clicks on continue and confirm button")
	public void user_clicks_on_continue_and_confirm_button() {
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("submit")).click();
	}

	@Then("User account should get created sucessfully")
	public void user_account_should_get_created_sucessfully() {
	    System.out.println("Account Created");
	}

	
}
