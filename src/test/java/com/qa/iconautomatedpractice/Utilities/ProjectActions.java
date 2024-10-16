package com.qa.iconautomatedpractice.Utilities;

import org.openqa.selenium.WebDriver;

public class ProjectActions {

    ProjectPageElements project;
    public ProjectActions(WebDriver driver) {
        project = new ProjectPageElements(driver);
    }

    public void ClickSideMenuIcon() {project.SideMenuIcon.click();}
    public void ClickMainProject() {project.ProjectModule.click();}
    public void ClickSubProject() {project.Project.click();}
    public void ClickProjectButton() {project.AddProject.click();}

}
