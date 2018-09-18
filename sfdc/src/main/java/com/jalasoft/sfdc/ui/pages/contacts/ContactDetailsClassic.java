package com.jalasoft.sfdc.ui.pages.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Contact details Page classic class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactDetailsClassic extends ContactDetails {

    private static final String NAME_CONTACT = "#con2_ileinner";

    @FindBy(css = "//span[text()='Details']")
    private WebElement detailsLbl;

    @FindBy(css = NAME_CONTACT)
    private WebElement nameLbl;

    @FindBy(css = "#con13_ileinner")
    private WebElement phoneTextBox;

    @FindBy(css = "#con15_ileinner a")
    private WebElement emailTextBox;

    @FindBy(css = "#topButtonRow > input[value=' Edit ']")
    private WebElement editBtn;

    /**
     * get a element name of contact create.
     *
     * @return label name contact.
     */
    @Override
    public String getContactNameLbl() {
        return nameLbl.getText();
    }

    @Override
    public void goToValidateContact() {

    }

    @Override
    public ContactForm goToEditContactForm() {
        driverTools.clickElement(editBtn);
        return new ContactFormClassic();
    }

    @Override
    public String getPhoneTextBox() {
        return phoneTextBox.getText();
    }

    @Override
    public String getFirstNameTextBox() {
        return null;
    }

    @Override
    public String getLastNameTextBox() {
        return null;
    }

    @Override
    public String getEmailTextBox() {
        return emailTextBox.getText();
    }

    @Override
    public String getOtherStreetTextBox() {
        return null;
    }

    @Override
    public String getOtherCityTextBox() {
        return null;
    }

    @Override
    public String getOtherStateTextBox() {
        return null;
    }


    @Override
    public void waitUntilPageObjectIsLoaded() { }
}
