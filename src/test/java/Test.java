import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {
   static AndroidDriver driver;

    public static void main(String[] args) {
        try {
            setUp();
          //  register();
        }catch (Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

    @BeforeTest
    public static void setUp() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //set capability for mobile device
        desiredCapabilities.setCapability("deviceName", "Emulator");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11");

        //set app capability
       // desiredCapabilities.setCapability("app", "src/main/resources/app/app-release.apk");
        desiredCapabilities.setCapability("appPackage","com.myxalary");
        desiredCapabilities.setCapability("appActivity", "com.myxalary.MainActivity");

        //set desired capability to appium server
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, desiredCapabilities);

        System.out.println("Application started...");

        //WebElement webElement = driver.findElement();
    }

    @Test
    public static void register() throws InterruptedException {

        WebElement register = driver.findElement(By.className("android.view.ViewGroup"));
        WebElement phoneNumber = driver.findElement(By.className("android.widget.EditText"));
        WebElement proceed = driver.findElement(By.className("android.view.ViewGroup"));
        register.click();
        Thread.sleep(3000);
        phoneNumber.sendKeys("09059767945");
        proceed.click();
    }

    public void tearDown(){
        if (null != driver){
            driver.quit();
        }
    }
}
