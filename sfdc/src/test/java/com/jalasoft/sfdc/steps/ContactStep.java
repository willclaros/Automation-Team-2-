package com.jalasoft.sfdc.steps;


import com.jalasoft.sfdc.api.APIContact;
import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.entities.Product;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactDetails;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactForm;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ContactStep {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ContactListPage contactListPage;
    private ContactForm contactForm;
    private ContactDetails contactDetails;
    private Contact contact;

    private Contact contactAPI;
    private APIContact apiContact;

    /*private ContactStep (Contact contact) {
        this.contact = contact;
    }*/

    /**
     * go to contact page.
     */
    @When("^I go to Contact page$")
    public void iGoToContactPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        contactListPage = allAppsPage.goToContact();
    }

    /**
     * Navigates to the contact form.
     */
    @And("^I click New button$")
    public void iClickOnButtonNew() {
        contactForm = contactListPage.goToContactNewForm();
    }


    /**
     * @param contactList list of contact list.
     */
    @When("^I create a Contact with the following information")
    public void iFillAllTheFollowingInformation(List<Contact> contactList) {
        this.contact = contactList.get(0);
//        contact.setLastName(contactList.get(0).getLastName());
//        contactDetails = contactForm.createContact(contact);
        apiContact = new APIContact(contact);
        apiContact.createContactByAPI();
    }


    /**
     * verify contact field correct.
     */
    @Then("^I should see the contact created correctly$")
    public void iShouldSeeTheContactCreatedCorrectly() {
//        contactDetails.goToValidateContact();
//        assertEquals(contact.getFullName(), contactDetails.getContactNameLbl());
//        assertEquals(contact.getHomePhone(), contactDetails.getPhoneTextBox());
//        assertEquals(contact.getEmail(), contactDetails.getEmailTextBox());

        contactAPI = apiContact.getContactValuesByAPI();
        assertEquals(contact.getLastName(), contactAPI.getLastName());
        assertEquals(contact.getEmail(), contactAPI.getEmail());
        //assertEquals(contact.getLastName(), contactDetails.getLastNameTextBox());
        //assertEquals(contact.getFirstName(), contactDetails.getFirstNameTextBox());
        //assertEquals(contact.getOtherStreet(), contactDetails.getOtherStreetTextBox());
        //assertEquals(contact.getOtherCity(), contactDetails.getOtherCityTextBox());
        //assertEquals(contact.getOtherState(), contactDetails.getOtherStateTextBox());
    }

    /**
     * Navigates to the contact form.
     */
    @And("^I go to Contact edit page$")
    public void iGoToContactEditPage() {
        contactForm = contactDetails.goToEditContactForm();
    }

    /**
     * edit actual information of contact.
     *
     * @param contactListEdit - list of contact.
     */
    @And("^I edit the following information in actual Contact$")
    public void iEditTheFollowingInformationInActualContact(List<Contact> contactListEdit) {
        this.contact = contactListEdit.get(0);
        contact.setLastName(contactListEdit.get(0).getLastName());
        contactDetails = contactForm.editContact(contact);
    }

    /**
     * validate fields of edit contact.
     */
    @Then("^I should see the contact edited correctly$")
    public void iShouldSeeTheContactEditedCorrectly() {
        contactDetails.goToValidateContact();
        assertEquals(contact.getFullName(), contactDetails.getContactNameLbl());
        assertEquals(contact.getHomePhone(), contactDetails.getPhoneTextBox());
        assertEquals(contact.getEmail(), contactDetails.getEmailTextBox());
    }

    /**
     * Navigates to the contact list page.
     */
    @Then("^I delete this Contact create$")
    public void iShouldSeeTheContactIsDelete() {
        apiContact.deleteContactByAPI();
        //contactListPage = contactDetails.goToDeleteContact();
    }

    /**
     * validate if contact create is delete.
     */
    @Then("^I should see the actual Contact is delete$")
    public void iShouldSeeTheActualContactIsDelete() {
        assertFalse(contactListPage.isContactSelected(contact));
    }
}
