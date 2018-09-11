package com.jalasoft.sfdc.ui.pages.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Contact form Page type light class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactFormLight extends ContactForm {

    private static final String LAST_NAME = "//*[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']";
    private static final String SAVE = "button[title|='Save']";

    @FindBy(xpath = LAST_NAME)
    private WebElement lastNameTxtBox;
    @FindBy(css = SAVE)
    private WebElement saveBtn;


    /**
     * fill all fields of contact form.
     *
     * @param lastName - last name of the contact.
     * @return contact details type light.
     */
    @Override
    public ContactDetails fillContactForm(String lastName){

        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        driverTools.setInputField(lastNameTxtBox, lastName);
        driverTools.clickElement(saveBtn);
        return new ContactDetailsLight();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() { }
}
