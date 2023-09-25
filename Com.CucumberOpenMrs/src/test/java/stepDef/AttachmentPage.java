package stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
 

public class AttachmentPage extends AbstractTest {
	//WebDriver driver;
	
	@Given("User is on the attachment page")
	public void user_is_on_the_attachment_page() {
		driver.getTitle();
	}

	@When("User clicks on Startvisit link")
	public void user_clicks_on_startvisit_link() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement hyperlink = driver.findElement(By.linkText("Start Visit"));
		hyperlink.click();
	}

	@When("clicks on confirm button")
	public void clicks_on_confirm_button() {
		driver.findElement(By.xpath("//*[@id='start-visit-with-visittype-confirm'][@class='confirm right']")).click();
	}

	@When("User clicks the Attachments link")
	public void user_clicks_the_attachments_link() {
		driver.findElement(By.xpath("//*[@id='attachments.attachments.visitActions.default'][@class='button task activelist']")).click();
	}

	@Then("User should be on the file attachment page")
	public void user_should_be_on_the_file_attachment_page() {
		System.out.println("User is on attachment page");
		//driver.findElement(By.xpath("//*[@id=\"visit-documents-dropzone\"][@class=\"dropzone ng-pristine ng-valid dz-clickable\"]")).click();
	}


}
