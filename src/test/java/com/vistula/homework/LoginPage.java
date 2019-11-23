package com.vistula.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        WebElement login = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));

        login.sendKeys("administrator@testarena.pl");
        password.sendKeys("sumXQQ72$L");

        WebElement submit = driver.findElement(By.id("login"));
        submit.click();
    }
}
