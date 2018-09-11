package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.all_apps_page.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.all_apps_page.AllAppsPageLight;
import com.jalasoft.sfdc.ui.pages.profiles.ProfilePage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.profiles.ProfilePageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuLight extends TopMenu {
    @FindBy(css = ".branding-user-profile")
    private WebElement userProfile;

    @FindBy(xpath = "(//span[@class='uiImage'])[1]")
    private WebElement userProfileBtn;

    @FindBy(xpath = "//*[@class='slds-icon-waffle']")
    private WebElement louncherBtn;

    @Override
    public AllAppsPage goToAllPages() {
        //wait.until(ExpectedConditions.visibilityOf(louncherBtn));
        driverTools.clickElement(louncherBtn);
        return new AllAppsPageLight();
    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageLight();
    }

    @Override
    public ProfilePage goToProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(userProfile));
        driverTools.clickElement(userProfileBtn);
        return new ProfilePageLight();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    @Override
    public void swithSkin() {
    }
}
