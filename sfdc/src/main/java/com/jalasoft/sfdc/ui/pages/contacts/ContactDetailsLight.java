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

    private static final String NAME = "(//div[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon']//child::span)[1]";

    @FindBy(xpath = NAME)
    private WebElement contactNameLbl;

    /**
     * get a element name of contact create.
     *
     * @return label name contact.
     */
    @Override
    public String getContactNameLbl(){

        return contactNameLbl.getText();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() { }
}
