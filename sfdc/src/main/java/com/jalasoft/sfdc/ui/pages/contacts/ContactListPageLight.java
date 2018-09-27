package com.jalasoft.sfdc.ui.pages.contacts;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Contact list Page light class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactListPageLight extends ContactListPage {

    private static final String CONTACT_PATH_ONE = "//a[text()='";
    private static final String CONTACT_PATH_TWO = "']";
    private static final String NEW_CONTACT = "//div[@title='New']";
    @FindBy(xpath = NEW_CONTACT)
    private WebElement newButton;

    public ContactListPageLight() {
    }

    @Override
    public void waitUntilPageObjectIsLoaded() { }

    /**
     * this method return contact form type light.
     *
     * @return new Contact form light.
     */
    public ContactForm goToContactNewForm() {

        wait.until(ExpectedConditions.visibilityOf(newButton));
        driverTools.clickElement(newButton);
        return new ContactFormLight();
    }

    /**
     * this method is contact select.
     *
     * @param contact - entity contact.
     * @return xpath full name.
     */
    @Override
    public boolean isContactSelected(Contact contact) {
        return driverTools.isElementDisplayed(By.xpath(CONTACT_PATH_ONE+ contact.getFullName() + CONTACT_PATH_TWO));
    }

    /**
     * @param contact - entity contact.
     *
     * @return contact details light.
     */
    @Override
        public ContactDetails contactSelected(Contact contact) {
        driverTools.clickOnElementDisplayed(By.xpath(CONTACT_PATH_ONE+ contact.getFullName() + CONTACT_PATH_TWO));
        return new ContactDetailsLight();
    }
}
