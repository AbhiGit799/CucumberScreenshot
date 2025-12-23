package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Screenshot;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;

public class UserOpenChromeStepDefinition {

    public WebDriver driver;
    public static String lastStepText;

    public UserOpenChromeStepDefinition()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Given("^User (.+) open chrome browser$")
    public void UserOpenChromeBrowser (String username) {
        lastStepText = "User \"ABC\" open chrome browser";
        try {
            driver.get("https://www.google.com/");
            Thread.sleep(3000);
            byte[] byteArrayScreenshot = ((TakesScreenshot) driver).getScreenshotAs (OutputType.BYTES);
            File screenshotDestinationFile = new File(System.getProperty("user.dir")+"\\screenshots\\image.png");
            FileOutputStream fos = new FileOutputStream(screenshotDestinationFile);
            fos.write(byteArrayScreenshot);
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    @Given("User {string} open youtube")
    public void userOpenYoutube (String argo) {
        try{
            driver.get("https://www.bing.com/");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @And("^User (.+) close chrome browser skip screenshot$")
    public void userCloseChromeBrowserSkipScreenshot(String argo) {
        lastStepText = "User 'ABC' close chrome browser skip screenshot";
        // driver.quit();
    }



    @AfterStep
    public void Capture (Scenario scenario) {

//        if (!scenario.getSourceTagNames().contains("@NoScreenshot")) {
//            byte[] screenshot = Screenshot.captureScreenshot(driver);
//            scenario.attach(screenshot, "image/png", "Step Screenshot");
//        }

        if (!lastStepText.contains("skip screenshot")) {
            byte[] screenshot = Screenshot.captureScreenshot(driver);
            scenario.attach(screenshot, "image/png", "Step Screenshot");
            LocalDateTime currentDateTime =  LocalDateTime.now();
            scenario.attach(String.valueOf(currentDateTime), "text/plain", "Execution DateTime");
            String AppURL = driver.getCurrentUrl();
            //For attaching in cucumber report
            scenario.attach(AppURL.getBytes(), "text/plain", "Application URL");
        }
    }


    @Given("User {string} open udemy")
    public void userOpenUdemy (String arg0) {
        lastStepText = "User \"ABC\" open udemy";
        driver.get("https://www.udemy.com/");
    }

    @After
    public void closedriver(Scenario scenario)
    {
         driver.quit();
    }


}
