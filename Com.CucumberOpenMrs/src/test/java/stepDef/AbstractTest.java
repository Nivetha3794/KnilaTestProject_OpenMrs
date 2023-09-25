package stepDef;
import org.concordion.api.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AbstractTest {
	public static WebDriver driver;
	//create driver
    @BeforeSuite
    
    public void webdriverSetUp() {
    	WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
    	//System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\SkyFramework\\src\\test\\java\\chromedriver.exe");
      //driver = new ChromeDriver();       
		}

    //Method you will call in your test 
    public static WebDriver getDriver() {
      return driver;
    }
  }
