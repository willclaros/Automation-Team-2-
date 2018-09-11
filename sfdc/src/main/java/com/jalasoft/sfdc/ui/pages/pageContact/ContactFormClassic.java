package com.jalasoft.sfdc.ui.pages.pageContact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Contact form Page classic class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactFormClassic extends ContactForm {

    private static final String LAST_NAME = "input#name_lastcon2";
    private static final String SAVE = "(//input[@title='Save'])[1]";

    @FindBy(css = LAST_NAME)
    private WebElement LastNameTxtBox;
    @FindBy(xpath = SAVE)
    private WebElement saveBtn;

    /**
     * fill all fields of contact form.
     *
     * @param lastName - last name of the contact.
     * @return contact details type light.
     */
    @Override
    public ContactDetails fillContactForm(String lastName) {

        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        driverTools.setInputField(LastNameTxtBox, lastName);
        driverTools.clickElement(saveBtn);
        return new ContactDetailsClassic();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() { }
}
