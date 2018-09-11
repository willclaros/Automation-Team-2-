package com.jalasoft.sfdc.ui.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsPageLight extends AccountDetailsPage {


    @FindBy(xpath = "(//div[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon']//child::span)[1]")
    private WebElement nameDetailsLbl;

    @Override
    public String verifyElement() {
        wait.until(ExpectedConditions.visibilityOf(nameDetailsLbl));
        return nameDetailsLbl.getText();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameDetailsLbl));
    }

}
