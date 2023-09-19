package PhantomJSHeadlessBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomJSDriverConcept 
{
    public static void main( String[] args )
    {
		WebDriver phantomJSDriver;
		
        DesiredCapabilities caps = new DesiredCapabilities();
	    ((DesiredCapabilities) caps).setJavascriptEnabled(true);
	    ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
	    ((DesiredCapabilities) caps).setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Data\\Selenium\\Softwares\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
	    caps.setJavascriptEnabled(true);
	    String [] phantomJsArgs = {"--web-security=no", "--ignore-ssl-errors=yes"};
	    caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);

		/* First:Download the PhantomJS.exe binary for Windows and also the Jar file of PhantomJS driver 
		from Mvn repository.
		"PhantomJS" is a headless browser with JavaScript API. It is an optimal solution
		 for Headless Website Testing, access and manipulate webpages & comes with the standard DOM API.
		In order to use PhantomJS with Selenium, one has to use GhostDriver. 
		GhostDriver is a implementation of Webdriver Wire protocol in simple JS for PhantomJS.
		The latest release of PhatomJS has integrated GhostDriver and there is no need to separately install it.
		
		Important Features:
		-phantomJSdriver internally uses ghost driver
		-ghostdriver is used as JSON wire protocol -- HTTP REST calls
		-headless browser testing:
		-no browser will be launched
		-testing is happening behind the scene
		-its very fast
		-it directly interacts with your app HTML DOM  */

		System.setProperty("phantomjs.binary.path",
		"C:\\Data\\Selenium\\Softwares\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		 //launch PhantomJS Headless browser
		 //phantomJSDriver = new PhantomJSDriver(caps);
		 phantomJSDriver = new PhantomJSDriver();
		 
		 //phantomJSDriver is unavailable in Selenium 3.x.
		 //So we need to download it for use as *.jar file.Include in the project.
		 phantomJSDriver.manage().window().maximize(); //maximize the windows
		 phantomJSDriver.manage().deleteAllCookies(); // delete all the cookies
		
		 phantomJSDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 phantomJSDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 
		 phantomJSDriver.get("https://classic.crmpro.com");
		 System.out.println("The title before login  is => "+ phantomJSDriver.getTitle());
		 WebElement uname = phantomJSDriver.findElement(By.name("username"));
		 uname.sendKeys("batchautomation");
		 WebElement pwd = phantomJSDriver.findElement(By.name("password"));
		 pwd.sendKeys("Test@12345");
		 
		 WebElement loginBtn = phantomJSDriver.findElement(By.xpath("//input[@type='submit']"));
		 loginBtn.click();
		 System.out.println("The title after login is => "+ phantomJSDriver.getTitle());
		 
		 phantomJSDriver.quit();
		
		
    }
}
