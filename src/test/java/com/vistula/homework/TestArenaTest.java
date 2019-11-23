package com.vistula.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestArenaTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.testarena.pl/zaloguj");
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void after(){
        driver.quit();
    }

    @Test
    public void adminShouldBeAbleToCreateNewProject() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        KokpitPage kokpitPage = new KokpitPage(driver, wait);
        kokpitPage.goToAdmin();

        AdminPage adminPage = new AdminPage(driver, wait);
        adminPage.goToAddProject();

        adminPage.addProject();

        adminPage.goToProjects();

        adminPage.searchProject();
    }
}
