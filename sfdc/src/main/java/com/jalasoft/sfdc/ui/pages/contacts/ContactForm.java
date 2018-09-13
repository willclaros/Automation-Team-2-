package com.jalasoft.sfdc.ui.pages.contacts;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.BasePage;

public abstract class ContactForm extends BasePage {
    public abstract ContactDetails fillContactForm(Contact contact);
}
