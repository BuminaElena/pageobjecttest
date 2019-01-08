import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameText = By.xpath(".//input[@id='login_field']");
    private By passwordText = By.xpath(".//input[@id='password']");
    private By signInButton = By.xpath(".//input[@value='Sign in']");
    private By heading = By.xpath(".//div[@class='auth-form-header p-0']//h1");
    private By errorText = By.xpath(".//div[@id='js-flash-container']//div[@class='container']");
    private By createAccLink = By.xpath(".//a[text()='Create an account']");


    public LoginPage typeUserName(String username) {
        driver.findElement(userNameText).sendKeys(username);
        return this;
    }
    public LoginPage typePassword (String password) {
        driver.findElement(passwordText).sendKeys(password);
        return this;
    }
    public LoginPage loginWithInvalidCreds (String username, String password) {
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() {
       return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

    public SignUpPage createAccount() {
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }


}
