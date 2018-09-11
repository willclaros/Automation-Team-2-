package com.jalasoft.sfdc.ui.pages.profiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePageLight extends ProfilePage {

    @FindBy(xpath = "(//a[@class='profile-link-label'])[1]")
    private WebElement userProfileName;

    @Override
    public boolean isUserNameDisplayed(String nombre) {
        return (userProfileName.getText().equals(nombre));
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
}
