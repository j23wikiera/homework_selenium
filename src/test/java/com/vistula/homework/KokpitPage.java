package com.vistula.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KokpitPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public KokpitPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToAdmin() {
        WebElement adminPanel = driver.findElement(By.className("header_admin"));
        wait.until(ExpectedConditions.elementToBeClickable(adminPanel));
        adminPanel.click();
    }

}
