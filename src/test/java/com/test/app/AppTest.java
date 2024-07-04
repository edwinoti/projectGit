package com.test.app;
	
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import static org.junit.Assert.*;

	public class GitHubLoginTest {

	    private GitHubLogin gitHubLogin;
	    private final String DRIVER_PATH = "home/edwin/chromedriver.exe";

	    @Before
	    public void setUp() {
	        gitHubLogin = new GitHubLogin(DRIVER_PATH);
	    }

	    @After
	    public void tearDown() {
	        gitHubLogin.closeBrowser();
	    }

	    @Test
	    public void testSuccessfulLogin() {
	        gitHubLogin.openLoginPage();
	        gitHubLogin.login("edwin", "*****");
	        
	        try {
	            Thread.sleep(2000); // wait for login to process
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        assertTrue(gitHubLogin.isLoginSuccessful());
	        gitHubLogin.logout();
	    }

	    @Test
	    public void testUnsuccessfulLogin() {
	        gitHubLogin.openLoginPage();
	        gitHubLogin.login("edwinx", "***yyy*");
	        
	        try {
	            Thread.sleep(2000); // wait for login to process
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        assertTrue(gitHubLogin.isLoginErrorDisplayed());
	    }
	}

}
