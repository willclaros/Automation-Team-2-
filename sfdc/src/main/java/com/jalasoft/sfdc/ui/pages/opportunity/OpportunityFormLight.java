package com.jalasoft.sfdc.ui.pages.opportunity;

import com.jalasoft.sfdc.entities.Opportunity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpportunityFormLight extends OpportunityForm{

    @FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/following-sibling::input")
    private WebElement nameTxtBox;

    @FindBy(xpath = "//span[text()='Close Date']/parent::label/following-sibling::div/child::input")
    private WebElement closeDateCmbBox;

    @FindBy(xpath = "//span[text()='Stage']/parent::label/following-sibling::div/child::div/child::div/child::div/child::a")
    private WebElement stageCmbBox;

    @FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
    private WebElement saveBtn;

    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
    }


    @Override
    public OpportunityDetailPage setFormOpportunity(Opportunity opportunity) {
        driverTools.setInputField(nameTxtBox, opportunity.getNameOpportunity());
        chooseStageLightCmbBox(opportunity.getStage());
        WebElement dateBox = driver.findElement(By.xpath("//span[text()='Close Date']/parent::label/following-sibling::div/child::input"));
        dateBox.sendKeys(opportunity.getCloseDate());
        driverTools.clickElement(saveBtn);
        return new OpportunityDetailPageLight();
    }

    /**
     * Method that selects an element of the combo box and has as input a string.
     *
     * @param stageFamily is a string that represents the option of the combo box that is required to select.
     */
    public OpportunityForm chooseStageLightCmbBox(final String stageFamily) {
        wait.until(ExpectedConditions.elementToBeClickable(stageCmbBox));
        driverTools.clickElement(stageCmbBox);
        if (!stageFamily.isEmpty()) {
            driverTools.clickElement(driver.findElement((By.xpath("//a[text()= '"+stageFamily+"']"))));
        }
        return this;
    }
}
