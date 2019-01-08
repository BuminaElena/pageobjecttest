import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\IdeaProjects\\pageobjecttest\\src\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.register("testusername578654", "test958632@gmail.com", "qweqwe786TT");

    }
}
