package com.vistula.homework;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private String generatedString;
    private final String generatedProjectName;

    public AdminPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.generatedString = RandomStringUtils.randomAlphanumeric(5);
        this.generatedProjectName = "JWikiera-" + generatedString;
        PageFactory.initElements(driver, this);
    }

    public void goToAddProject() {
        WebElement addProject = driver.findElement
                (By.cssSelector("a[href='http://demo.testarena.pl/administration/add_project']"));
        wait.until(ExpectedConditions.elementToBeClickable(addProject));
        addProject.click();
    }

    public void addProject(){
        WebElement projectName = driver.findElement(By.id("name"));
        wait.until(ExpectedConditions.elementToBeClickable(projectName));
        projectName.sendKeys(generatedProjectName);

        WebElement projectPrefix = driver.findElement(By.id("prefix"));
        projectPrefix.sendKeys(generatedString);

        WebElement projectSave = driver.findElement(By.id("save"));
        projectSave.click();
    }

    public void goToProjects(){
        WebElement projects = driver.findElement
                (By.cssSelector("a[href='http://demo.testarena.pl/administration/projects']"));
        projects.click();
    }

    public void searchProject(){
        WebElement search = driver.findElement(By.id("search"));
        WebElement searchButton = driver.findElement(By.id("j_searchButton"));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        search.sendKeys(generatedProjectName);
        searchButton.click();

        //TODO należy dodać asercje w oparciu o selektor css/xpath aby test był kompletny
        /**
         *         to działa w chrome ale nie w selenium
         *         String xpathExpression = "//text()='JWikiera-" + generatedString + "'";
         *         WebElement result = driver.findElement(By.xpath(xpathExpression));
         *
         *         Sławku jak to dodać?
          */

    }
}
