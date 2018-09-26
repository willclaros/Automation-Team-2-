package com.jalasoft.sfdc.ui.pages.contacts;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class ContactListPage extends BasePage {
    public abstract ContactForm goToContactNewForm();
    public abstract boolean isContactSelected(Contact contact);
    public abstract ContactDetails contactSelected(Contact contact);
}
