package com.jalasoft.sfdc.ui.pages.all_apps_page;

import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPage;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPageClassic;
import com.jalasoft.sfdc.ui.pages.accounts.AccountsListPageLight;
import com.jalasoft.sfdc.ui.pages.pricebook.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.products.product_list_page.ProductsListPage;
import com.jalasoft.sfdc.ui.pages.products.product_list_page.ProductsListPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllAppsPageClassic extends AllAppsPage {

    @FindBy(xpath = "//*[@class='listRelatedObject productBlock title']")
    private WebElement productsBtn;

    @FindBy(xpath = "//*[@title='Accounts']")
    private WebElement accountsBtn;


    @Override
    public AccountsListPage goToaccount() {
        wait.until(ExpectedConditions.visibilityOf(accountsBtn));
        driverTools.clickElement(accountsBtn);
        return new AccountsListPageClassic();
    }

    @Override
    public ProductsListPage goToProducts() {
        wait.until(ExpectedConditions.visibilityOf(productsBtn));
        //driverTools.scrollToBottomOfPage();
        //wait.until(ExpectedConditions.visibilityOf(productsBtn));
        driverTools.clickElement(productsBtn);
        return new ProductsListPageClassic();
    }

    @Override
    public PriceBookListPage goToPriceBooks() {
        return null;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountsBtn));
    }
}
