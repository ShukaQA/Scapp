import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class LogInTest {
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

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ავტორიზაცია\"]/android.view.View/android.widget.EditText[1]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ავტორიზაცია\"]/android.view.View/android.widget.EditText[1]")).sendKeys("gaga");
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ავტორიზაცია\"]/android.view.View/android.widget.EditText[2]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ავტორიზაცია\"]/android.view.View/android.widget.EditText[2]")).sendKeys("123");
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"შესვლა\"]")).click();
            driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("1234");

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"შესვლა\"]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ახალი სესხი\"]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ავტო სესხი\"]")).click();

            driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")).click();
            driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")).clear();
            driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")).sendKeys("10000");

            driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]")).click();
            driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]")).clear();
            driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]")).sendKeys("5");


            driver.findElement(By.xpath("//android.view.View[@content-desc=\"გადახდის რიცხვი:\"]")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"30, შაბათი, 30 აგვისტო, 2025\"]")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"კარგი\"]")).click();

            driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.Button[1]")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"პეკინი\"]")).click();

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"გაგრძელება\"]")).click();

            driver.findElement(By.xpath("//android.view.View[@content-desc=\"მწარმოებელი:\"]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"BMW\"]")).click();

            driver.findElement(By.xpath("//android.view.View[@content-desc=\"მოდელი:\"]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"X5\"]")).click();

            //TODO here
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"გამოშვების წელი:\"]")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"2004\"]")).click();

            driver.findElement(By.xpath("//android.view.View[@content-desc=\"საწვავის ტიპი:\"]")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"ბენზინი\"]")).click();

            driver.findElement(By.xpath("//android.widget.EditText[@hint='გარბენი:']")).click();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='გარბენი:']")).clear();
            driver.findElement(By.xpath("//android.widget.EditText[@hint='გარბენი:']")).sendKeys("130000");

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"
            ));

            driver.findElement(By.xpath("//android.view.View[@content-desc=\"განბაჟებული:\"]")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"არა\"]")).click();

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"გაგრძელება\"]")).click();

            driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"მიამაგრე ფოტო\"])[1]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"ტელეფონის გალერეა\"]")).click();
            driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View")).click();

            for (int i = 0; i < 4; i++) {
                driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"მიამაგრე ფოტო\"])[1]")).click();
                driver.findElement(By.xpath("//android.view.View[@content-desc=\"ტელეფონის გალერეა\"]")).click();
                driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View")).click();
            }

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"
            ));

            for (int i = 0; i < 3; i++) {
                driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"მიამაგრე ფოტო\"])[1]")).click();
                driver.findElement(By.xpath("//android.view.View[@content-desc=\"ტელეფონის გალერეა\"]")).click();
                driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View")).click();
            }

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"მოითხოვე სესხი\"]")).click();

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"
            ));

            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"ვადასტურებ\"]")).click();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"განაცხადების ისტორია\"]")).click();

            driver.terminateApp("ge.sc.scapp");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

