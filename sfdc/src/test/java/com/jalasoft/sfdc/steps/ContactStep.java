package com.jalasoft.sfdc.steps;


import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.allappspage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactDetails;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.contacts.ContactForm;
import com.jalasoft.sfdc.ui.pages.contacts.ContactListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ContactStep {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private ContactListPage contactListPage;
    private ContactForm newContactForm;
    private ContactDetails contactDetails;

    @When("^I go to app list Contact$")
    public void iGoToAppListContact() throws Throwable {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllPages();
    }

    @And("^I go to Contact page$")
    public void iGoToContactPage() throws Throwable {
        contactListPage = allAppsPage.goToContact();
    }

    @And("^I click on button New$")
    public void iClickOnButtonNew() throws Throwable {
        newContactForm = contactListPage.goToContactNewForm();
    }


    @And("^I fill all the following information \"([^\"]*)\"$")
    public void iFillAllTheFollowingInformation(String lastName) throws Throwable {
        contactDetails = newContactForm.fillContactForm(lastName);
    }


    @Then("^I should see the contact created correctly \"([^\"]*)\"$")
    public void iShouldSeeTheContactCreatedCorrectly(String lastName) throws Throwable {
        assertEquals(lastName, contactDetails.getContactNameLbl());
    }
}
