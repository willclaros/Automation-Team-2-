package com.jalasoft.sfdc.ui.pages.profiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageClassic extends ProfilePage {

    @FindBy(css = ".menuButtonButton span[id = 'userNavLabel']")
    private WebElement userProfileName;

    @Override
    public boolean isUserNameDisplayed(String name) {
        return userProfileName.getText().equals(name);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
}