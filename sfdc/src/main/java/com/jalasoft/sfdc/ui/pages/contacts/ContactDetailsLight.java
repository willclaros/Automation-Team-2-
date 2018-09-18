package com.jalasoft.sfdc.ui.pages.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Contact details Page light class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactDetailsLight extends ContactDetails {

    private static final String NAME = "//span[text()='Name']/parent::div/following-sibling::div/span/child::span";

    @FindBy(xpath = NAME)
    private WebElement contactNameLbl;

    @FindBy(xpath = "//span[text()='Phone']/parent::div/following-sibling::div/span/child::span")
    private WebElement phoneTextBox;

    @FindBy(xpath = "//span[text()='First Name']/parent::label/following-sibling::input")
    private WebElement firstNameTextBox;

    @FindBy(xpath = "//span[text()='Last Name']/parent::label/following-sibling::input")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "//span[text()='Email']/parent::div/following-sibling::div/span/child::span")
    private WebElement emailTextBox;

    @FindBy(xpath = "//span[text()='Other Street']/parent::label/following-sibling::textarea")
    private WebElement otherStreetTextBox;

    @FindBy(xpath = "//span[text()='Other City']/parent::label/following-sibling::input")
    private WebElement otherCityTextBox;

    @FindBy(xpath = "//span[text()='Other State/Province']/parent::label/following-sibling::input")
    private WebElement otherStateTextBox;

    @FindBy(css = ".sldsButtonHeightFix[title='Show 5 more actions']")
    private WebElement detailsLink;

    @FindBy(css = "a[title = 'Edit']")
    private WebElement editBtn;

    /**
     * get a element name of contact create.
     *
     * @return label name contact.
     */
    @Override
    public String getContactNameLbl(){
        return contactNameLbl.getText();
    }

    /**
     * get a element ValidateContact.
     *
     * @return link detailsLink.
     */
    @Override
    public void goToValidateContact() {
        driverTools.clickElement(detailsLink);
        //driverTools.clickElement(editBtn);
    }

    @Override
    public ContactForm goToEditContactForm() {
        driverTools.clickElement(detailsLink);
        driverTools.clickElement(editBtn);
        return new ContactFormLight();
    }

    /**
     * get a element Phone.
     *
     * @return TextBox name contact.
     */
    @Override
    public String getPhoneTextBox() {
        return phoneTextBox.getText();
    }

    /**
     * get a element name of contact create.
     *
     * @return label name contact.
     */
    @Override
    public String getFirstNameTextBox() {
        return firstNameTextBox.getText();
    }

    /**
     * get a element LastName.
     *
     * @return label Last Name.
     */
    @Override
    public String getLastNameTextBox() {
        return lastNameTextBox.getText();
    }

    /**
     * get a element name of Email.
     *
     * @return TextBox name Email.
     */
    @Override
    public String getEmailTextBox() {
        return emailTextBox.getText();
    }

    /**
     * get a element Other Street.
     *
     * @return TextBox OtherStreet.
     */
    @Override
    public String getOtherStreetTextBox() {
        return otherStreetTextBox.getText();
    }

    /**
     * get a element name of OtherCity.
     *
     * @return TextBox name contact.
     */
    @Override
    public String getOtherCityTextBox() {
        return otherCityTextBox.getText();
    }

    /**
     * get a element name of Other State.
     *
     * @return TextBox name OtherState.
     */
    @Override
    public String getOtherStateTextBox() {
        return otherStateTextBox.getText();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() { }
}
