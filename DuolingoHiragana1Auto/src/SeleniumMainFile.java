import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumMainFile extends Thread implements Cloneable{
  
    public void run() {
        // compute primes larger than minPrime
    	SeleniumMainFile myObj = new SeleniumMainFile(); 
    	myObj.MainExecution();
    }
	
	 static WebDriver driver;
	
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
	
	public void searchCourse() {
		
		try {
			driver.findElement(By.id("search-inpl")).sendKeys("Java");
			Thread.sleep(3000);
			driver.findElement(By.id("search-button-bottom")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void LogOnDuolingo() {
		
		driver.findElement(By.id("sign-in-btn")).click();
		driver.findElement(By.id("top_login")).sendKeys("alecmichel@gmail.com");
		driver.findElement(By.id("top_password")).sendKeys("");
		driver.findElement(By.id("login-button")).click();
		
		
	}
	
	public void SelectHiragana1() {
		try {
			while(driver.getCurrentUrl().equals("https://www.duolingo.com/")) {
				driver.findElement(By.xpath("//span[text()='Hiragana 1']")).click();
				System.out.println("select Af4up");
				Thread.sleep(100);
				//driver.findElement(By.className("IeiLn")).click();
				driver.findElement(By.xpath("//button[text()='Start']")).click();
				System.out.println("select IeiLn");
				Thread.sleep(100);
				//driver.findElement(By.className("_1cw2r")).click();			
				
			}
			/*if(driver.getCurrentUrl().equals("https://www.duolingo.com/skill/ja/Hiragana-1/practice")) {
				//driver.findElement(By.xpath("//button[text()='Start practice']")).click();
				System.out.println("select _1cw2r");
			}else {*/
				///SelectHiragana1();
			//}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void WriteJapanese() {
		String x = driver.findElement(By.className("_38VWB")).getText();
		x = x.replace("\n", "").replace("\r", "");
		System.out.println(x);	
		switch(x) {
		case "Three":
			System.out.println("THREE!");
			driver.findElement(By.xpath("//button[text()='さん']")).click();			
		break;
		case "One":
			System.out.println("ONE!");
			driver.findElement(By.xpath("//button[text()='いち']")).click();				
		break;
		case "Goodmorning":
			System.out.println("GOOD MORNING");
			driver.findElement(By.xpath("//button[text()='おはよう']")).click();				
		break;
		case "Six":
			System.out.println("SIX");
			driver.findElement(By.xpath("//button[text()='ろく']")).click();					
		break;
		case "Seven":
			System.out.println("SEVEN");
			driver.findElement(By.xpath("//button[text()='なな']")).click();					
		break;
		case "White":
			System.out.println("WHITE");
			driver.findElement(By.xpath("//button[text()='しろ']")).click();				
		break;
		case "Four":
			System.out.println("FOUR");
			driver.findElement(By.xpath("//button[text()='よん']")).click();					
		break;
		case "Yes":
			System.out.println("YES");
			driver.findElement(By.xpath("//button[text()='はい']")).click();					
		break;
		case "Red":
			System.out.println("RED");
			driver.findElement(By.xpath("//button[text()='あか']")).click();					
		break;
		case "Blue":
			System.out.println("BLUE");
			driver.findElement(By.xpath("//button[text()='あお']")).click();					
		break;
		
		
		}
		driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
		driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
		
	}
	public void WriteEnglish() {

			//driver =  new ChromeDriver();
			String x = driver.findElement(By.className("_38VWB")).getText();
			x = x.replace("\n", "").replace("\r", "");
			System.out.println(x);		
			
			boolean test = x.equals("さん");
			System.out.println(test);
			boolean test1 = x.equals("いち");
			System.out.println(test1);
			boolean test2 = x.equals("おはよう");
			System.out.println(test2);
			switch(x) {
				case "さん":
					System.out.println("THREE!");
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("3");
					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='Three']")).click();					
					}
					
				break;
				case "いち":
					System.out.println("ONE!");
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("１");
					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='One']")).click();					
					}
					
				break;
				case "おはよう":
					System.out.println("GOOD MORNING");					
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("good morning");	
					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='Good']")).click();		
						driver.findElement(By.xpath( "//button[text()='morning']")).click();	
					}
				break;
				case "ろく":
					System.out.println("SIX");
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("６");

					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='Six']")).click();					
					}
				break;
				case "なな":
					System.out.println("SEVEN");
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("7");

					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='Seven']")).click();					
					}
				break;
				case "しろ":
					System.out.println("WHITE");					
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("white");

					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='White']")).click();					
					}
				break;
				case "よん":
					System.out.println("FOUR");			
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("4");

					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='Four']")).click();					
					}
				break;
				case "あか":
					System.out.println("RED");
					
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("red");

					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='Red']")).click();					
					}
				break;
				case "あお":
					System.out.println("BLUE");
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("blue");	
					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='Blue']")).click();					
					}
				break;
				case "はい":
					System.out.println("YES");
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("yes");		
					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='Yes']")).click();					
					}
								
				break;
				case "に":
					System.out.println("TWO");	
					try {									
						driver.findElement(By.tagName("textarea")).sendKeys("2");	
					}catch(Exception e) {
						driver.findElement(By.xpath( "//button[text()='Two']")).click();
					}
				break;                                     			
			}
			driver.findElement(By.className("_1cw2r")).click();
			System.out.println("Click");
			driver.findElement(By.className("_1cw2r")).click();
			System.out.println("Click");
	
		
	}
	
	public void SelectCorrect() {
		//Select Correct Characters
		
		
		String x = driver.findElement(By.className("_1Zqmf")).getText();
		x = x.replace("\n", "").replace("\r", "");
		System.out.println(x);	
		
		switch(x) {
		case "Select the correct character(s) for “chi”":
			System.out.println("SELECTED: Select the correct character(s) for “chi”!");
			driver.findElement(By.xpath( "//span[text()='ち']")).click();
			System.out.println("CLICKED ち");
			
		break;
		case "Select the correct character(s) for “sa”":
			System.out.println("Select the correct character(s) for “sa”");
			driver.findElement(By.xpath("//span[text()='さ']")).click();
			System.out.println("CLICKED さ");

		break;
		case "Select the correct character(s) for “n”":
			System.out.println("Select the correct character(s) for “n”");
			driver.findElement(By.xpath("//span[text()='ん']")).click();
			System.out.println("CLICKED ん");
		
		break;
		case "Select the correct character(s) for “ni”":
			System.out.println("Select the correct character(s) for “ni”");
			driver.findElement(By.xpath("//span[text()='に']")).click();
			System.out.println("CLICKED に");
		break;
		case "Select the correct character(s) for “i”":
			System.out.println("Select the correct character(s) for “i”");
			driver.findElement(By.xpath( "//span[text()='い']")).click();
			System.out.println("CLICKED い");	
		break;
		case "Select the correct character(s) for “yo”":
			System.out.println("Select the correct character(s) for “yo”");
			driver.findElement(By.xpath( "//span[text()='よ']")).click();
			System.out.println("CLICKED よ");	
		break;
		case "Select the correct character(s) for “ha”":
			System.out.println("Select the correct character(s) for “ha”");
			driver.findElement(By.xpath( "//span[text()='は']")).click();
			System.out.println("CLICKED は");	
		break;
		case "Select the correct character(s) for “o”":
			System.out.println("Select the correct character(s) for “o”");
			driver.findElement(By.xpath( "//span[text()='お']")).click();
			System.out.println("CLICKED お");	
		break;
		case "Select the correct character(s) for “u”":
			System.out.println("Select the correct character(s) for “u”");
			driver.findElement(By.xpath( "//span[text()='う']")).click();
			System.out.println("CLICKED う");	
		break;
		case "Select the correct character(s) for “na”":
			System.out.println("Select the correct character(s) for “na”");
			driver.findElement(By.xpath( "//span[text()='な']")).click();
			System.out.println("CLICKED な");	
		break;
		case "Select the correct character(s) for “ku”":
			System.out.println("Select the correct character(s) for “ku”");
			driver.findElement(By.xpath( "//span[text()='く']")).click();
			System.out.println("CLICKED く");	
		break;
		case "Select the correct character(s) for “ro”":
			System.out.println("Select the correct character(s) for “ro”");
			driver.findElement(By.xpath( "//span[text()='ろ']")).click();
			System.out.println("CLICKED ろ");	
		break;
		case "Select the correct character(s) for “ka”":
			System.out.println("Select the correct character(s) for “ka”");
			driver.findElement(By.xpath( "//span[text()='か']")).click();
			System.out.println("CLICKED か");	
		break;
		case "Select the correct character(s) for “a”":
			System.out.println("Select the correct character(s) for “a”");
			driver.findElement(By.xpath( "//span[text()='あ']")).click();
			System.out.println("CLICKED あ");	
		break;
		case "Select the correct character(s) for “shi”":
			System.out.println("Select the correct character(s) for “shi”");
			driver.findElement(By.xpath( "//span[text()='し']")).click();
			System.out.println("CLICKED し");	
		break;
	
	
		}
		driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
		driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
		
	}
	
	public void WhatSound() {
		String x = driver.findElement(By.className("_98_-")).getText();
		x = x.replace("\n", "").replace("\r", "");
		System.out.println(x);	
		switch(x) {
		case "ち":
			System.out.println("Found Sound: chi");
			driver.findElement(By.xpath("//label[text()='chi']")).click();
			System.out.println("CLICKED chi");			
			break;
		case "に":
			System.out.println("Found Sound: ni");
			driver.findElement(By.xpath("//label[text()='ni']")).click();
			System.out.println("CLICKED ni");
			break;
		case "い":
			driver.findElement(By.xpath("//label[text()='i']")).click();
			System.out.println("Found Sound: i");
			System.out.println("CLICKED i");
			break;
		case "ん":
			driver.findElement(By.xpath("//label[text()='n']")).click();
			System.out.println("Found Sound: n");
			System.out.println("CLICKED n");			
			break;
		case "よ":
			driver.findElement(By.xpath("//label[text()='yo']")).click();
			System.out.println("Found Sound: yo");
			System.out.println("CLICKED yo");			
			break;
		case "さ":
			driver.findElement(By.xpath("//label[text()='sa']")).click();
			System.out.println("Found Sound: sa");
			System.out.println("CLICKED sa");			
			break;
		case "ろ":
			driver.findElement(By.xpath("//label[text()='ro']")).click();
			System.out.println("Found Sound: ro");
			System.out.println("CLICKED ro");			
			break;
		case "く":
			driver.findElement(By.xpath("//label[text()='ku']")).click();
			System.out.println("Found Sound: ku");
			System.out.println("CLICKED ku");			
			break;
		case "は":
			driver.findElement(By.xpath("//label[text()='ha']")).click();
			System.out.println("Found Sound: ha");
			System.out.println("CLICKED ha");			
			break;
		case "お":
			driver.findElement(By.xpath("//label[text()='o']")).click();
			System.out.println("Found Sound: o");
			System.out.println("CLICKED o");			
			break;
		case "う":
			driver.findElement(By.xpath("//label[text()='u']")).click();
			System.out.println("Found Sound: u");
			System.out.println("CLICKED u");			
			break;
		case "な":
			driver.findElement(By.xpath("//label[text()='na']")).click();
			System.out.println("Found Sound: na");
			System.out.println("CLICKED na");			
			break;
		case "あ":
			driver.findElement(By.xpath("//label[text()='a']")).click();
			System.out.println("Found Sound: a");
			System.out.println("CLICKED a");			
			break;
		case "か":
			driver.findElement(By.xpath("//label[text()='ka']")).click();
			System.out.println("Found Sound: ka");
			System.out.println("CLICKED ka");			
			break;
		case "し":
			driver.findElement(By.xpath("//label[text()='shi']")).click();
			System.out.println("Found Sound: shi");
			System.out.println("CLICKED shi");			
			break;
	
		}
		driver.findElement(By.xpath("//button[text()='Check']")).click();
		//driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		//driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
		
	}
	
	public void MatchThe() {
		System.out.println("SIZE of MATCH: " + driver.findElements(By.className("iNLw3")).size());
		for(int i = 0; i < driver.findElements(By.className("iNLw3")).size(); i++) {
			String x = driver.findElements(By.className("iNLw3")).get(i).getText();
			x = x.replace("\n", "").replace("\r", "");
			System.out.println("Card: " + x);
			
			switch(x) {
			
			case "ni":
				System.out.println("Match: ni");
				//driver.findElement(By.name("ni")).click();
				driver.findElement(By.xpath("//button[text()='ni']")).click();
				driver.findElement(By.xpath("//span[text()='に']")).click();
				
				break;
			case "i":
				System.out.println("Foud i");
				driver.findElement(By.xpath("//button[text()='i']")).click();
				driver.findElement(By.xpath("//span[text()='い']")).click();
				//driver.findElement(By.name("i")).click();
				//driver.findElement(By.name("い")).click();
				break;
			case "chi":
				System.out.println("Foud chi");
				driver.findElement(By.xpath("//button[text()='chi']")).click();
				driver.findElement(By.xpath("//span[text()='ち']")).click();
				//driver.findElement(By.name("chi")).click();
				//driver.findElement(By.name("ち")).click();
				break;
			case"に":
				System.out.println("Foud に");
				driver.findElement(By.xpath("//span[text()='に']")).click();
				driver.findElement(By.xpath("//button[text()='ni']")).click();
				//driver.findElement(By.name("に")).click();
				//driver.findElement(By.name("ni")).click();
				break;
			case"い":
				System.out.println("Foud い");
				driver.findElement(By.xpath("//span[text()='い']")).click();
				driver.findElement(By.xpath("//button[text()='i']")).click();
				//driver.findElement(By.name("い")).click();
				//driver.findElement(By.name("i")).click();
				break;
			case"ち":
				System.out.println("Foud ち");
				driver.findElement(By.xpath("//span[text()='ち']")).click();
				driver.findElement(By.xpath("//button[text()='chi']")).click();
				//driver.findElement(By.name("ち")).click();
				//driver.findElement(By.name("chi")).click();
				break;
				
				
				
				
			case "n":
				System.out.println("Foud n");
				driver.findElement(By.xpath("//button[text()='n']")).click();
				driver.findElement(By.xpath("//span[text()='ん']")).click();
				//driver.findElement(By.name("n")).click();
				//driver.findElement(By.name("ん")).click();
				break;
			case "sa":
				System.out.println("Foud sa");
				driver.findElement(By.xpath("//button[text()='sa']")).click();
				driver.findElement(By.xpath("//span[text()='さ']")).click();
				//driver.findElement(By.name("sa")).click();
				//driver.findElement(By.name("さ")).click();
				break;
			case"よ":
				System.out.println("Foud よ");
				driver.findElement(By.xpath("//span[text()='よ']")).click();
				driver.findElement(By.xpath("//button[text()='yo']")).click();
				//driver.findElement(By.name("よ")).click();
				//driver.findElement(By.name("yo")).click();
				break;
			case "ん":
				System.out.println("Foud ん");
				driver.findElement(By.xpath("//span[text()='ん']")).click();
				driver.findElement(By.xpath("//button[text()='n']")).click();
				//driver.findElement(By.name("ん")).click();
				//driver.findElement(By.name("n")).click();
				break;
			case"さ":
				System.out.println("Foud さ");
				driver.findElement(By.xpath("//span[text()='さ']")).click();
				driver.findElement(By.xpath("//button[text()='sa']")).click();
				//driver.findElement(By.name("さ")).click();			
				//driver.findElement(By.name("i")).click();
				break;
			case"yo":
				System.out.println("Foud yo");
				driver.findElement(By.xpath("//button[text()='yo']")).click();
				driver.findElement(By.xpath("//span[text()='よ']")).click();
				//driver.findElement(By.name("yo")).click();
				//driver.findElement(By.name("よ")).click();
				break;
			case"o":
				System.out.println("Foud o");
				driver.findElement(By.xpath("//button[text()='o']")).click();
				driver.findElement(By.xpath("//span[text()='お']")).click();
				break;
			case"お":
				System.out.println("Foud お");
				driver.findElement(By.xpath("//span[text()='お']")).click();
				driver.findElement(By.xpath("//button[text()='o']")).click();
				break;
			case"ha":
				System.out.println("Foud ha");
				driver.findElement(By.xpath("//button[text()='ha']")).click();
				driver.findElement(By.xpath("//span[text()='は']")).click();
				break;
			case"は":
				System.out.println("Foud は");
				driver.findElement(By.xpath("//span[text()='は']")).click();
				driver.findElement(By.xpath("//button[text()='ha']")).click();
				break;
			case"u":
				System.out.println("Foud u");
				driver.findElement(By.xpath("//button[text()='u']")).click();
				driver.findElement(By.xpath("//span[text()='う']")).click();
				break;
			case"う":
				System.out.println("Foud う");
				driver.findElement(By.xpath("//span[text()='う']")).click();
				driver.findElement(By.xpath("//button[text()='u']")).click();
				break;
				
			case"ro":
				System.out.println("Foud ro");
				driver.findElement(By.xpath("//button[text()='ro']")).click();
				driver.findElement(By.xpath("//span[text()='ろ']")).click();
				break;
			case"ろ":
				System.out.println("Foud ろ");
				driver.findElement(By.xpath("//span[text()='ろ']")).click();
				driver.findElement(By.xpath("//button[text()='ro']")).click();
				break;
			case"na":
				System.out.println("Foud na");
				driver.findElement(By.xpath("//button[text()='na']")).click();
				driver.findElement(By.xpath("//span[text()='な']")).click();
				break;
			case"な":
				System.out.println("Foud な");
				driver.findElement(By.xpath("//span[text()='な']")).click();
				driver.findElement(By.xpath("//button[text()='na']")).click();
				break;
			case"ku":
				System.out.println("Foud ku");
				driver.findElement(By.xpath("//button[text()='ku']")).click();
				driver.findElement(By.xpath("//span[text()='く']")).click();
				break;
			case"く":
				System.out.println("Foud く");
				driver.findElement(By.xpath("//span[text()='く']")).click();
				driver.findElement(By.xpath("//button[text()='ku']")).click();
				break;
			case"a":
				System.out.println("Foud a");
				driver.findElement(By.xpath("//button[text()='a']")).click();
				driver.findElement(By.xpath("//span[text()='あ']")).click();
				break;
			case"あ":
				System.out.println("Foud あ");
				driver.findElement(By.xpath("//span[text()='あ']")).click();
				driver.findElement(By.xpath("//button[text()='a']")).click();
				break;
			case"shi":
				System.out.println("Foud shi");
				driver.findElement(By.xpath("//button[text()='shi']")).click();
				driver.findElement(By.xpath("//span[text()='し']")).click();
				break;
			case"し":
				System.out.println("Foud し");
				driver.findElement(By.xpath("//span[text()='し']")).click();
				driver.findElement(By.xpath("//button[text()='shi']")).click();
				break;
			case"ka":
				System.out.println("Foud ka");
				driver.findElement(By.xpath("//button[text()='ka']")).click();
				driver.findElement(By.xpath("//span[text()='か']")).click();
				break;
			case"か":
				System.out.println("Foud か");
				driver.findElement(By.xpath("//span[text()='か']")).click();
				driver.findElement(By.xpath("//button[text()='ka']")).click();
				break;
				
				
			default:
					break;
			
			}
			
		}
		try {
			Thread.sleep(100);		
		driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
		driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void MarkMeaning() {
		String x = driver.findElement(By.className("KRKEd")).getText();
		x = x.replace("\n", "").replace("\r", "");
		System.out.println(x);	
		switch(x) {
		case "Yes":
			System.out.println("YES!");
			driver.findElement(By.xpath("//div[text()='はい']")).click();			
		break;
		case "White":
			System.out.println("WHITE!");
			driver.findElement(By.xpath("//div[text()='しろ']")).click();			
		break;
		case "Red":
			System.out.println("RED!");
			driver.findElement(By.xpath("//div[text()='あか']")).click();			
		break;
		case "Blue":
			System.out.println("BLUE!");
			driver.findElement(By.xpath("//div[text()='あお']")).click();			
		break;
		case "Seven":
			System.out.println("SEVEN!");
			driver.findElement(By.xpath("//div[text()='なな']")).click();			
		break;
		case "Six":
			System.out.println("SIX!");
			driver.findElement(By.xpath("//div[text()='ろく']")).click();			
		break;
		case "Three":
			System.out.println("THREE!");
			driver.findElement(By.xpath("//div[text()='さん']")).click();			
		break;
		case "Two":
			System.out.println("TWO!");
			driver.findElement(By.xpath("//div[text()='に']")).click();			
		break;
		case "One":
			System.out.println("ONE!");
			driver.findElement(By.xpath("//div[text()='いち']")).click();			
		break;
		case "Four":
			System.out.println("FOUR!");
			driver.findElement(By.xpath("//div[text()='よん']")).click();			
		break;
		case "Good morning":
			System.out.println("GOODMORNING!");
			driver.findElement(By.xpath("//div[text()='おはよう']")).click();			
		break;
		}
		driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
		driver.findElement(By.className("_1cw2r")).click();
		System.out.println("Click");
	}
	
	public void AnswerHiragana1() {
		
		SeleniumMainFile myObj = new SeleniumMainFile();	
		//System.out.println(driver.findElement(By.className("_38VWB")).getText());
		for(int i = 0; i < 20; i++) {
			System.out.println("Problem: " + i);
			try {				
				System.out.println("Waiting... ");
				Thread.sleep(1000);
				System.out.println("Next: ");
				//System.out.println(driver.findElement(By.className("_38VWB")));
				//System.out.println("Driver: " + driver.findElements(By.className("_38VWB")).isEmpty());
				
				
				String header = driver.findElement(By.className("_1Zqmf")).getText();
				header = header.replace("\n", "").replace("\r", "");
				StringBuilder firstTen = new StringBuilder(header);
				//String stringTwenty;
				String stringTen;
				if(header.equals("Match the pairs") || header.equals("Tap what you hear")) {
					System.out.println(firstTen.substring(0, 10));
					stringTen = firstTen.substring(0, 10);
				}else {
					System.out.println(firstTen.substring(0, 20));
					stringTen = firstTen.substring(0, 20);
				}
				
				boolean equalizer = stringTen.equals("Write this");
				System.out.println(equalizer);
				
				if(stringTen.equals("Write this in Englis")) {
					System.out.println("Write this in Englis: ");
					myObj.WriteEnglish();
					
				}else if(stringTen.equals("Select the correct c")) {
					System.out.println("Select the correct c: ");
					myObj.SelectCorrect();
				}else if(stringTen.equals("Match the ")) {
					System.out.println("Match the: ");
					myObj.MatchThe();
				}else if(stringTen.equals("What sound does this")) {
					System.out.println("What sound does this: ");
					myObj.WhatSound();
				}else if(stringTen.equals("Tap what y")) {
					System.out.println("Tap what y");					
					driver.findElement(By.className("_18F7l")).click();
					//driver.findElement(By.xpath("//button[data-test()='player-skip']")).click();
					driver.findElement(By.xpath("//button[text()='Continue']")).click();
				}else if(stringTen.equals("Write this in Japane")) {
					System.out.println("Write this in Japane:");
					myObj.WriteJapanese();				
				}else if(stringTen.equals("Mark the correct mea")) {
					System.out.println("Mark the correct mea: ");
					myObj.MarkMeaning();
				}else {
					break;
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		 
		}
		//Should be done and continue
		
		try {
			//System.out.println("CONTINUE!?? ");
			driver.findElement(By.xpath("//button[text()='Continue']")).click();
			System.out.println("Continued: ");
		
			//System.out.println(driver.findElements(By.xpath("//button[text()='No thanks']")).size());
			/*if(driver.findElement(By.xpath("//button[text()='No thanks']")) != null) {
				System.out.println("Sleeping... ");
				Thread.sleep(300);	
				System.out.println("Awake! ");*/
			if(!driver.getCurrentUrl().equals("https://www.duolingo.com/")) {
				try {
					System.out.println("Sleeping... ");
					Thread.sleep(300);	
					System.out.println("Awake! ");
					driver.findElement(By.xpath("//button[text()='No thanks']")).click();
					System.out.println("No Thanks ");
				}catch(Exception e) {
					System.out.println("No Thanks Button.. ");
					//driver.findElement(By.className("f9Jv-")).click();
					//driver.findElement(By.xpath("//button[text()='No thanks']")).click();
					
				}
			}
			if(!driver.getCurrentUrl().equals("https://www.duolingo.com/")) {
					//f(driver.findElements(By.xpath("//button[text()='Continue']"))) {
					try {
						driver.findElement(By.xpath("//button[text()='Continue']")).click();
					}catch(Exception e) {
						System.out.println("No Continue Button.. ");
					}
					//}
					System.out.println("Moving On: ");
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void MainExecution() {
		SeleniumMainFile myObj = new SeleniumMainFile();
		//Open Driver
		myObj.invokeBrowser();
		//LogOn to Duolingo
		myObj.LogOnDuolingo();
		for(int i = 0 ; i < 100 ; i++) {	
			try {
				Thread.sleep(30);
				System.out.println("Select Hiragana 1: " + i);
				//Execute Hiragana1
				myObj.SelectHiragana1();
				//Answer Questions for Hiragana1
				myObj.AnswerHiragana1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		System.out.println("ALL DONE!!!!");
		myObj.stop();
	}
	
	public synchronized static void main(String[] args) {
			SeleniumMainFile myObj = new SeleniumMainFile();
			//SeleniumMainFile myObj1 = new SeleniumMainFile();

			//myObj.clone();
			myObj.start();
			//myObj1.start();
		}

}
