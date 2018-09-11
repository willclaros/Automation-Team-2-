package com.jalasoft.sfdc.ui.pages.profiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageClassic extends ProfilePage {


    @FindBy(css = ".currentStatusUserName")
    private WebElement userProfileName;

    @FindBy(css = ".col a[href*='User']")
    private WebElement userProfileNameTwo;

    @FindBy(css = ".pageDescription")
    private WebElement userProfileNameThree;

    @FindBy(css = ".menuButtonButton span[id = 'userNavLabel']")
    private WebElement userProfileNameFour;

    @Override
    public boolean isUserNameDisplayed(String name) {
        return userProfileNameFour.getText().equals(name);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
}