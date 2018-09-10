package com.jalasoft.sfdc.ui.pages.home;

import com.jalasoft.sfdc.ui.pages.profiles.ProfilePage;
import com.jalasoft.sfdc.ui.pages.profiles.ProfilePageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLight extends HomePage {

    @FindBy(xpath = "//*[@class='slds-icon-waffle']")
    private WebElement userProfileName;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /*public AppLauncher goToAllPages() {
        driverTools.clickElement(userProfileName);
        return new AppLauncher();
    }*/
}
