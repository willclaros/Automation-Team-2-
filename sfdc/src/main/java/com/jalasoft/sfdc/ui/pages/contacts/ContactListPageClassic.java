package com.jalasoft.sfdc.ui.pages.contacts;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Contact list Page classic class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactListPageClassic extends ContactListPage {

    private static final String CONTACT_PATH_ONE = "//a[text()='";
    private static final String CONTACT_PATH_TWO = "']";
    private static final String POINT = ", ";

    @FindBy(xpath = "//input[@title='New']")
    private WebElement newButton;

    @FindBy(xpath = "//*[@class='dialogClose']")
    private WebElement exitBtn;

    /**
     * new class contact form type classic.
     *
     * @return contact form classic.
     */
    @Override
    public ContactForm goToContactNewForm() {
        wait.until(ExpectedConditions.visibilityOf(newButton));
        if (driverTools.isElementDisplayed(exitBtn)){
            driverTools.clickElement(exitBtn);
        }
        driverTools.clickElement(newButton);
        return new ContactFormClassic();
    }

    /**
     * wait a element of actual page.
     */
    @Override
    public boolean isContactSelected(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath(CONTACT_PATH_ONE+ contact.getFullName() + CONTACT_PATH_TWO));
    }

    /**
     * @param contact contact entity.
     * @return null.
     */
    @Override
    public ContactDetails contactSelected(Contact contact) {
        if (driverTools.isElementDisplayed(exitBtn)){
            driverTools.clickElement(exitBtn);
        }
        driverTools.clickOnElementDisplayed(By.xpath(CONTACT_PATH_ONE+ contact.getLastName()+POINT+contact.getFirstName() + CONTACT_PATH_TWO));
        return new ContactDetailsClassic();
    }

    /**
     * wait a element of actual page.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
