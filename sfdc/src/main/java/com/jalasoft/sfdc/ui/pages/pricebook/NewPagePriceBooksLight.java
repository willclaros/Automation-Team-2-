package com.jalasoft.sfdc.ui.pages.pricebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPagePriceBooksLight extends NewPagePriceBook {

    @FindBy(xpath = "//*[@aria-required='true']")
    private WebElement priceBookName;

    @FindBy(xpath = "(//*[@class=' input'])[2]")
    private WebElement description;

    @FindBy(css = ".uiInput--checkbox input")
    private WebElement check;

    @FindBy(xpath = "//*[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
    private WebElement saveButton;


    @Override
    public PriceBookDetailPage setForm(String name, String descriptionPrice, String active) {
        driverTools.setInputField(priceBookName,name);
        driverTools.setInputField(description,descriptionPrice);
        if(active.equalsIgnoreCase("true")){
            driverTools.clickElement(check);
        }
        driverTools.clickElement(saveButton);
        return new PriceBookDetailPageLight();
    }

    @Override
    public PriceBookDetailPage clickSaveBtn() {
        return new PriceBookDetailPageLight();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }


}
