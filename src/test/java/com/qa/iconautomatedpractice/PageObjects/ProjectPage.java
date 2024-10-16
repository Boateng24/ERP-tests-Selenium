package com.qa.iconautomatedpractice.PageObjects;

import com.qa.iconautomatedpractice.Utilities.ProjectActions;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage{
    WebDriver driver;
    ProjectActions actions;

    public ProjectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        actions = new ProjectActions(driver);
    }

    public void NavigateToProject() {
        actions.ClickSideMenuIcon();
        actions.ClickMainProject();
        actions.ClickSubProject();
        actions.ClickProjectButton();
    }
}
