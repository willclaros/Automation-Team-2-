package com.jalasoft.sfdc.ui.pages.pageContact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Contact details Page classic class.
 *
 * @author Yerel Hurtado
 * @since 09/10/2018
 */
public class ContactDetailsClassic extends ContactDetails {

    private static final String NAME_CONTACT = "h2.topName";

    @FindBy(css = NAME_CONTACT)
    private WebElement nameLbl;

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
    public void waitUntilPageObjectIsLoaded() { }
}
