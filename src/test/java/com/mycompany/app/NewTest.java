// package com.mycompany.app;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.fail;

// import java.io.ByteArrayOutputStream;
// import java.io.PrintStream;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.testng.Assert;		
// import org.testng.annotations.Test;	
// import org.testng.annotations.BeforeTest;	
// import org.testng.annotations.AfterTest;		
// public class NewTest {		
// 	    private WebDriver driver;	
// 	  //  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
// 		@Test				
// 		public void testEasy() {	
// 			driver.get("http://demo.guru99.com/test/guru99home/");  
// 			String title = driver.getTitle();				 
// 			Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
// 		}	
// 		@BeforeTest
// 		public void beforeTest() {	
// 			//System.setProperty("webdriver.gecko.driver", "F:/geckodriver.exe");
// 		    driver = new FirefoxDriver();  
// 		}		
// 		@AfterTest
// 		public void afterTest() {
// 			driver.quit();			
// 		}	
		

// //	    @BeforeTest
// //	    public void setUpStreams() {
// //	        System.setOut(new PrintStream(outContent));
// //	    }

// //	    @Test
// //	    public void testAppConstructor() {
// //	        try {
// //	            new App();
// //	        } catch (Exception e) {
// //	            fail("Construction failed.");
// //	        }
// //	    }
// //
// //	    @Test
// //	    public void testAppMain()
// //	    {
// //	        App.main(null);
// //	        try {
// //	            assertEquals("Hello World!" + System.getProperty("line.separator"), outContent.toString());
// //	        } catch (AssertionError e) {
// //	            fail("\"message\" is not \"Hello World!\"");
// //	        }
// //	    }
// //
// //	    @AfterTest
// //	    public void cleanUpStreams() {
// //	        System.setOut(null);
// //	    }
// }	
