import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    By heading = By.xpath(".//h2[contains(text(),'Create your personal account')]");
    By userNameField = By.xpath(".//input[@id='user_login']");
    By emailField = By.xpath(".//input[@id='user_email']");
    By passwordField = By.xpath(".//input[@id='user_password']");
    By userNameError = By.xpath(".//input[@id='user_login']/following-sibling::p");
    By emailError = By.xpath(".//input[@id='user_email']/following-sibling::p");
    By passwordError = By.xpath(".//input[@id='user_password']/following-sibling::p");
    By signupButton = By.xpath(".//button[@id='signup_button']");

    public SignUpPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage signupWithInvalidCreds(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signupButton).click();
        return this;
    }

    public String getHeading() {
        return driver.findElement(heading).getText();
    }

    public String getUserNameError() {
        return driver.findElement(userNameError).getText();
    }

    public String getEmailError() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordError() {
        return driver.findElement(passwordError).getText();
    }



}
