package com.jalasoft.sfdc.ui.pages.allappspage;

import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPageClassic;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPageClassic;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPageClassic;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllAppsPageClassic extends AllAppsPage {

    @FindBy(xpath = "//*[@class='listRelatedObject productBlock title']")
    private WebElement productsBtn;

    @FindBy(xpath = "//*[@title='Accounts']")
    private WebElement accountsBtn;

    @FindBy(css = "a.contactBlock")
    private WebElement contactBtn;

    @FindBy(css = ".pricebook2Block .title")
    private WebElement priceBooksBtn;


    @Override
    public AccountsListPage goToaccount() {
        wait.until(ExpectedConditions.visibilityOf(accountsBtn));
        driverTools.clickElement(accountsBtn);
        return new AccountsListPageClassic();
    }

    @Override
    public ProductsListPage goToProductsListPage() {
        wait.until(ExpectedConditions.visibilityOf(productsBtn));
        driverTools.clickElement(productsBtn);
        return new ProductsListPageClassic();
    }

    /**
     * Method that redirects to Price Books List Page of skin classic when pressing the WebElement.
     *
     * @return returns the Price Books List Page
     */
    @Override
    public PriceBookListPage goToPriceBooksListPage() {
        wait.until(ExpectedConditions.visibilityOf(priceBooksBtn));
        driverTools.clickElement(priceBooksBtn);
        return new PriceBookListPageClassic();
    }


    @Override
    public ContactListPage goToContact() {
        wait.until(ExpectedConditions.visibilityOf(contactBtn));
        driverTools.clickElement(contactBtn);
        return new ContactListPageClassic();
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountsBtn));
    }
}
