package com.test.app;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

	public class App {

	    private WebDriver driver;

	    public GitHubLogin(String driverPath) {
	        System.setProperty("webdriver.chrome.driver", driverPath);
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        this.driver = new ChromeDriver(options);
	    }

	    public void openLoginPage() {
	        driver.get("https://github.com/login");
	    }

	    public void login(String username, String password) {
	        WebElement usernameField = driver.findElement(By.id("login_field"));
	        usernameField.sendKeys(username);

	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.sendKeys(password);

	        WebElement signInButton = driver.findElement(By.name("commit"));
	        signInButton.click();
	    }

	    public boolean isLoginSuccessful() {
	        return driver.findElements(By.xpath("//summary[@aria-label='View profile and more']")).size() > 0;
	    }

	    public boolean isLoginErrorDisplayed() {
	        return driver.findElements(By.xpath("//div[@class='flash flash-full flash-error ']")).size() > 0;
	    }

	    public void logout() {
	        WebElement profileMenu = driver.findElement(By.xpath("//summary[@aria-label='View profile and more']"));
	        profileMenu.click();
	        WebElement signOutButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign out')]"));
	        signOutButton.click();
	    }

	    public void closeBrowser() {
	        driver.quit();
	    }
	}
