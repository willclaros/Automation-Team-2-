package com.jalasoft.sfdc.ui.pages.allappspage;

import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPageClassic;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPageClassic;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
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

    @Override
    public PriceBookListPage goToPriceBooks() {
        return null;
    }

    @Override
    public ContactListPage goToContact() {
        driverTools.scrollDown(3);
        wait.until(ExpectedConditions.visibilityOf(contactBtn));
        driverTools.clickElement(contactBtn);
        return new ContactListPageClassic();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountsBtn));
    }
}
