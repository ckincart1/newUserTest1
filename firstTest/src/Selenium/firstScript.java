package Selenium;
// import required jars
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert; // attempted alert for market permissions pop up (Stocks), received 
								  // noAlertPresentException
import org.openqa.selenium.By;
//screenshot functionality: TakesScreenshot, OutputType, File
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.util.List;
// import for select dropdowns
import org.openqa.selenium.support.ui.Select;


// import for explicit waits
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// define class, driver
public class firstScript {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		
// Login to application
	
		String testBaseURL = "https://ndcdyn.interactivebrokers.com/sso/Login?c=t";
		
		driver.get(testBaseURL);
// Maximize browser
		driver.manage().window().maximize();
		
// Create wait for page load
		WebDriverWait usernameWait = new WebDriverWait(driver,10);
		usernameWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
//		
// Find and enter username
		WebElement username = driver.findElement(By.id("user_name"));
		username.sendKeys("user06151");
		// alternate method to use in one line
		// driver.findElement(By.id("user_name")).sendKeys("user06151");
				
// Find and enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("tester12");
		// alternate method to use in one line
		// driver.findElement(By.id("password")).sendKeys("tester12");
		
// Submit page
		driver.findElement(By.name("button")).click();

/* 
Section 1 - Personal Information (Page 1 after login)
Task
1) Enter the shown Date of Birth
*/
		/* to test page two, commenting out Section 1 code
// Create wait for page load
	
		WebDriverWait dateWait = new WebDriverWait(driver,10);
		dateWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date")));
						
	//  CLEAR ALL TEXT BOX VALUES
		dateOfBirth.clear();
		firstName.clear();
		lastName.clear();
		addressLineOne.clear();
		city.clear();
		zipCode.clear();
		phoneNumber.clear();
		ssn.clear();
		securityQuestionOneAnswer.clear();
		securityQuestionTwoAnswer.clear();
		securityQuestionThreeAnswer.clear();
		
// Find and enter DateOfBirth
		WebElement dateOfBirth = driver.findElement(By.id("date"));
		dateOfBirth.sendKeys("1980-08-30");
		System.out.println("Successfully filled in birthdate");
	
// 2) Print all the categories under Source of Wealth
		
		List<WebElement> sourcesOfWealth = driver.findElements(By.cssSelector("div.source-of-wealth p"));
		// List<WebElement> pTags = sourcesOfWealth.findElements(By.tagName("p"))	;
		System.out.println("Source of Wealth Categories:");
		
		
		for (int i=1; i<sourcesOfWealth.size();i++){
			System.out.println(sourcesOfWealth.get(i).getText());
					//getAttribute(""));
		};
		
		// Check source of wealth boxes
		List<WebElement> sourcesOfWealthCheckboxes = driver.findElements(By.cssSelector("div.source-of-wealth ins.iCheck-helper"));
		sourcesOfWealthCheckboxes.get(0).click();
		// for some reason, only doing .get(0) allows (0) and (5) to appear. Running below (1,3,4) will make 5 disappear.
		/*
		sourcesOfWealthCheckboxes.get(1).click();
		sourcesOfWealthCheckboxes.get(3).click();
		sourcesOfWealthCheckboxes.get(4).click();
		sourcesOfWealthCheckboxes.get(5).click();
		sourcesOfWealthCheckboxes.get(6).click();
		sourcesOfWealthCheckboxes.get(7).click();
		*/
						/* commenting out to test Section 2
		System.out.println(sourcesOfWealthCheckboxes.get(5).isSelected());

// 3) Check the option "Market Trading Profits" (above)

// Fill rest of form

	//	Salutation	
		WebElement salutationDD = driver.findElement(By.id("salutation"));
	    Select salutation = new Select(salutationDD);
	    salutation.selectByVisibleText("Mr.");
	
	//  First Name
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Test");
		System.out.println("Successfully filled in First Name");		
		
	//  Last Name
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Tester");
		System.out.println("Successfully filled in Last Name");
		
	//  Address Line One
		WebElement addressLineOne = driver.findElement(By.id("street1Main"));
		addressLineOne.sendKeys("1 Test Road");
		System.out.println("Successfully filled in Address Line One");
		
	//  City
		WebElement city = driver.findElement(By.id("cityMain"));
		city.sendKeys("Port Chester");
		System.out.println("Successfully filled in City");
		
	//  Zip Code
		WebElement zipCode = driver.findElement(By.id("postalCodeMain"));
		zipCode.sendKeys("10573");
		System.out.println("Successfully filled in Zip/Postal Code");
		
	//  Phone Number
		WebElement phoneNumber = driver.findElement(By.id("number1"));
		phoneNumber.sendKeys("9145526341");
		System.out.println("Successfully filled in Phone Number");
		
	//  Social Security Number
		WebElement ssn = driver.findElement(By.id("taxResidency1Number"));
		ssn.sendKeys("111223333");
		System.out.println("Successfully filled in Social Security Number");
		
	//  Employment Status - Homemaker
		WebElement employmentStatusDD = driver.findElement(By.id("employmentType"));
	    Select employmentStatus = new Select(employmentStatusDD);
	    employmentStatus.selectByVisibleText("Homemaker");
		
	//	Employment Status - Employed
		/*
		WebElement employmentStatusDD = driver.findElement(By.id("employmentType"));
	    Select employmentStatus = new Select(employmentStatusDD);
	    employmentStatus.selectByVisibleText("Employed");
	   
		
	//  Full Employer Name
		WebElement employerName = driver.findElement(By.id("employerName"));
		employerName.sendKeys("IB");
		System.out.println("Successfully filled in Full Employer Name");
		
	//  Nature of Business
		
	//	List<WebElement> natureOfBusinessDD = driver.findElements(By.cssSelector("div.source-of-wealth ins.iCheck-helper"));
	//	sourcesOfWealthCheckboxes.get(0).click();
	//	WebElement natureOfBusinessDD = driver.findElement(By.id("natureOfBusinessFreeFormContainer"));
	//    Select natureOfBusiness = new Select(natureOfBusinessDD);
	 //   natureOfBusiness.selectByVisibleText("Computer/Information Technology");
	    
	//  Occupation
	
	//  Country
		
	//  Employment Address
		WebElement employmentAddress = driver.findElement(By.id("street1Employment"));
		employmentAddress.sendKeys("2 Test Lane");
		System.out.println("Successfully filled in Employment Address");
		
	//  Employment City
		WebElement employmentCity = driver.findElement(By.id("cityEmployment"));
		employmentCity.sendKeys("Greenwich");
		System.out.println("Successfully filled in Employment City");
		
	//  Employment State - cannot be done until employment country is filled
		WebElement employmentStateDD = driver.findElement(By.id("stateEmployment"));
	    Select employmentState = new Select(salutationDD);
	    salutation.selectByVisibleText("Mr.");
		
	//  Employment Zip/Postal Code
		WebElement employmentZipCode= driver.findElement(By.id("postalCodeEmployment"));
		employmentZipCode.sendKeys("06830");
		System.out.println("Successfully filled in Employment Zip/Postal Code");
		 */
	    		/* commenting out to test Section 2
//		Security Question One
			WebElement securityQuestionOneDD = driver.findElement(By.id("question0"));
		    Select securityQuestionOne = new Select(securityQuestionOneDD);
		    securityQuestionOne.selectByIndex(1);
		    System.out.println("Successfully filled in Security Question One Prompt");
		    
		//  Security Question One Answer
			WebElement securityQuestionOneAnswer = driver.findElement(By.id("answer0"));
			securityQuestionOneAnswer.sendKeys("test1");
			System.out.println("Successfully filled in Security Question One Answer");
		    
		//	Security Question Two
			WebElement securityQuestionTwoDD = driver.findElement(By.id("question1"));
		    Select securityQuestionTwo = new Select(securityQuestionTwoDD);
		    securityQuestionTwo.selectByIndex(2);
		    System.out.println("Successfully filled in Security Question Two Prompt");
		    
		//  Security Question Two Answer
			WebElement securityQuestionTwoAnswer = driver.findElement(By.id("answer1"));
			securityQuestionTwoAnswer.sendKeys("test2");
			System.out.println("Successfully filled in Security Question Two Answer");
		    
		//	Security Question Three
			WebElement securityQuestionThreeDD = driver.findElement(By.id("question2"));
		    Select securityQuestionThree = new Select(securityQuestionThreeDD);
		    securityQuestionThree.selectByIndex(3);
		    System.out.println("Successfully filled in Security Question Three Prompt");
		    
		//  Security Question Three Answer
			WebElement securityQuestionThreeAnswer = driver.findElement(By.id("answer2"));
			securityQuestionThreeAnswer.sendKeys("test3");
			System.out.println("Successfully filled in Security Question Three Answer");
		        
	    
	/* original security code	
	//	Security Question One
		WebElement securityQuestionOneDD = driver.findElement(By.id("question0"));
	    Select securityQuestionOne = new Select(securityQuestionOneDD);
	    securityQuestionOne.selectByVisibleText("In what city were you married?");
	    System.out.println("Successfully filled in Security Question One Prompt");
	    
	//  Security Question One Answer
		WebElement securityQuestionOneAnswer = driver.findElement(By.id("answer0"));
		securityQuestionOneAnswer.sendKeys("NY");
		System.out.println("Successfully filled in Security Question One Answer");
	    
	//	Security Question Two
		WebElement securityQuestionTwoDD = driver.findElement(By.id("question1"));
	    Select securityQuestionTwo = new Select(securityQuestionTwoDD);
	    securityQuestionTwo.selectByVisibleText("What is the name of your favorite sports team?");
	    System.out.println("Successfully filled in Security Question Two Prompt");
	    
	//  Security Question Two Answer
		WebElement securityQuestionTwoAnswer = driver.findElement(By.id("answer1"));
		securityQuestionTwoAnswer.sendKeys("NY Yankees");
		System.out.println("Successfully filled in Security Question Two Answer");
	    
	//	Security Question Three
		WebElement securityQuestionThreeDD = driver.findElement(By.id("question2"));
	    Select securityQuestionThree = new Select(securityQuestionThreeDD);
	    securityQuestionThree.selectByVisibleText("What is your favorite place to shop?");
	    System.out.println("Successfully filled in Security Question Three Prompt");
	    
	//  Security Question Three Answer
		WebElement securityQuestionThreeAnswer = driver.findElement(By.id("answer2"));
		securityQuestionThreeAnswer.sendKeys("Amazon");
		System.out.println("Successfully filled in Security Question Three Answer");
	 */   
	    
/*
4) Press Continue
// Submit page
*/
	//	driver.findElement(By.id("continue")).click();

	
/*
Section 2 - Configure Your Trading Account (Page 2 after login)
Task

// Create wait for page load
 	
		
		WebDriverWait regulatoryPageWait = new WebDriverWait(driver,10);
		regulatoryPageWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("annualIncome")));
	/*	
		
1) Select shown values for Annual Net Income, Net Worth and Liquid Net Worth
*/
	/*
		List<WebElement> annualNetIncomeInUSDDropDown = driver.findElements(By.cssSelector("div.investmentConfig select.annualIncome"));
		annualNetIncomeInUSDDropDown.get(7).click();
		
	*/
	/*	
	
	//  Annual Net Income in USD
		WebElement annualNetIncomeInUSDDD = driver.findElement(By.xpath("//select[@name='annualIncome']"));
	    Select annualNetIncomeinUSD = new Select(annualNetIncomeInUSDDD);
	    annualNetIncomeinUSD.selectByVisibleText("200,000 - 249,999");

	//  Net Worth in USD
		WebElement NetWorthInUSDDD = driver.findElement(By.xpath("//select[@name='netWorth']"));
	    Select NetWorthInUSD = new Select(NetWorthInUSDDD);
	    NetWorthInUSD.selectByVisibleText("25,000,000 - 29,999,999");	
	    
	//  Liquid Net Worth in USD
		WebElement LiquidNetWorthInUSDDD = driver.findElement(By.xpath("//select[@name='liquidNetWorth']"));
	    Select LiquidNetWorthInUSD = new Select(LiquidNetWorthInUSDDD);
	    LiquidNetWorthInUSD.selectByVisibleText("250,000 - 499,999");
	    
	
	//  Investment Objectives and Intended Purpose of Trading
	//  
	 	List<WebElement> investmentConfigCheckboxes = driver.findElements(By.cssSelector("ins.iCheck-helper"));
	 
	 	//  Check checkbox 'growth'	
		investmentConfigCheckboxes.get(0).click();
		//  Check checkbox 'Profits from Active Trading and Speculation'
	 	investmentConfigCheckboxes.get(3).click();
	    
/*		
Section 3 - Trading Permissions and Experiences (Page 2 after login)
Task
1) Under Stocks section, Click '+ADD'
*/
	    /* - all works, commenting out for next section
	    WebElement stockButtonAdd = driver.findElement(By.xpath("//div[@ng-form='$ctrl.selectionForm_STOCK']//am-button[@btn-text='Add']"));
	    stockButtonAdd.click();
		
		// driver.findElement(By.cssSelector("am-button[button-text='add']")).click();
		// driver.findElement(By.xPath("//am-button/")).click();

// 2) Select all countries under "Locations you wish to Trade" on the popup
		
		List<WebElement> marketPermissionsStockCheckboxes = driver.findElements(By.xpath("//div[@class='tp-locations']//ins[@class='iCheck-helper']"));
		marketPermissionsStockCheckboxes.get(0).click();		
		marketPermissionsStockCheckboxes.get(5).click();
		marketPermissionsStockCheckboxes.get(20).click();

	//  Select 'Save' on Pop Up "Locations you wish to Trade" Window
		
	    // pop up save originally not clicking, so testing a Wait before pressing 'Save':
		WebDriverWait popUpLocationSaveWait = new WebDriverWait(driver,10);
		popUpLocationSaveWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='amModalFooter']//am-button[@btn-text='Save']")));
		WebElement popUpLocationsSaveButton = driver.findElement(By.xpath("//div[@id='amModalFooter']//am-button[@btn-text='Save']"));
		// popUpLocationsSaveButton.isEnabled();
		popUpLocationsSaveButton.click();
		
		
		/*	

3) Save and Continue
	
		// set wait for final save button
		WebDriverWait configureYourTradingAccountSaveWait = new WebDriverWait(driver,10);
		configureYourTradingAccountSaveWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
	 	driver.findElement(By.id("continue")).click();
/*


// Note - Confirm Your Tax Residence (Page 4 after login)
*/
		
	// 	System.out.println("Confirm Your Tax Residence page has signature text, manually entered Signature and Continue button in web UI per instructions");
/*
Section 4 - General Agreements & Disclosures 
Task
1) Make Sure agreement "Day Trading Risk Disclosure Statement" is present
*/
		/* Section works, commenting for next section
		WebDriverWait dayTradingRiskDisclosureStatementWait = new WebDriverWait(driver,10);
		dayTradingRiskDisclosureStatementWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='agreement_choice_3071_div']//button[@id='agreement_choice_3071_positive']")));
	 	WebElement dayTradingRiskDisclosureStatementButton = driver.findElement(By.xpath("//div[@id='agreement_choice_3071_div']//button[@id='agreement_choice_3071_positive']"));
	 	dayTradingRiskDisclosureStatementButton.isSelected();
	 	
	 	if (dayTradingRiskDisclosureStatementButton.isSelected());{
	 		System.out.println("Day Trading Risk Disclosure Statement is selected");

	 		}

	 	
//2) Save and Continue
		WebDriverWait agreementsAndDisclosuresSubmitWait = new WebDriverWait(driver,5);
		agreementsAndDisclosuresSubmitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
		driver.findElement(By.id("continue")).isDisplayed();
		driver.findElement(By.id("continue")).click();
		
		System.out.println("Manually entered Signature field per instructions");
		
		// if needed for testing, clear signature field with:
		// WebElement clearAgreementsSignature = driver.findElement(By.id("signatures0"));
		// clearAgreementsSignature.clear();
/*
Section 5 - Integrated Investment Management Account Features (Page 5 after login)
Task
1) Click on Continue button
*/
		/*
		WebDriverWait integratedInvestmentManagementAccountFeatures = new WebDriverWait(driver,10);
		integratedInvestmentManagementAccountFeatures.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
		driver.findElement(By.id("continue")).click();
		*/
//Section 6 - Application Review (Page 6 after login) - complete, commenting out
//Task
		/*
		WebDriverWait appReviewPageWait = new WebDriverWait(driver,10);
		appReviewPageWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accountreview']//label[@class='ng-binding']")));
//1) Verify the following values are present on the page:
//	a. Net Worth should be 25,000,000-29,999,999 USD
		WebElement reviewNetWorth = driver.findElement(By.xpath("//am-form-label[@label-text='Net Worth']//label[@class='ng-binding']"));
		System.out.println("Net Worth: " + reviewNetWorth.getText());	
				
//	b. Liquid Net Worth should be 250,000-499,999 USD
		WebElement reviewLiquidNetWorth = driver.findElement(By.xpath("//am-form-label[@label-text='Liquid Net Worth']//label[@class='ng-binding']"));
		System.out.println("Liquid Net Worth: " + reviewLiquidNetWorth.getText());
//	c. Annual Net Income should be 200,000-249,999 USD
		WebElement reviewAnnualNetIncome = driver.findElement(By.xpath("//am-form-label[@label-text='Annual Net Income']//label[@class='ng-binding']"));
		System.out.println("Annual Net Income: " + reviewAnnualNetIncome.getText());	
//	d. Investment Objectives should be Growth, Speculation
		//Issue
		System.out.println("Investment Objectives:");
//2) Click on Continue

		driver.findElement(By.id("continue")).click();
		*/
//  Section 7 - Application Status (Page 6 after login)
//  Task
//  1) Capture the highlighted application status text
	//	TakesScreenshot appStatusScreenshot = (TakesScreenshot) driver;
		

// 2) Click on "Subscribe to Market Data" at the bottom, fails
		WebDriverWait subscribeToMarketDataButtonWait = new WebDriverWait(driver,10);
		subscribeToMarketDataButtonWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("container")));
		driver.findElement(By.xpath("//section[@class='bg-blue-gray']//a[@class='btn btn-secondary']")).click();
		// button two commented out as alternative
		//WebElement subscribeToMarketDataButton = driver.findElement(By.xpath("//div[@class='col-12 col-md-4 offset-md-1 text-center']//a[@class='btn btn-secondary']"));
	//	subscribeToMarketDataButton.click();
		

//  Section 8.1 - Market Data Subscriber Status
//  Task
//  1) Select Non-Professional
		/*
		WebElement mDSubscriberStatusDD = driver.findElement(By.name("subscriberStatus"));
	    Select mDSubscriberStatus = new Select(mDSubscriberStatusDD);
	    mDSubscriberStatus.selectByVisibleText("Non-Professional");
	    */
//  Section 8.2 - Market Data Subscriber Status
//  Task
//  1) Choose "Yes" for both questions
		WebElement marketDataSubscriberQuestion1 = driver.findElement(By.xpath("//am-switch[@name='PermittedUseQuestion']//a[@ng-click='$ctrl.setModel(true)']"));
		marketDataSubscriberQuestion1.click();
		WebElement marketDataSubscriberQuestion2 = driver.findElement(By.xpath("//am-switch[@name='SubscriberNotifyQuestion']//a[@ng-click='$ctrl.setModel(true)']"));
		marketDataSubscriberQuestion2.click();
  //2) Click Continue
		driver.findElement(By.xpath("//div[@class='panel-btn-right']//a[@class='btn btn-primary']")).click();

//  Section 9 - Configure Your Market Data Subscriptions
//  Task
		WebDriverWait mDsubscriptionPageWait = new WebDriverWait(driver,10);
		mDsubscriptionPageWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("heading_TWS_NORTH_AMERICA_QUOTE_BUNDLE")));

//  1) Get the page title
		driver.getTitle();
//  2) Expand Quote Bundles under North America tab
		driver.findElement(By.id("heading_TWS_NORTH_AMERICA_QUOTE_BUNDLE")).click();
//  3) Check "US Futures Value Bundle PLUS"
		List<WebElement> northAmericaQuoteBundlesCheckboxes = driver.findElements(By.xpath("//div[@id='TWS_NORTH_AMERICA_QUOTE_BUNDLE']//ins[@class='iCheck-helper']"));
		northAmericaQuoteBundlesCheckboxes.get(2).click();	
//  4) Switch to "Europe" tab
		WebElement countryTagSwitch = driver.findElement(By.xpath("//market-data-tabs[@class='nav-lines ng-scope ng-isolate-scope']//ul[@class='nav nav-tabs nav-lines']"));
		Select switchToEurope = new Select(countryTagSwitch);
		switchToEurope.selectByIndex(2);
//  5) Expand "Indexes"
		driver.findElement(By.id("heading_TWS_EUROPE_INDEX")).click();
//  6) Check "Austrian (VSE) Equities & Index Derivatives"	
		List<WebElement> europeanCheckboxes = driver.findElements(By.xpath("//div[@id='TWS_EUROPE_INDEX']//ins[@class='iCheck-helper']"));
		europeanCheckboxes.get(0).click();
//  7) Switch to "Asia Pacific" tab
		Select switchToAsiaPacific = new Select(countryTagSwitch);
		switchToAsiaPacific.selectByIndex(5);
//  8) Expand "Level 1 (NBBO)"
		driver.findElement(By.id("heading_TWS_ASIA_PACIFIC_LEVEL_1")).click();
//  9) Check "Hong Kong Derivatives"
		List<WebElement> level1NBBOCheckboxes = driver.findElements(By.xpath("//div[@id='TWS_NORTH_AMERICA_LEVEL_1']//ins[@class='iCheck-helper']"));
		level1NBBOCheckboxes.get(1).click();	
//  10) Click Continue

		driver.findElement(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Continue']")).click();

//  Section 10 - Review Your Market Data Subscriptions
//  Task
//  1) Click Continue

		driver.findElement(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Continue']")).click();
		
		
//  Section 11 - Signature Page
//  Task
//  1) Enter the Signature (It should be the same as the name displayed on the left)
//	a. Print the full name to console and enter the name as Signature
		WebElement finalSignature = driver.findElement(By.xpath("//am-form-signature[@signature='signature']//div[@class='col-xs-12 col-sm-4 col-md-4 col-lg-4 ng-binding']"));
		System.out.println(finalSignature.getText());
		WebElement enterFinalSignature = driver.findElement(By.name("signature_0"));
		enterFinalSignature.sendKeys("Test Tester");
		
//  2) Click Continue

		driver.findElement(By.xpath("//div[@class='panel-btn-right']//am-button[@btn-text='Continue']")).click();
		
		
//  Section 12 - Finish
//  Task
//  1) Click Finish
		driver.findElement(By.id("finish")).submit();
		
//End of Test Application



	}

}
