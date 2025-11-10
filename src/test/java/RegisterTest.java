import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class RegisterTest {
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

            driver.findElement(By.xpath("//android.widget.Button[@content-desc='რეგისტრაცია']")).click();
            driver.findElement(By.xpath("//android.widget.EditText")).click();
            driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("555317613");
            driver.findElement(By.xpath("//android.widget.Button[@content-desc='გაგრძელება']")).click();

            //OTP here
            driver.findElement(By.xpath("//android.widget.Button[@content-desc='გაგრძელება']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc='გაგრძელება']")).click();
            driver.findElement(By.xpath("//android.widget.CheckBox")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc='გაგრძელება']")).click();
            //driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")).click();

            driver.findElement(By.xpath("//android.widget.Button[@content-desc='გაგრძელება']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='პირადობის მოწმობა']")).click();
            driver.findElement(By.xpath("//android.widget.Button[@text='გაგრძელება']")).click();


            //Runtime.getRuntime().exec("adb emu camera inject-image C:\\Users\\shuka\\Pictures\\scapp");

            //Thread.sleep(50000);

            driver.terminateApp("ge.sc.scapp");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
