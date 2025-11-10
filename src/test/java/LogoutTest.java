import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.URL;
import java.time.Duration;

public class LogoutTest {
    public static void main(String[] args) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("deviceName", "emulator-5554");
            caps.setCapability("appPackage", "ge.sc.scapp");
            caps.setCapability("appActivity", "io.flutter.embedding.android.FlutterActivity");
            caps.setCapability("noReset", true);

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ავტორიზაცია\"]/android.view.View/android.widget.EditText[1]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ავტორიზაცია\"]/android.view.View/android.widget.EditText[1]")).sendKeys("gaga");
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ავტორიზაცია\"]/android.view.View/android.widget.EditText[2]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ავტორიზაცია\"]/android.view.View/android.widget.EditText[2]")).sendKeys("123");
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"შესვლა\"]")).click();

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"შესვლა\"]")).click();
            driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.Button[1]")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"გამოსვლა\"]")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")).isDisplayed());

            //Thread.sleep(50000);

            driver.terminateApp("ge.sc.scapp");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
