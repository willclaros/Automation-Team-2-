package com.jalasoft.sfdc.ui.pages.contacts;

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

    private static final String NEW_CONTACT = "//div[@title='New']";

    @FindBy(xpath = NEW_CONTACT)
    private WebElement newButton;

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
}
