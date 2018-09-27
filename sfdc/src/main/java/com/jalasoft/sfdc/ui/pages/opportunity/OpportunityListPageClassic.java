package com.jalasoft.sfdc.ui.pages.opportunity;

import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBooksForm;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBooksFormClassic;
import com.jalasoft.sfdc.ui.pages.products.ProductsDetailPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsDetailPageClassic;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpportunityListPageClassic extends OpportunityListPage {

    @FindBy(css = ".btn[title*='New']")
    private WebElement newBtn;

    @FindBy(xpath = "//*[@class='dialogClose']")
    private WebElement exitBtn;


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
     * @return returns the Price Book Classic form.
     */
    @Override
    public OpportunityForm clickNewBtn() {
        if (driverTools.isElementDisplayed(exitBtn)) {
            driverTools.clickElement(exitBtn);
        }
        driverTools.clickElement(newBtn);
        return new OpportunityFormClassic();
    }


    @Override
    public ProductsDetailPage goToPageDetails(Product product) {
        driver.navigate().to("https://na49.salesforce.com/" + product.getId());
        return new ProductsDetailPageClassic();
    }

    @Override
    public QuotesFormClassic goToQuotes() {
        return null;
    }
}
