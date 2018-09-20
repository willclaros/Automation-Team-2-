package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPageClassic;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.profiles.ProfilePage;
import com.jalasoft.sfdc.ui.pages.profiles.ProfilePageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuClassic extends TopMenu {

    @FindBy(css = ".allTabsArrow")
    private WebElement louncherBtn;


    @Override
    public AllAppsPage goToAllPages() {
        driverTools.clickElement(louncherBtn);
        return new AllAppsPageClassic();
    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageClassic();
    }

    @Override
    public ProfilePage goToProfilePage() {
        wait.until(ExpectedConditions.visibilityOf(louncherBtn));
        return new ProfilePageClassic();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    @Override
    public void swithSkin() {
    }
}
