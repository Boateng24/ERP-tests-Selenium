package com.qa.iconautomatedpractice.TestCases;

import com.qa.iconautomatedpractice.PageObjects.LoginPage;
import com.qa.iconautomatedpractice.PageObjects.ProjectPage;
import com.qa.iconautomatedpractice.TestBase.BaseTest;
import org.testng.annotations.Test;

public class ProjectCreationTest extends BaseTest {

    @Test
    public void createProject() {
        try{
            LoginPage login = new LoginPage(driver);
            ProjectPage addProject = new ProjectPage(driver);

            login.loginUser("me@you.com", "11223344");
            addProject.NavigateToProject();
            browserUrl.CurrentUrl("/projects");
        } catch (Exception e) {
            logger.error("Project creation error", e);
            throw new RuntimeException(e);
        }
    }
}
