package com.jalasoft.sfdc.ui.pages.allappspage;

import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPageLight;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPageLight;
import com.jalasoft.sfdc.ui.pages.products.product_list_page.ProductsListPage;
import com.jalasoft.sfdc.ui.pages.products.product_list_page.ProductsListPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllAppsPageLight extends AllAppsPage {

    @FindBy(linkText = "Contacts")
    private WebElement contactBtn;

    @FindBy(linkText = "Accounts")
    private WebElement accountButton;

    @FindBy(css = ".app-launcher-link[title|='Products']")
    private WebElement productsBtn;

    @FindBy(linkText = "Price Books")
    private WebElement priceBooks;

    @FindBy(css = "[title|='Service']")
    private WebElement serviceLink;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.visibilityOf(productsBtn));
        //driverTools.scrollToBottomOfPage();
    }

    public void moveOverElement(WebElement productsButton)
    {
        Actions actions = new Actions(driver);
        actions.clickAndHold(productsButton).moveByOffset(0,5000).release().perform();
    }


    @Override
    public AccountsListPage goToaccount() {
        //driverTools.scrollDown(3);
        driverTools.clickElement(accountButton);
        return new AccountsListPageLight();
    }

    @Override
    public ProductsListPage goToProducts() {
        //driverTools.scrollDown(4);
        //driver.manage().window();
        //moveOverElement(productsButton);
        wait.until(ExpectedConditions.visibilityOf(productsBtn));
        driverTools.scrollToBottomOfPage();
        //wait.until(ExpectedConditions.visibilityOf(productsBtn));
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
