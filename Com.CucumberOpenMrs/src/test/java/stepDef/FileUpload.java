package stepDef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FileUpload extends AbstractTest{
	@Given("User is on File Upload Page")
	public void user_is_on_file_upload_page() {
		driver.getTitle();
	}

	@When("User select the upload link")
	public void user_select_the_upload_link() throws AWTException {
		driver.findElement(By.xpath("//*[@id=\"visit-documents-dropzone\"][@class=\"dropzone ng-pristine ng-valid dz-clickable\"]")).click();
		Robot robot = new Robot();
		robot.delay(1000);
		StringSelection str=new StringSelection("C:\\Users\\91959\\OneDrive\\Desktop\\OpenMRS\\Medical.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("User enters caption in the text box {string}")
	public void user_enters_caption_in_the_text_box(String MedicalDocument) {
		driver.findElement(By.xpath("//*[@placeholder='Enter a caption']")).sendKeys(MedicalDocument);
	}

	@When("User clicks the upload file button")
	public void user_clicks_the_upload_file_button() {
		driver.findElement(By.xpath("//*[@class='confirm ng-binding']")).click();
	}

	@Then("User should see a Success toast message")
	public void user_should_see_a_success_toast_message() {
		String toastmessage=driver.findElement(By.xpath("//html/body/div[2]/div/div/p")).getText();
        System.out.println("the toast message is" + toastmessage);
        WebElement link = driver.findElement(By.xpath("/html/body/ul/li[2]/a\r\n"));
        link.click();
	}

	@Then("uploaded file is displayed on the home page")
	public void uploaded_file_is_displayed_on_the_home_page() {
		LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.toString();
        System.out.println("Current Date: " + formattedDate);
        String date=driver.findElement(By.xpath("//a[@class='ng-binding']")).getText();
        System.out.println("Recent visit: " + date);
        String tag=driver.findElement(By.xpath("//div[@class='tag ng-binding ng-scope']")).getText();
        System.out.println("attachment tag is present with name " + tag);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[9]/div[3]/div/ul[1]/li[1]/a/div/div[2]")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/div/ul/li[8]/a/div/div[2]")).click();
        driver.findElement(By.id("delete-reason")).sendKeys("Invalid information");
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/button[1]")).click();
        driver.findElement(By.id("patient-search")).sendKeys("Invalid information");
        String records=driver.findElement(By.xpath("//td[@class='dataTables_empty']")).getText();
        System.out.println("The given patient data " + records);
	}
}
