import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommentKiller {
	
	
	 static WebDriver driver;
		
		public synchronized void LogOnDuolingo() {
			
			driver.findElement(By.id("sign-in-btn")).click();
			driver.findElement(By.id("top_login")).sendKeys("alecmichel@gmail.com");
			driver.findElement(By.id("top_password")).sendKeys("legolas123");
			driver.findElement(By.id("login-button")).click();
			
			
		}
		
	 
	public synchronized void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe");
			//System.out.println(System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe"));
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			
			driver.get("https://www.duolingo.com/");
			//searchCourse();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void selectDiscussion() {
		
		//driver.findElement(By.id("sign-in-btn")).click();
		driver.findElement(By.xpath("//a[text()='Discussion']")).click();
		
	}
	
	
	public static void main(String[] args) {
		
		CommentKiller myObj = new CommentKiller();

		myObj.invokeBrowser();
		myObj.LogOnDuolingo();
		myObj.selectDiscussion();
		
	}
}
