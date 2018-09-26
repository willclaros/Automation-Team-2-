package com.jalasoft.sfdc.steps;


import com.jalasoft.sfdc.api.APIContact;
import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactDetails;
import com.jalasoft.sfdc.ui.pages.contacts.ContactForm;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.*;


public class ContactStep {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ContactListPage contactListPage;
    private ContactForm contactForm;
    private ContactDetails contactDetails;
    private Contact contact;
    private Contact contactAPI;
    private APIContact apiContact;
    private Response response;

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
    @And("^I click New button for create Contact$")
    public void iClickOnButtonNew() {
        contactForm = contactListPage.goToContactNewForm();
    }

    /**
     * @param contactList list of contact list.
     */
    @When("^I create a Contact with the following information")
    public void iFillAllTheFollowingInformation(List<Contact> contactList) {
        this.contact = contactList.get(0);
        apiContact = new APIContact(contact);
        contact.setLastName(contactList.get(0).getLastName());
        contactDetails = contactForm.createContact(contact);
    }

    /**
     * verify contact field correct.
     */
    @Then("^I should see the created Contact displayed in Contact Details page$")
    public void iShouldSeeTheContactCreatedCorrectly() {
        contactDetails.goToValidateContact(contact);
        assertEquals(contact.getFullName(), contactDetails.getContactNameLbl());
        assertEquals(contact.getHomePhone(), contactDetails.getPhoneTextBox());
        assertEquals(contact.getEmail(), contactDetails.getEmailTextBox());
    }

    /**
     *  verify if contact is save.
     */
    @And("^the Contact should be saved$")
    public void iShouldSeeTheContactCreate() {
        contactAPI = apiContact.getContactValuesByAPI();
        assertEquals(contact.getLastName(), contactAPI.getLastName());
        assertEquals(contact.getEmail(), contactAPI.getEmail());
    }

    /**
     * select respective contact.
     */
    @And("^I select the Contact$")
    public void iSelectTheContact() {
        contactDetails = contactListPage.contactSelected(contact);
    }

    /**
     * Navigates to the contact form.
     */
    @And("^I go to Contact Edit page$")
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
    @Then("^I should see the edited Contact displayed in Contact Details page$")
    public void iShouldSeeTheContactEditedCorrectly() {
        contactDetails.goToValidateContact(contact);
        assertEquals(contact.getFullName(), contactDetails.getContactNameLbl());
        assertEquals(contact.getHomePhone(), contactDetails.getPhoneTextBox());
        assertEquals(contact.getEmail(), contactDetails.getEmailTextBox());
    }

    /**
     * Navigates to the contact list page.
     */
    @Then("^I delete the Contact created$")
    public void iShouldSeeTheContactIsDelete() {
        //response = apiContact.deleteContactByAPI();
        contactListPage = contactDetails.goToDeleteContact();
    }

    /**
     * validate if contact create is delete.
     */
    @Then("^I should see the actual Contact deleted$")
    public void iShouldSeeTheActualContactIsDelete() {
        assertFalse(contactListPage.isContactSelected(contact));
    }

    @When("^I have created the Contact with the following information fill$")
    public void iCreateTheContactWithTheFollowingInformation(List<Contact> contactList) {
        this.contact = contactList.get(0);
        //contact.setLastName(contact.getLastName());
        contact.updateProductName();
        apiContact = new APIContact(contact);
        response = apiContact.createContactByAPI();
    }

    /**
     * verify if contact is deleted.
     */
    @And("^the Contact should be deleted$")
    public void theContactShouldBeDeleted() {
        assertTrue(response.asString().isEmpty());
    }

    //****************************************************************
    //Hooks for @afterContactDelete scenarios
    //****************************************************************
    @After(value = "@afterContactDelete", order = 999)
    public void afterDeleteContact(){
        apiContact.deleteContactByAPI();
    }

    /**
     * the contact verify update.
     */
    @And("^the Contact should be updated$")
    public void theContactShouldBeUpdated() {
        contactAPI = apiContact.getContactValuesByAPI();
        assertEquals(contact.getLastName(), contactAPI.getLastName());
        assertEquals(contact.getEmail(), contactAPI.getEmail());
    }
}
