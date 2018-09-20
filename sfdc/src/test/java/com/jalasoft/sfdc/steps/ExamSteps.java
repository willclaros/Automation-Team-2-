package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactDetails;
import com.jalasoft.sfdc.ui.pages.contacts.ContactForm;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExamSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ContactListPage contactListPage;
    private ContactDetails contactDetails;
    private ContactForm contactForm;
    private Contact contact;

    @When("^I go to   Contact  page$")
    public void iGoToContactPage() throws Throwable {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
        contactListPage = allAppsPage.goToContact();
    }

    @And("^I click on button  New$")
    public void iClickOnButtonNew() throws Throwable {
        contactForm = contactListPage.goToContactNewForm();
    }

    @And("^I fill all the following  information$")
    public void iFillAllTheFollowingInformation(List<Contact> contactList) throws Throwable {
        this.contact = contactList.get(0);
        contactDetails = contactForm.fillContactForm(contact);
    }

    @When("^I go to Contact edit page$")
    public void iGoToContactEditPage() throws Throwable {
        contactForm = this.contactDetails.goToEditContactNewForm();
    }

    @And("^I edit the following information in actual Contact$")
    public void iEditTheFollowingInformationInActualContact(List<Contact> contactList) throws Throwable {
        this.contact = contactList.get(0);
        contactDetails = contactForm.fillContactForm(contact);
    }

    @Then("^I should see the contact edited correctly$")
    public void iShouldSeeTheContactEditedCorrectly() throws Throwable {
        contactDetails.getValidateContact();
        assertEquals(contact.getFullName(), contactDetails.getContactNameLbl());
        assertEquals(contact.getHomePhone(), contactDetails.getPhoneTextBox());
        assertEquals(contact.getEmail(), contactDetails.getEmailTextBox());
    }

}
