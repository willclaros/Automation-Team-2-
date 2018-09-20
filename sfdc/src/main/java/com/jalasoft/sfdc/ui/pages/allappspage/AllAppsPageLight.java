package com.jalasoft.sfdc.ui.pages.allappspage;

import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPageLight;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPage;
import com.jalasoft.sfdc.ui.pages.products.ProductsListPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllAppsPageLight extends AllAppsPage {

    @FindBy(linkText = "Contacts")
    private WebElement contactBtn;

    @FindBy(xpath = "//mark[text()='Accounts']")
    private WebElement accountButton;

    @FindBy(css = ".app-launcher-link[title|='Products']")
    private WebElement productsBtn;

    @FindBy(linkText = "Price Books")
    private WebElement priceBooks;

    @FindBy(css = "[title|='Service']")
    private WebElement serviceLink;

    @FindBy(xpath = "//input[@class='slds-input input']")
    private WebElement searchTxtBx;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        driverTools.scrollToBottomOfPage();
        wait.until(ExpectedConditions.visibilityOf(productsBtn));
    }

    @Override
    public AccountsListPage goToaccount() {
        driverTools.setInputField(searchTxtBx,"Accounts");
        wait.until(ExpectedConditions.visibilityOf(accountButton));
        driverTools.clickElement(accountButton);
        return new AccountsListPageLight();
    }

    @Override
    public ProductsListPage goToProductsListPage() {
        driverTools.scrollToBottomOfPage();
        driverTools.clickElement(productsBtn);
        return new ProductsListPageLight();
    }

    @Override
    public PriceBookListPage goToPriceBooks() {
        driverTools.clickElement(priceBooks);
        driverTools.scrollDown(3);
        driver.manage().window();
        return new PriceBookListPageLight();
    }

    @Override
    public ContactListPage goToContact() {
        driverTools.scrollDown(4);
        wait.until(ExpectedConditions.visibilityOf(contactBtn));
        driverTools.clickElement(contactBtn);
        return new ContactListPageLight();
    }
}
