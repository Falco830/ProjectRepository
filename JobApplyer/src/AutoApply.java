import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class AutoApply {
	static WebDriver driver;
	static String resumeUrl;
	
	public static synchronized void invokeBrowser() {
		try {
			
			//Selected Websitre
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe");
			//System.out.println(System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe"));
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			resumeUrl = "https://www.glassdoor.com/Job/redmond-junior-software-engineer-jobs-SRCH_IL.0,7_IC1150499_KO8,32.htm?jl=3018146910&ja=224&jaguid=000001690cec4c5c90a76680bc385bc3&pos=101&src=GD_JOB_AD&srs=EMAIL_EXACT_MATCH&s=224&ao=14295&utm_source=exactMatch&utm_medium=email&utm_campaign=em-email&utm_content=exact-match-recjob-0&utm_term=";
			//driver.get("https://www.duolingo.com/");
			driver.get(resumeUrl);
			chooseDirection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void chooseDirection() {
		
		String website = resumeUrl.substring(8, 25);
	
		System.out.println(website);
		switch(website) {
		case "www.glassdoor.com":
			System.out.println("Operating Glassdoor Website ");
			glassdoorApplying();
			break;
		
		}
	}
	
	public static void glassdoorApplying() {
		loginGlassDoor();
		easyApplyOption();
	}
	
	public static void easyApplyOption() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("applyCTA")).click();
		driver.findElement(By.id("gdFirstName")).sendKeys("Alec");
		driver.findElement(By.id("gdLastName")).sendKeys("Michel");
		driver.findElement(By.id("gdEmailAddress")).sendKeys("alecmichel@gmail.com");
		driver.findElement(By.id("gdCoverLetter")).sendKeys("Looking at your website and reading independent reviews of your company, I am excited about the prospect of acquiring a software developer position with you.  Having worked at Duke Energy, I much appreciate positive and open working environments.  At Duke, I worked in a modified cubicle environment as well as in a single room on a single table with a dozen colleagues, cranking out a project within a short time-frame.  I was known for being the first to get to work in the morning and for my sustained focus throughout the day. Socially, I enjoyed bonding with my co-workers on the job, as well as over Dungeons & Dragons, Topgolf and the occasional Happy Hour. I am particularly good at working with different personality types and am comfortable with improving my skills through constructive criticism.\r\n" + 
				"\r\n" + 
				"At Revature, I was trained on new software-based technologies, including Java Full Stack and Agile Scrum Methodology. I contributed to several web projects that were started by previous developers. I also have created projects from the ground up on my own, including an iOS chat app module for in-house use and a 'GoFundMe' like web application.  Longer-term projects like these, as well as my longtime study of the violin (since age 3) demonstrate my ability to do self-directed work with minimal supervision, problem-solve creatively, collaborate in small and large teams, and adapt to various work environments. \r\n" + 
				"\r\n" + 
				"Again, I am not afraid of challenges or asking for help when needed, and I appreciate good relationships with my co-workers.\r\n" + 
				"");
		driver.findElement(By.id("gdPhoneNumber")).sendKeys("509-899-3400");
		driver.findElement(By.id("address")).sendKeys("1309 East Skyline Drive Ellensburg WA 98926");

		if(driver.findElement(By.xpath("//label[text()='Are you authorized to work in the US for any employer?']")) != null) {
			driver.findElement(By.className("theme__input___cWZTL")).click();
		}
		
			driver.findElement(By.className("theme__input___cWZTL")).click();
			driver.findElement(By.className("theme__input___cWZTL")).click();
	}
	
	
	public static void loginGlassDoor(){
		System.out.println("Logging in... ");
		driver.findElement(By.className("sign-in")).click();
		driver.findElement(By.name("username")).sendKeys("alecmichel@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Legolas123gl!");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//driver.findElement(By.linkText("Sign In")).click();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		invokeBrowser();
		
	}

}
