package com.jalasoft.sfdc.ui.pages.contacts;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class ContactListPage extends BasePage {
    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
    public abstract ContactForm goToContactNewForm();
    public abstract boolean isContactSelected(Contact contact);
}
