package com.jalasoft.sfdc.ui.pages.contacts;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Contact form Page classic class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactFormClassic extends ContactForm {

    private static final int MILLSECOND = 9000;

    @FindBy(css = "input#name_firstcon2")
    private WebElement firtNameTxtBox;

    @FindBy(css = "input#name_lastcon2")
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
    private WebElement streetTxtBox;

    @FindBy(css = "#con19zip")
    private WebElement MailingZipTxtBox;

    @FindBy(css = "#con19city")
    private WebElement cityTxtBox;

    @FindBy(css = "#con18state")
    private WebElement stateTxtBox;

    @FindBy(css = "#con18country")
    private WebElement countryTxtBox;


    @FindBy(xpath = "(//input[@title='Save'])[1]")
    private WebElement saveBtn;

    /**
     * fill all fields of contact form.
     *
     * @param contact - last name of the contact.
     * @return contact details type classic.
     */
    @Override
    public ContactDetails createContact(Contact contact) {
        driverTools.setInputField(firtNameTxtBox, contact.getFirstName());
        driverTools.setInputField(LastNameTxtBox, contact.getLastName());
        driverTools.setInputField(phoneTxtBox, contact.getHomePhone());
        driverTools.setInputField(titleTxtBox, contact.getTitle());
        driverTools.setInputField(emailTxtBox, contact.getEmail());
//        driverTools.setInputField(streetTxtBox, contact.getOtherStreet());
//        driverTools.setInputField(cityTxtBox, contact.getOtherCity());
//        driverTools.setInputField(stateTxtBox, contact.getOtherState());
//        driverTools.setInputField(countryTxtBox, contact.getOtherCountry());
        driverTools.clickElement(saveBtn);
        return new ContactDetailsClassic();
    }

    /**
     * fill all fields of edit contact form.
     *
     * @param contact - entity Contact.
     * @return contact details type classic.
     */
    @Override
    public ContactDetails editContact(Contact contact) {
        if (contact.getFirstName()!=null)
            driverTools.setInputField(firtNameTxtBox,contact.getFirstName());
        if (contact.getLastName()!=null)
            driverTools.setInputField(LastNameTxtBox,contact.getLastName());
        if (contact.getHomePhone()!=null)
            driverTools.setInputField(phoneTxtBox,contact.getHomePhone());
        if (contact.getTitle()!=null)
            driverTools.setInputField(titleTxtBox,contact.getTitle());
        if (contact.getEmail()!=null)
            driverTools.setInputField(emailTxtBox,contact.getEmail());
        if (contact.getOtherCity()!=null)
            driverTools.setInputField(cityTxtBox,contact.getOtherCity());
        if (contact.getOtherState()!=null)
            driverTools.setInputField(stateTxtBox,contact.getOtherState());
        if (contact.getOtherStreet()!=null)
            driverTools.setInputField(streetTxtBox,contact.getOtherStreet());
        if (contact.getOtherCountry()!=null)
            driverTools.setInputField(countryTxtBox,contact.getOtherCountry());
        driverTools.clickElement(saveBtn);
        driverTools.sleepMilliSeconds(MILLSECOND);
        return new ContactDetailsClassic();
    }

    /**
     * wait a element of actual page.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() { }
}
