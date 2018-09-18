package com.jalasoft.sfdc.ui.pages.contacts;

import com.jalasoft.sfdc.entities.Contact;
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

    @FindBy(css = "input#name_firstcon2")
    private WebElement firtNameTxtBox;

    @FindBy(css = LAST_NAME)
    private WebElement LastNameTxtBox;

    @FindBy(css = "#con4")
    private WebElement accountNameTxtBox;

    @FindBy(css = "#con5")
    private WebElement titleTxtBox;

    @FindBy(css = "#con6")
    private WebElement departamentTxtBox;

    @FindBy(css = "#con7")
    private WebElement birhdateTxtBox;

    @FindBy(css = "#con8")
    private WebElement reportToTxtBox;

    @FindBy(css = "#con10")
    private WebElement phoneTxtBox;

    @FindBy(css = "#con13")
    private WebElement homePhoneTxtBox;

    @FindBy(css = "#con12")
    private WebElement mobileTxtBox;

    @FindBy(css = "#con14")
    private WebElement otherPhoneTxtBox;

    @FindBy(css = "#con11")
    private WebElement faxTxtBox;

    @FindBy(css = "#con15")
    private WebElement emailTxtBox;

    @FindBy(css = "#con16")
    private WebElement assistantTxtBox;

    @FindBy(css = "#con17")
    private WebElement asstPhoneTxtBox;

    @FindBy(css = "#con19street")
    private WebElement mailingStreetTxtBox;

    @FindBy(css = "#con19zip")
    private WebElement MailingZipTxtBox;

    @FindBy(css = "#con19city")
    private WebElement mailingCityTxtBox;

    @FindBy(xpath = SAVE)
    private WebElement saveBtn;

    /**
     * fill all fields of contact form.
     *
     * @param contact - last name of the contact.
     * @return contact details type light.
     */
    @Override
    public ContactDetails createContact(Contact contact) {
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        driverTools.setInputField(firtNameTxtBox, contact.getFirstName());
        driverTools.setInputField(LastNameTxtBox, contact.getLastName());
        //driverTools.setInputField(accountNameTxtBox, contact.getAccountName());
        driverTools.setInputField(titleTxtBox, contact.getTitle());
        driverTools.setInputField(departamentTxtBox, contact.getDepartament());
        driverTools.setInputField(phoneTxtBox, contact.getAsstPhone());
        driverTools.setInputField(reportToTxtBox, contact.getReportTo());
        driverTools.setInputField(homePhoneTxtBox, contact.getHomePhone());
        driverTools.setInputField(mobileTxtBox, contact.getMobile());
        driverTools.setInputField(otherPhoneTxtBox, contact.getOtherPhone());
        driverTools.setInputField(faxTxtBox, contact.getFax());
        driverTools.setInputField(emailTxtBox, contact.getEmail());
        driverTools.clickElement(saveBtn);
        return new ContactDetailsClassic();
    }

    @Override
    public ContactDetails editContact(Contact contact) {
        return null;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() { }
}
