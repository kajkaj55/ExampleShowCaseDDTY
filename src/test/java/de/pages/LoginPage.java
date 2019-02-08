package de.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base{

    @FindBy(id = "username")
    WebElement usernameElement;

    @FindBy(id = "password")
    WebElement passwordElement;

    @FindBy(id = "button")
    WebElement buttonElement;

    @FindBy(id = ".flash.success")
    WebElement flashSuccessElement;

    public LoginPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);

        visit("https://the-internet.herokuapp.com/login");
    }

   /* public void loginWith(String username, String password){
        type(usernameElement, 4, username);
        type(passwordElement,4, password);
        click(buttonElement,4);
    }*/

    public void withUsername(String username){
        type(usernameElement, 4, username);
    }
    public void withPassword(String password){
        type(passwordElement,4, password);
    }
    public void cickLoginButton(){
        click(buttonElement,4);
    }

    public boolean successFullLoginIsDisplayed(){
        return isDisplayed(flashSuccessElement,5);
    }

}
