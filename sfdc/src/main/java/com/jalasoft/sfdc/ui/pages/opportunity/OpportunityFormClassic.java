package com.jalasoft.sfdc.ui.pages.opportunity;

import com.jalasoft.sfdc.entities.Opportunity;
import com.jalasoft.sfdc.entities.PriceBook;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookDetailPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookDetailPageClassic;
import com.jalasoft.sfdc.ui.pages.products.ProductsForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpportunityFormClassic extends OpportunityForm {

    @FindBy(css = ".requiredInput input[name='opp3']")
    private WebElement nameTxtBox;

    @FindBy(css = ".requiredInput input[name='opp9']")
    private WebElement closeDateCmbBox;

    @FindBy(css = ".requiredInput select[name='opp11']")
    private WebElement stageCmbBox;

    @FindBy(css = ".pbButton .btn[title='Save']")
    private WebElement saveBtn;

    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
    }


    /**
     * Method that performs the setting of information of the fields of the form.
     *
     * @param opportunity value of the field to be set.
     */
    @Override
    public OpportunityDetailPage setFormOpportunity(Opportunity opportunity) {
        driverTools.setInputField(nameTxtBox, opportunity.getNameOpportunity());
        chooseStageClassicCmbBox(opportunity.getStage());
        WebElement dateBox = driver.findElement(By.cssSelector(".requiredInput input[name='opp9']"));
        dateBox.sendKeys(opportunity.getCloseDate());

        driverTools.setInputField(closeDateCmbBox, opportunity.getCloseDate());
        driverTools.clickElement(saveBtn);
        return new OpportunityDetailPageClassic();
    }

    /**
     * Method that selects an element of the combo box and has as input a string.
     *
     * @param stageFamily is a string that represents the option of the combo box that is required to select.
     */
    public OpportunityForm chooseStageClassicCmbBox(final String stageFamily) {
        wait.until(ExpectedConditions.elementToBeClickable(stageCmbBox));
        driverTools.clickElement(stageCmbBox);
        if (!stageFamily.isEmpty()) {
            driverTools.clickElement(driver.findElement(By.cssSelector("[value=" + stageFamily + "]")));
        }
        return this;
    }
}
