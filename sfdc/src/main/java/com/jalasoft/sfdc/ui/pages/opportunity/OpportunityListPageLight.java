package com.jalasoft.sfdc.ui.pages.opportunity;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.pages.products.ProductsDetailPage;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpportunityListPageLight extends OpportunityListPage {

    @FindBy(css = ".forceActionLink")
    private WebElement newBtn;

    /**
     * Method that waits until the page element is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }

    /**
     * Method that redirects us to Price Book form by pressing the New button.
     *
     * @return returns the Price Book Light form.
     */
    @Override
    public OpportunityForm clickNewBtn() {
        driverTools.clickElement(newBtn);
        return new OpportunityFormLight();
    }

    @Override
    public ProductsDetailPage goToPageDetails(Product product) {
        return null;
    }

    @Override
    public QuotesFormClassic goToQuotes() {
        return null;
    }
}
