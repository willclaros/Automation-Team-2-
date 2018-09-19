package com.jalasoft.sfdc.steps;


import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactDetails;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactForm;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContactStep {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ContactListPage contactListPage;
    private ContactForm contactForm;
    private ContactDetails contactDetails;
    private Contact contact;

    /*private ContactStep (Contact contact) {
        this.contact = contact;
    }*/


    @When("^I go to Contact page$")
    public void iGoToContactPage() throws Throwable {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        contactListPage = allAppsPage.goToContact();
    }

    @And("^I click New button$")
    public void iClickOnButtonNew() throws Throwable {
        contactForm = contactListPage.goToContactNewForm();
    }


    @When("^I create a Contact with the following information")
    public void iFillAllTheFollowingInformation(List<Contact> contactList) {
        this.contact = contactList.get(0);
        contact.setLastName(contactList.get(0).getLastName());
        contactDetails = contactForm.createContact(contact);
    }


    @Then("^I should see the contact created correctly$")
    public void iShouldSeeTheContactCreatedCorrectly() {
        contactDetails.goToValidateContact();
        assertEquals(contact.getFullName(), contactDetails.getContactNameLbl());
        //assertEquals(contact.getLastName(), contactDetails.getLastNameTextBox());
        assertEquals(contact.getHomePhone(), contactDetails.getPhoneTextBox());
        //assertEquals(contact.getFirstName(), contactDetails.getFirstNameTextBox());
        assertEquals(contact.getEmail(), contactDetails.getEmailTextBox());
        //assertEquals(contact.getOtherStreet(), contactDetails.getOtherStreetTextBox());
        //assertEquals(contact.getOtherCity(), contactDetails.getOtherCityTextBox());
        //assertEquals(contact.getOtherState(), contactDetails.getOtherStateTextBox());
    }

    @And("^I go to Contact edit page$")
    public void iGoToContactEditPage() {
        contactForm = contactDetails.goToEditContactForm();
    }

    @And("^I edit the following information in actual Contact$")
    public void iEditTheFollowingInformationInActualContact(List<Contact> contactListEdit) {
        this.contact = contactListEdit.get(0);
        contact.setLastName(contactListEdit.get(0).getLastName());
        contactDetails = contactForm.editContact(contact);
    }

    @Then("^I should see the contact edited correctly$")
    public void iShouldSeeTheContactEditedCorrectly() {
        contactDetails.goToValidateContact();
        assertEquals(contact.getFullName(), contactDetails.getContactNameLbl());
        assertEquals(contact.getHomePhone(), contactDetails.getPhoneTextBox());
        assertEquals(contact.getEmail(), contactDetails.getEmailTextBox());
    }

    @Then("^I delete this Contact create$")
    public void iShouldSeeTheContactIsDelete() throws Throwable {
        contactListPage = contactDetails.goToDeleteContact();
    }

    @Then("^I should see the actual Contact is delete$")
    public void iShouldSeeTheActualContactIsDelete() throws Throwable {
        assertFalse(contactListPage.isContactSelected(contact));
    }
}
