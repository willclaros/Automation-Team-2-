package com.jalasoft.sfdc.ui.pages.contacts;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Contact details Page classic class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactDetailsClassic extends ContactDetails {

    public final static int NUMBER_ONE = 1;
    public final static String SLASH = "/";
    @FindBy(css = "//span[text()='Details']")
    private WebElement detailsLbl;

    @FindBy(css = "#con2_ileinner")
    private WebElement nameLbl;

    @FindBy(css = "#con10_ileinner")
    private WebElement phoneTextBox;

    @FindBy(css = "#con15_ileinner a")
    private WebElement emailTextBox;

    @FindBy(css = "#topButtonRow input[title=Edit]")
    private WebElement editBtn;

    @FindBy(css = "#topButtonRow input[value='Delete']")
    private WebElement deleteBtn;

    /**
     * get a element name of contact create.
     *
     * @return label name contact.
     */
    @Override
    public String getContactNameLbl() {
        return nameLbl.getText();
    }

    /**
     *go to page validate contact.
     */
    @Override
    public void goToValidateContact(Contact contact) {
        contact.setId(getUrlCurrent(driver.getCurrentUrl()));
        System.out.println(getUrlCurrent(driver.getCurrentUrl()));
    }

    /**
     * get url of contact.
     *
     * @param currentUrl - url of actual contact created.
     * @return Id of contact created.
     */
    private String getUrlCurrent(String currentUrl) {
        String[] currentUrlList = currentUrl.split(SLASH);
        String idUrl = currentUrlList[currentUrlList.length - NUMBER_ONE];
        return idUrl;
    }

    /**
     * go to page edit contact form.
     *
     * @return contact of form type classic.
     */
    @Override
    public ContactForm goToEditContactForm() {
        driverTools.clickElement(editBtn);
        return new ContactFormClassic();
    }

    /**
     * get phone of text box.
     *
     * @return phone of text box.
     */
    @Override
    public String getPhoneTextBox() {
        return phoneTextBox.getText();
    }

    /**
     * get first name of text box.
     *
     * @return first name of contact.
     */
    @Override
    public String getFirstNameTextBox() {
        return null;
    }

    /**
     *
     *
     * @return
     */
    @Override
    public String getLastNameTextBox() {
        return null;
    }

    /**
     * get email of text box.
     *
     * @return email of contact.
     */
    @Override
    public String getEmailTextBox() {
        return emailTextBox.getText();
    }

    /**
     * get other Street of text box.
     *
     * @return other street of contact.
     */
    @Override
    public String getOtherStreetTextBox() {
        return null;
    }

    /**
     * get other city of text box.
     *
     * @return other city of contact.
     */
    @Override
    public String getOtherCityTextBox() {
        return null;
    }

    /**
     * get other state of text box.
     *
     * @return other state contact.
     */
    @Override
    public String getOtherStateTextBox() {
        return null;
    }

    /**
     * go to delete contact.
     *
     * @return a new contact list page classic.
     */
    @Override
    public ContactListPage goToDeleteContact() {
        driverTools.clickElement(deleteBtn);
        acceptAlertDialog();
        return new ContactListPageClassic();
    }


    /**
     * wait a element of actual page.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
