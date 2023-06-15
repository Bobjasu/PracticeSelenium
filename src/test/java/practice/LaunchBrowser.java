package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	public static void main(String[] args) throws Throwable {
		/*String key = "webdriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		
		System.setProperty(key, value);*/
		
		WebDriver driver;
		
		FileInputStream fi=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fi);
		String BROWSER = prop.getProperty("browser");
		if(BROWSER=="chrome")
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER=="firefox")
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER=="edge")
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		String Url = prop.getProperty("url");
		String UN = prop.getProperty("UserName");
		String PWD = prop.getProperty("Password");
		
		driver.get(Url);
		
		Thread.sleep(2000);	
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("‪F:\\abcf.jpg");
		
		FileUtils.copyFile(src, dest);
		
	}

}
