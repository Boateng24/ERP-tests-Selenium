package com.qa.iconautomatedpractice.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPageElements {
    WebDriver driver;

    public ProjectPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-element='menu-icon']")
    public WebElement SideMenuIcon;

    @FindBy(xpath = "(//div[@class='relative'])[7]")
    public WebElement ProjectModule;

    @FindBy(xpath = "(//div[@data-element='nav-item'])[5]")
    public WebElement Project;
    @FindBy(xpath= "//button[span[text()='Add Project']]")
    public WebElement AddProject;
}
