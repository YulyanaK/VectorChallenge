import com.google.common.base.Verify;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;


public class Challenge1 {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {

        try {
            openSSO();
            //openVector();

        } catch(Exception exp) {
            System.out.println( exp.getCause() );
            System.out.println( exp.getMessage() );
            exp.printStackTrace();
        }


    }

    public static void openSSO() throws IOException, InterruptedException {


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability( "deviceName", "Nexus" );
        cap.setCapability( "platformName", "Android" );
        cap.setCapability( "udid", "emulator-5554" );
        cap.setCapability( "platformVersion", "10" );
        cap.setCapability( "appPackage", "com.convoy.ssodemo" );
        cap.setCapability( "appActivity", "com.convoy.ssodemo.MainActivity" );
        URL url = new URL( "http://127.0.0.1:4723/wd/hub" );
        driver = new AppiumDriver<MobileElement>( url, cap );
        System.out.println( "Application Started ..." );

        MobileElement login = driver.findElement( By.id( "com.convoy.ssodemo:id/sso_button" ) );

        MobileElement logout = driver.findElement( By.id( "com.convoy.ssodemo:id/sso_button2" ) );

        logout.click();

        Thread.sleep(3000);


        login.click();

        Thread.sleep(5000);




        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(text(), 'type = login, message = ok, code = 0')]")));

        File srcFile=driver.getScreenshotAs( OutputType.FILE);
        String filename= UUID.randomUUID().toString();
        File targetFile=new File("target/screenshots/"+ filename +".jpg");
        FileUtils.copyFile(srcFile,targetFile);
        System.out.print(targetFile);








    }

    /*public static void openVector() throws IOException {


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Nexus");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformVersion", "10");
        cap.setCapability("appPackage", "com.convoy.loaddoc");
        cap.setCapability("appActivity", "com.convoy.loaddoc.MainActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);
        System.out.println("Application Started ...");

        MobileElement hamburger = driver.findElement(By.xpath("//android.widget.ImageView[@package='com.convoy.loaddoc']"));

        String username = driver.findElement(By.xpath("//android.widget.TextView[@package='com.convoy.loaddoc']")).getText();

        hamburger.click();

        Assert.assertEquals("Murzik Cat", username);

        MobileElement hamburgerClose = driver.findElement(By.xpath("//android.widget.TextView[text()='Documents']"));





    }*/











}
