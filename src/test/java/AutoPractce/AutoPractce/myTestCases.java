package AutoPractce.AutoPractce;

import java.awt.Desktop.Action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	WebDriver driver = new ChromeDriver();

	String theURL = "https://codenboxautomationlab.com/practice/";

	Connection con;

	Statement stmt;

	ResultSet rs;

	String CustomerFirstName;
	String CustomerLastName;
	String CustomerEmail;
	String CustomerPhone;
	String CustomerDetails;

	@BeforeTest
	public void mySetup() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "abed");

		driver.get(theURL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(enabled = false)
	public void RadioButton() {
		WebElement RadioButtonField = driver.findElement(By.xpath("//div[@id='radio-btn-example']//fieldset"));

		RadioButtonField.findElements(By.tagName("input")).get(0).click();
	}

	@Test(enabled = false)
	public void Dynamic_Dropdown_Example() throws InterruptedException {
		String[] countries = { "Jo", "sy", "ir" };

		driver.findElement(By.id("autocomplete")).sendKeys(countries[2]);
		Thread.sleep(2000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(enabled = false)
	public void select_tag() {

		WebElement selectTag = driver.findElement(By.id("dropdown-class-example"));

		Select myselect = new Select(selectTag);
		// myselect.selectByIndex(1);
		// myselect.selectByValue("option2");
		myselect.selectByVisibleText("API");

	}

	@Test(enabled = false)
	public void CheckBox() {

		WebElement CheckboxContainer = driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset"));

		List<WebElement> allInputs = CheckboxContainer.findElements(By.tagName("input"));

		for (int i = 0; i < allInputs.size(); i++) {
			allInputs.get(i).click();
		}

	}

	@Test(enabled = false)

	public void open_window() throws InterruptedException {
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(2000);

		Set<String> handels = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(handels);

		driver.switchTo().window(windowList.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//*[@id=\"menu-item-9680\"]/a/span[1]")).click();

		Thread.sleep(1000);
		driver.switchTo().window(windowList.get(0));

		WebElement RadioButtonField = driver.findElement(By.xpath("//div[@id='radio-btn-example']//fieldset"));

		RadioButtonField.findElements(By.tagName("input")).get(0).click();

	}

	@Test(enabled = false)
	public void open_tab() throws InterruptedException {

		driver.findElement(By.id("opentab")).click();

		Set<String> handels = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(handels);

		driver.switchTo().window(windowList.get(1));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"center\"]/yt-searchbox/div[1]/form/input")).sendKeys("abc" + Keys.ENTER);
	}

	@Test(enabled = false)

	public void alertAndConfirm() throws InterruptedException {
		driver.findElement(By.id("name")).sendKeys("mohammad");

		driver.findElement(By.id("alertbtn")).click();

		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		driver.findElement(By.id("name")).sendKeys("mohammad");

		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);

		// driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();

		System.out.println(driver.switchTo().alert().getText());

	}

	@Test(enabled = false)
	public void Table() {
		WebElement TheTable = driver.findElement(By.id("product"));

		List<WebElement> allRows = TheTable.findElements(By.tagName("td"));

		for (int i = 0; i < allRows.size(); i++) {
			;

			System.out.println(allRows.get(i).getText());
		}
	}

	@Test(enabled = false)
	public void hideAndShow() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,1800)");

		Thread.sleep(3000);

		driver.findElement(By.id("hide-textbox")).click();
		;
		driver.findElement(By.id("displayed-text")).isDisplayed();

		System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed());

		Thread.sleep(2000);
		driver.findElement(By.id("show-textbox")).click();
		System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed());

	}

	@Test(enabled = false)
	public void disableAndEnable() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,1800)");

		driver.findElement(By.id("disabled-button")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("enabled-button")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("enabled-example-input")).sendKeys("anas");

	}

	@Test(enabled = false)
	public void MouseHover() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,1900)");
		WebElement MouseHoverButton = driver.findElement(By.id("mousehover"));

		Actions action = new Actions(driver);

		action.moveToElement(MouseHoverButton).build().perform();
		;
		Thread.sleep(2000);
		// driver.findElement(By.linkText("Top")).click();
		driver.findElement(By.linkText("Reload")).click();

	}

	@Test(priority = 1)
	public void calender() throws InterruptedException, SQLException {

		driver.findElement(By.linkText("Booking Calendar")).click();

		Set<String> handels = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(handels);

		driver.switchTo().window(windowList.get(1));

		System.out.println(driver.getTitle());

		Thread.sleep(2000);
		WebElement TheTable = driver.findElement(By.cssSelector(".datepick.wpbc_calendar"));

		List<WebElement> tableData = TheTable.findElements(By.tagName("td"));

		for (int i = 0; i < tableData.size(); i++) {
			;

//			System.out.println(tableData.get(i).getText());
		}
		TheTable.findElement(By.linkText("24")).click();

	}

	@Test(priority = 2)
	public void calenderAdd() throws InterruptedException, SQLException {

		Thread.sleep(4000);
		String QueryToAdd = "INSERT INTO customers (customerNumber, customerName,contactLastName, contactFirstName, phone, addressLine1, city, country,salesRepEmployeeNumber, creditLimit) VALUES (999, 'Abc Company', 'ali','ahmad', '962797700235', '123 Main St', 'Los Angeles', 'USA', 1370, 50000.00)";

		stmt = con.createStatement();
		int rowInserted = stmt.executeUpdate(QueryToAdd);
		System.out.println(rowInserted);
	}

	@Test(priority = 3)
	public void CalendrRead() throws SQLException, InterruptedException {
		Thread.sleep(4000);

		String QueryToRead = "select * from customers where customerNumber=999";

		stmt = con.createStatement();
		rs = stmt.executeQuery(QueryToRead);

		while (rs.next()) {
			CustomerFirstName = rs.getString("contactFirstName");
			CustomerLastName = rs.getString("contactLastName");
			CustomerEmail = rs.getString("contactFirstName") + rs.getString("contactLastName") + "@gmail.com";
			CustomerPhone = rs.getString("phone");
			CustomerDetails = rs.getString("customerName");

		}

		driver.findElement(By.id("name1")).sendKeys(CustomerFirstName);
		driver.findElement(By.id("secondname1")).sendKeys(CustomerLastName);
		driver.findElement(By.id("email1")).sendKeys(CustomerEmail);
		driver.findElement(By.id("phone1")).sendKeys(CustomerPhone);
		driver.findElement(By.id("details1")).sendKeys(CustomerDetails);
	}

	@Test(priority = 4)
	public void calenderupdate() throws InterruptedException, SQLException {
		Thread.sleep(4000);

		String QueryToUpdate = "update customers set CustomerNumber = 1161 where customerNumber = 999";

		stmt = con.createStatement();

		stmt.executeUpdate(QueryToUpdate);
	}

	@Test(priority = 5)
	public void CalendrReadAfterUpdate() throws SQLException, InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);

		String QueryToRead = "select * from customers where customerNumber=1161";

		stmt = con.createStatement();
		rs = stmt.executeQuery(QueryToRead);

		while (rs.next()) {
			CustomerFirstName = rs.getString("contactFirstName");
			CustomerLastName = rs.getString("contactLastName");
			CustomerEmail = rs.getString("contactFirstName") + rs.getString("contactLastName") + "@gmail.com";
			CustomerPhone = rs.getString("phone");
			CustomerDetails = rs.getString("customerName");

		}

		driver.findElement(By.id("name1")).sendKeys(CustomerFirstName);
		driver.findElement(By.id("secondname1")).sendKeys(CustomerLastName);
		driver.findElement(By.id("email1")).sendKeys(CustomerEmail);
		driver.findElement(By.id("phone1")).sendKeys(CustomerPhone);
		driver.findElement(By.id("details1")).sendKeys(CustomerDetails);
	}

	@Test(priority = 6)
	public void calenderDelete() throws InterruptedException, SQLException {
		String QueryToDelete = "delete from customers where customerNumber = 1161";
		stmt = con.createStatement();

		stmt.executeUpdate(QueryToDelete);

	}

	@Test(priority = 7)
	public void Iframe() throws InterruptedException {

		Set<String> handels = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(handels);

		driver.switchTo().window(windowList.get(0));

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,2500)");

		WebElement theFrame = driver.findElement(By.id("courses-iframe"));

		driver.switchTo().frame(theFrame);
		Thread.sleep(2000);
		WebElement BurgerMenu = driver.findElement(By.cssSelector(".ct-mobile-meta-item.btn-nav-mobile.open-menu"));

		BurgerMenu.click();

	}
}
